package com.baidu.testrecordmanager;

public interface CallBack<T> {
    void getRecords(T records);
}