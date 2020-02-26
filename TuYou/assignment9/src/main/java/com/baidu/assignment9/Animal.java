package com.baidu.assignment9;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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


    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", f=" + f +
                ", work='" + work + '\'' +
                ", names=" + names +
                ", students=" + Arrays.toString(students) +
                ", map=" + map +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Map<String, Student> getMap() {
        return map;
    }

    public void setMap(Map<String, Student> map) {
        this.map = map;
    }

    public Animal() {
    }

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
//        int len2 = in.readInt();
//        students = new Student[len2];
//        for (int i = 0; i < len2; i++) {
//            students[i] = in.readParcelable(Student.class.getClassLoader());
//        }
//        students = in.readParcelableArray(getClass().getClassLoader());
        students = in.createTypedArray(Student.CREATOR);

        map = new HashMap<>();
        in.readMap(map, getClass().getClassLoader());
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
        dest.writeInt(names.size());
        for (String s : names) {
            dest.writeString(s);
        }

//        dest.writeParcelableArray(students, flags);
        dest.writeTypedArray(students, flags);


//        if (students == null) {
//            dest.writeInt(0);
//        } else {
//            dest.writeInt(students.length);
//        }
//        if (students != null) {
//            dest.writeParcelableArray(students, flags);
//        }
        dest.writeMap(map);
    }
}
