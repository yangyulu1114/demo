package com.baidu.testrecordmanager;

import java.util.List;

public interface RecordManager {

    void offerRecord(Record record);

    void removeRecord(Record record);

    void loadAllRecords(CallBack<List<Record>> callBack);

    void getRecord(String key, CallBack<Record> callBack);

    void clearAll();
}
