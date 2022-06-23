package com;

import java.io.*;
import java.util.List;
import java.util.Scanner;

//普通用户类继承Person
class User extends Person implements operate {

    User(String name,String sex,int age){

        //调用父类Person的构造方法
        super(name,sex,age);

    }

//    获取用户输入信息
    Scanner sc =  new Scanner(System.in);

    @Override
    public void operate(List<Book> books, int i) {
        switch(i){
            case 1:
                //查询图书功能
                select(books);
                break;

            case 2:
                //借阅图书功能
                delete(books);
                break;

            case 3:
                //返还图书功能
                add(books);
                break;

                //显示集合中的书的信息
            case 4:
                list(books);
                break;

            //将文件保存为book.txt ,实现保存书籍信息至txt操作
            case 5:
                FileSaveTxt(books);
                break;

            //文件写入操作，将data.dat中的数据写入集合，既 “联网”
            case 9:
                FileRead();
                break;

            default:
                System.out.println("输入有误！");
        }
    }

//书籍查找功能
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
                            return;
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

                        }
                    }
                    System.out.println("查询结束!");
                }
                break;

            default:
                System.out.println("输入有误！");
        }
    }

    //借书功能的实现
    @Override
    public void delete(List<Book> books) {
        System.out.println("请输入要借阅的书名:");
        String name1 = sc.next();
        if (name1 != null) {
            for (Book book : books) {
                if (book.getName().equals(name1)) {
                    if (book.isState()) {
                        book.setState(false);
                        System.out.println("借阅成功！");
                       break;
                    } else {
                        System.out.println("已被借阅！");
                        break;
                    }
                }
            }
        }
    }

    //还书功能的实现
    @Override
    public void add(List<Book> books) {
        System.out.println("请输入要还的书名：");
        String name = sc.next();
        //通过书名进行还书
        if (name != null) {
            for (Book book : books) {
                if (book.getName().equals(name) && !book.isState()) {
                    book.setState(true);
                    System.out.println("还书成功！");
                    return;
                }
            }
            System.out.println("还书错误！");
        }
    }

    @Override
    public void FileSave(List<Book> books) {

    }

    //将文件保存为book.txt ,实现保存书籍信息至txt操作
    @Override
    public void FileSaveTxt(List<Book> books) {
        try {
                //将文件保存为book.txt
                File file = new File("book.txt");
                FileWriter fileWriter = new FileWriter(file);
                //将写入转化为流的形式
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (Book book : books) {

                    bufferedWriter.write(String.valueOf(book));
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    //清空缓冲区
                }
                bufferedWriter.close();
                 //关闭读写流
            System.out.println("保存书籍信息成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    //文件读取功能，将data.dat中的数据读入集合book中，实现“联网”操作
    static File file = new File("data.dat");
    @Override
    public List<Book> FileRead () {

        try {
            //创建文件输入流对象
            FileInputStream fin=new FileInputStream(file);

            //创建缓冲区输入流对象
            BufferedInputStream bin=new BufferedInputStream(fin);//加速

            //创建对象输入流
            ObjectInputStream objin=new ObjectInputStream(bin);

            //将对象输入流的中的对象读给List集合
            System.out.println("联网成功！书库信息已获取！");

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

    //显示集合中的书的信息
    @Override
    public void list(List<Book> books) {
        System.out.println("图书列表如下：");
        //打印Book集合
        for (Book book : books) {
            System.out.println("书名："+book.getName()+"   作者："+book.getAuthor()+ "    价格："+book.getPrice()+"  分类："+book.getCategory()+"   状态："+book.isState());
        }
    }
}
