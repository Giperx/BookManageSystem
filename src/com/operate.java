package com;

import java.util.List;

//operate 分别在Root类和User类 中进行了重写
public interface operate {

    void select(List<Book> books);

    //delete方法在User中重写后，为借书功能
    //在Root中重写后为删除功能
    void delete(List<Book> books);

    //add方法在User中重写后，为还书功能
    //在Root中重写后为添加图书功能
    void add(List<Book> books);

    void list(List<Book> books);

    //文件保存功能data.dat   对象流
    void FileSave(List<Book> books);

    void FileSaveTxt(List<Book> books);

    //文件写入功能data.dat  对象流
    List<Book> FileRead ();
}

