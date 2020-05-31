package com.baidu.testrecordmanager;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RecordManagerImplements implements RecordManager {
    private File dir;
    private Map<String, FileInfo> filesMap;
    private HashMap<String, Record> recordsMap;
    List<Record> records;
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public RecordManagerImplements(Context context) throws IOException {
        dir = context.getExternalFilesDir("recordmanager");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Log.v("bush", dir.getAbsolutePath());
        recordsMap = new HashMap<>();
    }

    @Override
    public void offerRecord(final Record record) {
        Log.v("bush", String.format("offerRecord %s", record));
        executeInThread("offerRecord", new Runnable() {
            @Override
            public void run() {
                if (filesMap == null) {
                    constructFileMap();
                }
                if (filesMap.containsKey(record.getKey())) {
                    deleteRecord(record);
                }
                long currentTime = System.currentTimeMillis();
                String fileName = currentTime + "_" + record.getKey();
                writeToFile(fileName, record);

                FileInfo info = new FileInfo();
                info.setFileName(fileName);
                info.setKey(record.getKey());
                info.setTime(currentTime + "");
                filesMap.put(record.getKey(), info);
                recordsMap.put(record.getKey(), record);
            }
        });
    }

    @Override
    public void removeRecord(final Record record) {
        executeInThread("removeRecord", new Runnable() {
            @Override
            public void run() {
                deleteRecord(record);
            }
        });
    }

    @Override
    public void loadAllRecords(final CallBack<List<Record>> callBack) {
        executeInThread("loadAllRecords", new Runnable() {
            @Override
            public void run() {
                if (filesMap == null) {
                    constructFileMap();
                }
                Log.v("bush", String.format("map size=%s", filesMap.size()));
                records = new ArrayList<>();
                List<FileInfo> list = new ArrayList<>(filesMap.values());
                Collections.sort(list, new Comparator<FileInfo>() {
                    @Override
                    public int compare(FileInfo o1, FileInfo o2) {
                        return o1.time.compareTo(o2.time);
                    }
                });
                for (FileInfo fileInfo : list) {
                    records.add(getRecord(fileInfo.getKey()));
                }
                callBack.getRecords(records);
            }
        });
    }

    @Override
    public void getRecord(final String key, final CallBack<Record> callBack) {
        executeInThread("getRecord", new Runnable() {
            @Override
            public void run() {
                Record record = getRecord(key);
                callBack.getRecords(record);
            }
        });
    }

    @Override
    public void clearAll() {
        executeInThread("clearAll", new Runnable() {
            @Override
            public void run() {
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        file.delete();
                    }
                }
                if (recordsMap != null) {
                    recordsMap.clear();
                }
                if (filesMap != null) {
                    filesMap.clear();
                }
                if (records != null) {
                    records.clear();
                }
            }
        });
    }

    private void deleteRecord(Record record) {
        if (filesMap == null) {
            constructFileMap();
        }
        if (recordsMap.containsKey(record.getKey())) {
            recordsMap.remove(record.getKey());
        }
        final FileInfo info = filesMap.get(record.getKey());
        if (info == null) {
            return;
        }
        deleteFile(info.getFileName());
        filesMap.remove(record.getKey());
    }

    private Record getRecord(String key) {
        if (filesMap == null) {
            constructFileMap();
        }
        if (!recordsMap.containsKey(key)) {
            FileInfo info = filesMap.get(key);
            Record record = readFromFile(info.getFileName());
            if (record != null) {
                recordsMap.put(key, record);
            }
        }
        return recordsMap.get(key);
    }

    private Record readFromFile(String fileName) {
        File file = new File(dir, fileName);
        if (!file.exists()) {
            return null;
        }
        Record record = null;
        try {
            ObjectInputStream ins = new ObjectInputStream(new FileInputStream(file));
            record = (Record) ins.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("bush", "read Exception");
        }
        return record;
    }

    private void writeToFile(String fileName, Record record) {
        Log.v("bush", "writeFile : " + record.getKey());
        File file = new File(dir, fileName);
        try {
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
            ous.writeObject(record);
            ous.close();
        } catch (Exception e) {
            Log.e("bush", "write Exception");
            e.printStackTrace();
        }
    }

    private void constructFileMap() {
        filesMap = new HashMap<>();
        File[] files = dir.listFiles();
        if (files == null) {
            Log.v("bush", "empty dir");
            return;
        }
        for (int i = 0; i < files.length; i++) {
            String s = files[i].getName();
            String[] temp = s.split("_");
            FileInfo info = new FileInfo();
            info.setKey(temp[1]);
            info.setTime(temp[0]);
            info.setFileName(s);
            filesMap.put(temp[1], info);
        }
    }

    private boolean deleteFile(String fileName) {
        File file = new File(dir, fileName);
        if (!file.exists()) {
            return false;
        }
        file.delete();
        return true;
    }

    private void executeInThread(final String tag, final Runnable runnable) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Tester.start();
                runnable.run();
                Tester.end(tag);
            }
        });
    }
}
