package com;

import java.io.*;
import java.util.*;

import static java.util.Arrays.sort;

//管理员类继承Person
public class Root extends Person implements operate{
    private Object List;

    Root(String name, String sex, int age) {

        super(name, sex, age);
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void operate(List<Book> books, int i) {
        switch (i) {
            case 1:
                //根据价格对图书馆中的书进行整理
                sort(books);
                break;

            //对书进行查询操作
            case 2:
                select(books);
                break;

            //对书进行添加操作
            case 3:
                add(books);
                break;

            //对书进行删除操作
            case 4:
                delete(books);
                break;

            //显示集合中的书的信息
            case 5:
                list(books);
                break;

            //文件保存功能,保存一个data.dat文件，实现书库信息更新
            case 6:
                FileSave(books);
                break;

            //文件读取功能，将data.dat文件读入集合，实现书库信息导入图书管理系统
            case 7:
                FileRead();
                break;

            default:
                System.out.println("输入有误！");
        }
    }

    //根据价格对图书馆中的书进行整理
    public void sort(List<Book> books) {
        System.out.println("图书馆中的书按价格整理:");
        class BookComparator implements Comparator<Book>{

            @Override
            public int compare(Book o1, Book o2) {
                return (int)(o1.getPrice() - o2.getPrice());
            }
        }
        Collections.sort(books, new BookComparator());
        System.out.println("整理结束！");

    }

    //对书进行查询操作
    @Override
    public void select(List<Book> books) {
        System.out.println("请选择你要查询的方式：");
        System.out.println("1.通过书名查询");
        System.out.println("2.通过作者查询");
        System.out.println("3.通过种类查询");
        int k = sc.nextInt();

        switch (k) {

            //    根据书名进行查询
            case 1:
                System.out.println("请输入你要查询书籍的书名：");
                String name1 = sc.next();
                if (name1 != null) {
                    for (Book book : books) {
                        if (book.getName().equals(name1)) {
                            System.out.println("有此书籍！");
                            System.out.println("书名：" + book.getName() + "   作者：" + book.getAuthor() + "   价格：" + book.getPrice() + "   分类：" + book.getCategory() + "   状态：" + book.isState());
                            return;
                        }
                    }
                    System.out.println("暂时没有此书！");
                }
                break;

            //    根据作者进行查询
            case 2:
                System.out.println("请输入你要查询书籍的作者：");
                String author1 = sc.next();
                if (author1 != null) {
                    for (Book book : books) {
                        if (book.getAuthor().equals(author1)) {
                            System.out.println("有此书籍！");
                            System.out.println("书名：" + book.getName() + "   作者：" + book.getAuthor() + "   价格：" + book.getPrice() + "   分类：" + book.getCategory() + "   状态：" + book.isState());
                        }
                    }
                    System.out.println("暂时没有此书！");
                }
                break;

            //    根据种类进行查询
            case 3:
                System.out.println("请输入你要查询书籍的种类：");
                String cater1 = sc.next();
                if (cater1 != null) {
                    for (Book book : books) {
                        if (book.getCategory().equals(cater1)) {
                            System.out.println("有此书籍！");
                            System.out.println("书名：" + book.getName() + "   作者：" + book.getAuthor() + "   价格：" + book.getPrice() + "   分类：" + book.getCategory() + "   状态：" + book.isState());
//                            return;
                        }
                    }
                    System.out.println("暂时没有此书！");
                }
                break;

            default:
                System.out.println("输入有误！");
        }
    }

    //对书进行添加操作
    @Override
    public void add (List < Book > books) {

        System.out.println("请输入书名：");
        String name = sc.next();
        System.out.println("请输入作者：");
        String author = sc.next();
        System.out.println("请输入价格：");
        int price = sc.nextInt();
        System.out.println("请输入种类：");
        String category = sc.next();

        books.add(new Book(name, author, price, category, true));
        //添加书籍的默认状态是ture - 未被借出
        System.out.println("添加书籍成功！");

    }

    //对书进行删除操作
    @Override
        public void delete (List<Book> books){
            System.out.println("请输入要删除的书名:");
            String str = sc.next();
            if (str != null) {
                for (Book book : books) {
                    if (book.getName().equals(str)) {
                        books.remove(book);
                        System.out.println("删除成功！");
                        return;
                    }
                }
                System.out.println("无此书籍！");
            }
        }



    static File file = new File("data.dat");

//    书库信息更新（文件保存）
//    书库通过管理员添加新书籍后，可进行文件保存
//通过文件保存功能,保存到 date.dat ，实现书库信息更新
        public void FileSave (List < Book > books) {
            //异常处理
            try {

                //创建文件输出流对象
                FileOutputStream fout=new FileOutputStream(file);

                //创建缓冲区输出流对象
                BufferedOutputStream bout=new BufferedOutputStream(fout);//加速

                //创建对象输出流
                ObjectOutputStream objOut=new ObjectOutputStream(bout);

                objOut.writeObject(books);//将图书集合对象输出到文件保存

                objOut.flush();
                objOut.close();
                System.out.println("图书信息写出到文件成功！");
                System.out.println("书库更新成功！");

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    //书库信息获取（文件读取）
    //文件读取功能，将 date.dat 文件读入集合，实现书库信息导入图书信息管理系统
    public List<Book> FileRead () {
            //异常处理
        try {
            //创建文件输入流对象
            FileInputStream fin=new FileInputStream(file);

            //创建缓冲区输入流对象
            BufferedInputStream bin=new BufferedInputStream(fin);//加速

            //创建对象输入流
            ObjectInputStream objin=new ObjectInputStream(bin);

            //将对象输入流的中的对象读给List集合

            System.out.println("书库信息获取成功！");
            return Library.books=(List<Book>) objin.readObject();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("");
        return Library.books;
    }

    @Override
    public void FileSaveTxt(List<Book> books) {

    }

    //显示集合中的书的信息
        public void list (List < Book > books) {
            System.out.println("图书列表如下：");
            //打印Book集合
            for (Book book : books) {
                System.out.println("书名：" + book.getName() + "   作者：" + book.getAuthor() + "   价格：" + book.getPrice() + "   分类：" + book.getCategory() + "   状态：" + book.isState());
            }
        }
    }




