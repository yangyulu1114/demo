package com.baidu.assignment9;

import java.io.Serializable;

public class Woman implements Serializable {
    private String nike;
    private int height;

    @Override
    public String toString() {
        return "Woman{" +
                "nike='" + nike + '\'' +
                ", height=" + height +
                '}';
    }

    public String getNike() {
        return nike;
    }

    public void setNike(String nike) {
        this.nike = nike;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
