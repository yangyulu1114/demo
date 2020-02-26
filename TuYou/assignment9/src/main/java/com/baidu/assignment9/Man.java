package com.baidu.assignment9;

import java.io.Serializable;

public class Man implements Serializable {
    private String name;
    private int age;
    private Woman woman;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Woman getWoman() {
        return woman;
    }

    public void setWoman(Woman woman) {
        this.woman = woman;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", woman=" + woman +
                '}';
    }
}
