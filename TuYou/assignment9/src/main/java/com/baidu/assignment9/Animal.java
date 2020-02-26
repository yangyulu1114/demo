package com.baidu.assignment9;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Animal implements Parcelable {

    private String name;

    private int age;

    private double f;

    private String work;

    private List<String> names;

    private Student[] students;

    private Map<String, Student> map;

    protected Animal(Parcel in) {
        name = in.readString();
        age = in.readInt();
        f = in.readDouble();
        work = in.readString();
        int len = in.readInt();
        names = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            names.add(in.readString());
        }
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeDouble(f);
        dest.writeString(work);
        dest.writeInt(name.length());
        for (String s : names) {
            dest.writeString(s);
        }
    }
}
