package com.baidu.assignment6;

import android.database.Cursor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ImageBean {

    private final static String defaulGeoTag = "正在查询位置信息";
    private final static String NoGeoTag = "无地理位置信息";
    private int id;
    private int size;
    private long dateAddedMs;
    private int width;
    private int height;
    private int latitude = -1;
    private int longtitude = -1;
    private long dateTakenMs;

    private String path;
    private String displayName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public String getSizeString() {
        //小于1 K ,单位B， 小于1M就用KB
        String filesize;

        if (size < 1024) {
            filesize = size + "B";
        } else if (size < (1024 * 1024)) {
            filesize = (size / 1024) + "KB";
        } else {
            filesize = ((size / 1024) / 1024) + "MB";
        }

        return filesize;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getDateAdded() {
        return dateAddedMs;
    }

    public String getDateAddedString() {
        long timestamp = dateAddedMs;
        Timestamp ts = new Timestamp(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String date = null;
        date = sdf.format(ts);
        return date != null ? date : "";
    }

    public void setDateAdded(int dateAdded) {
        this.dateAddedMs = dateAdded;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(int longtitude) {
        this.longtitude = longtitude;
    }

    public long getDateTaken() {
        return dateTakenMs;
    }

    public String getDateTakenString() {
        long timestamp = dateTakenMs;
        Timestamp ts = new Timestamp(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String date = null;
        date = sdf.format(ts);
        return date != null ? date : "";
    }

    public void setDateTaken(long dateTaken) {
        this.dateTakenMs = dateTaken;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ImageBean() {

    }

    public ImageBean(Cursor cursor) {
        id = cursor.getInt(SystemMediaScanner.INDEX_ID);
        path = cursor.getString(SystemMediaScanner.INDEX_DATA);
        size = cursor.getInt(SystemMediaScanner.INDEX_SIZE);
        displayName = cursor.getString(SystemMediaScanner.INDEX_NAME);
        dateAddedMs = cursor.getInt(SystemMediaScanner.INDEX_DATE) * 1000l;
        width = cursor.getInt(SystemMediaScanner.INDEX_WIDTH);
        height = cursor.getInt(SystemMediaScanner.INDEX_HEIGHT);
        dateTakenMs = cursor.getLong(SystemMediaScanner.INDEX_DATETAKEN);
    }


}
