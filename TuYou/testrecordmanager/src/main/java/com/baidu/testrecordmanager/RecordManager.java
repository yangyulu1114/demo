package com.baidu.testrecordmanager;

import java.util.List;

public interface RecordManager {

    void offerRecord(Record record);

    boolean removeRecord(Record record);

    List<Record> loadAllRecords();
}
