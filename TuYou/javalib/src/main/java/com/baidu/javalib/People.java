package com.baidu.javalib;

public class People {

    private String name;

    private String work;

    public int age;

    public People() {}

    private People(String name) {
        System.out.println("init called");
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setWork(String work) {
        this.work = work;
    }

    private void setInformation(String name, int age) {
        setName(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", work='" + work + '\'' +
                ", age=" + age +
                '}';
    }
}
