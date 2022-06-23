package com;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//图书库类
public class Library {


    //构建图书集合books
    static List<Book> books = new ArrayList<>();

    Scanner sc = new Scanner(System.in);


//图书信息管理系统的首界面
    public void login(){
        int count = 0;
        Person p = null;
        while(count<2){
            System.out.println("================================================");
            System.out.println("=                                              =");
            System.out.println("=               图书信息管理系统                =");
            System.out.println("=                                              =");
            System.out.println("================================================");
            System.out.println("=                                              =");
            System.out.println("=                **请选择登录对象**             =");
            System.out.println("=                   1.普通用户                  =");
            System.out.println("=                   2.管理员                    =");
            System.out.println("=                                               =");
            System.out.println("================================================");
            System.out.println("=                   3.退出系统                  =");
            System.out.println("=                   4.关于                      =");
            System.out.println("================================================");



            int n = sc.nextInt();

            if(n == 3){
                return;
            }


            switch(n){

                //进入普通用户操作界面
                case 1:
                    System.out.println("请输入姓名：");
                    String Uname = sc.next();
                    //获取用户的姓名
                    
                    System.out.println("请输入性别：");
                    String Usex = sc.next();
                    //获取性别
                    
                    System.out.println("请输入年龄：");
                    int Uage = sc.nextInt();
                    //获取年龄

                    //构造普通用户对象
                    p = new User(Uname,Usex,Uage);

                    System.out.println("登录成功！");
                    System.out.println("当前用户为普通用户："+" 姓名：" + p.getName() + " "+" 性别：" + p.getSex() + " "+" 年龄："+ p.getAge());
                    System.out.println(" ");
                    System.out.println("请输入9连接网络！");
                    int i = sc.nextInt();
                    p.operate(books,i);

                    //普通用户的循环操作
                    while (true) {
                        System.out.println("");
                        System.out.println("================================================");
                        System.out.println("=             用户你好！                        =");
                        System.out.println("=             请选择你的功能：                  =");
                        System.out.println("=                                              =");
                        System.out.println("=             1.查询书籍信息                    =");
                        System.out.println("=             2.借阅书籍                        =");
                        System.out.println("=             3.归还书籍                        =");
                        System.out.println("=             4.显示书籍列表                    =");
                        System.out.println("=             5.保存书籍信息至txt               =");
                        System.out.println("=             6.退出                            =");
                        System.out.println("================================================");
                        System.out.println("");

                         i = sc.nextInt();
                        if (i == 6) {
                            System.out.println("您已成功退出！");
                            break;
                        }else {
                            p.operate(books,i);
                            //调用普通用户的操作方法
                        }
                    }
                    break;

                //进入管理员操作界面
                case 2:
                    System.out.println("请输入管理员姓名：");
                    String Rname = sc.next();
                    System.out.println("请输入性别：");
                    String Rsex = sc.next();
                    System.out.println("请输入年龄：");
                    int Rage = sc.nextInt();

                    //构造管理员对象，并传递管理员信息
                    p = new Root(Rname,Rsex,Rage);

                    System.out.println("登录成功！");
                    System.out.println("当前管理员："+" 姓名：" + p.getName() + " "+" 性别：" + p.getSex() + " "+" 年龄：" + p.getAge());
                    while (true) {
                        System.out.println("");
                        System.out.println("================================================");
                        System.out.println("=                管理员你好！                   =");
                        System.out.println("=             请选择你的功能：                  =");
                        System.out.println("=                                              =");
                        System.out.println("=             1.整理书籍                        =");
                        System.out.println("=             2.查询书籍信息                    =");
                        System.out.println("=             3.增加书籍                        =");
                        System.out.println("=             4.删除书籍                        =");
                        System.out.println("=             5.显示书籍列表                    =");
                        System.out.println("=             6.书库信息更新（文件保存）         =");
                        System.out.println("=             7.书库信息获取（文件读取）         =");
                        System.out.println("=             8.退出                            =");
                        System.out.println("================================================");
                        System.out.println("");
                        System.out.println("请选择你的功能：");

                        int j = sc.nextInt();
                        if (j == 8) {
                            System.out.println("您已成功退出！");
                            break;
                        }else{

                            //调用管理员的操作方法
                            p.operate(books,j);
                        }

                    } break;

                case 4:
                    System.out.println("===================================");
                    System.out.println("============**关于**===============");
                    System.out.println("===================================");
                    System.out.println("= 程序名称：图书信息管理系统        =");
                    System.out.println("= 版本V2.0                         =");
                    System.out.println("= 完成时间：2021.6.17              =");
                    System.out.println("= 完成人：Giperx                   =");
                    System.out.println("=                                 =");
                    System.out.println("===================================");

                    break;
            }
        }
    }
}
//        我的自评分是85分。
//        我的理由是我这个图书信息管理系统完成了大作业的任务要求，
//        具备菜单功能，面向对象程序设计，运用了多态等机制，也有文件读写功能。
//        此外还用了集合框架，用来保存书籍信息，而且这个系统可一保存上一次程序运行 后对书库信息的影响。