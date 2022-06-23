package com;

import java.util.List;

abstract class Person {
    private String name;
    //姓名
    private String sex;
    //性别
    private int age;
    //年龄


    Person(String name,String sex,int age) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }


    public String getName() {

        return name;
    }

    public String getSex() {

        return sex;
    }

    public int getAge() {

        return age;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setSex(String sex) {

        this.sex = sex;
    }

    public void setAge(int age) {

        this.age = age;
    }
    public abstract void operate(List<Book> books, int i);
}

