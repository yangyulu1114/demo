package com.baidu.testrecordmanager;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RecordManagerImplements implements RecordManager {
    private File dir;
    private File file;
    private List<Record> records;
    public RecordManagerImplements(Context context) throws IOException {
        dir = context.getExternalFilesDir("recordmanager");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        file = new File(dir, "records.txt");
        Log.v("bush", file.getAbsolutePath());
        records = new ArrayList<>();
    }

    @Override
    public void offerRecord(Record record) {
        if (records.isEmpty()) {
            readFromFile();
        }
        int index = getRecord(record);
        if (index != -1) {
            records.remove(index);
        }
        records.add(record);
        writeToFile();
    }

    @Override
    public boolean removeRecord(Record record) {
        if (records.isEmpty()) {
            readFromFile();
        }
        int index = getRecord(record);
        Log.v("bush", "index is " + index);
        if (index == -1) {
            return false;
        }
        records.remove(index);
        writeToFile();
        return true;
    }

    @Override
    public List<Record> loadAllRecords() {
        if (records.isEmpty()) {
            readFromFile();
        }
        for (Record record : records) {
            Log.v("bush", String.format("id is %s, name is %s, type is %s, age is %d",
                    record.getId(), record.getName(), record.getType(), record.getAge()));
        }
        return records;
    }

    private int getRecord(Record record) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getId().equals(record.getId())) {
                return i;
            }
        }
        return -1;
    }

    private void readFromFile() {
        if (!file.exists()) {
            return;
        }
        try {
            ObjectInputStream ins = new ObjectInputStream(new FileInputStream(file));
            records = (List<Record>) ins.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() {
        try {
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
            ous.writeObject(records);
            ous.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
