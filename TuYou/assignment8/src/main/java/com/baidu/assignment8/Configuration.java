package com.baidu.assignment8;

import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

public class Configuration {

    private List<String> mRequiredMimeTypes;

    private List<String> mRequiredFields;

    private long[] mTimestampRange;

    private long[] mSizeRange;

    private long[] mWidthRange;

    private long[] mHeightRange;

    private String mOrderField;

    private Order mOrder;

    private int mPageSize;

    private List<Resolver> mResolvers;

    private Configuration(Builder builder) {
        mRequiredMimeTypes = builder.mRequiredMimeTypes;
        mRequiredFields = builder.mRequiredFields;
        mTimestampRange = builder.mTimestampRange;
        mSizeRange = builder.mSizeRange;
        mWidthRange = builder.mWidthRange;
        mHeightRange = builder.mHeightRange;
        mOrderField = builder.mOrderField;
        mOrder = builder.mOrder;
        mPageSize = builder.mPageSize;
        mResolvers = builder.mResolvers;
    }

    public List<Resolver> getResolvers() {
        return mResolvers;
    }

    public List<String> getRequiredMimeTypes() {
        return mRequiredMimeTypes;
    }

    public List<String> getRequiredFields() {
        return mRequiredFields;
    }

    public long[] getTimestampRange() {
        return mTimestampRange;
    }

    public long[] getSizeRange() {
        return mSizeRange;
    }

    public long[] getWidthRange() {
        return mWidthRange;
    }

    public long[] getHeightRange() {
        return mHeightRange;
    }

    public String getOrderField() {
        return mOrderField;
    }

    public Order getOrder() {
        return mOrder;
    }

    public int getPageSize() {
        return mPageSize;
    }
/////
    public enum Order {
        ASC("ASC"),
        DESC("DESC");

        Order(String order) {
            mOrder = order;
        }

        @Override
        public String toString() {
            return mOrder;
        }

        private String mOrder;
    }

    public enum MimeType {
        PNG("image/png"),
        JPG("image/jpeg");

        MimeType(String mimeType) {
            mMimeType = mimeType;
        }

        private String mMimeType;
    }
/////
    public interface Resolver {
        void resolve(ImageBean imageBean, Cursor cursor, int index);
    }

    public static class Builder {
        private List<String> mRequiredMimeTypes = new ArrayList<>();

        private List<String> mRequiredFields = new ArrayList<>();

        private List<Resolver> mResolvers = new ArrayList<>();

        private long[] mTimestampRange;

        private long[] mSizeRange;

        private long[] mWidthRange;

        private long[] mHeightRange;

        private String mOrderField;

        private Order mOrder;

        private int mPageSize;

        public Builder addRequiredMimeType(MimeType mimeType) {
            mRequiredMimeTypes.add(mimeType.mMimeType);
            return this;
        }

        public Builder requireFilePath() {
            mRequiredFields.add(MediaStore.Images.Media.DATA);
            mResolvers.add(new Resolver() {

                @Override
                public void resolve(ImageBean imageBean, Cursor cursor, int index) {
                    imageBean.setPath(cursor.getString(index));
                }
            });
            return this;
        }

        public Builder requireFileSize() {
            mRequiredFields.add(MediaStore.Images.Media.SIZE);
            mResolvers.add(new Resolver() {

                @Override
                public void resolve(ImageBean imageBean, Cursor cursor, int index) {
                    imageBean.setSize(cursor.getInt(index));
                }
            });
            return this;
        }

        public Builder requireDisplayName() {
            mRequiredFields.add(MediaStore.Images.Media.DISPLAY_NAME);
            mResolvers.add(new Resolver() {

                @Override
                public void resolve(ImageBean imageBean, Cursor cursor, int index) {
                    imageBean.setDisplayName(cursor.getString(index));
                }
            });
            return this;
        }

        public Builder requireDateAdded() {
            mRequiredFields.add(MediaStore.Images.Media.DATE_ADDED);
            mResolvers.add(new Resolver() {

                @Override
                public void resolve(ImageBean imageBean, Cursor cursor, int index) {
                    imageBean.setDateAdded(cursor.getInt(index) * 1000l);
                }
            });
            return this;
        }

        public Builder requireWidth() {
            mRequiredFields.add(MediaStore.Images.Media.WIDTH);
            mResolvers.add(new Resolver() {

                @Override
                public void resolve(ImageBean imageBean, Cursor cursor, int index) {
                    imageBean.setWidth(cursor.getInt(index));
                }
            });
            return this;
        }

        public Builder requireHeight() {
            mRequiredFields.add(MediaStore.Images.Media.HEIGHT);
            mResolvers.add(new Resolver() {

                @Override
                public void resolve(ImageBean imageBean, Cursor cursor, int index) {
                    imageBean.setHeight(cursor.getInt(index));
                }
            });
            return this;
        }

        public Builder requireDateTaken() {
            mRequiredFields.add(MediaStore.Images.Media.DATE_TAKEN);
            mResolvers.add(new Resolver() {

                @Override
                public void resolve(ImageBean imageBean, Cursor cursor, int index) {
                    imageBean.setDateTaken(cursor.getLong(index));
                }
            });
            return this;
        }

        public Builder setTimestampRange(long[] mTimestampRange) {
            this.mTimestampRange = mTimestampRange;
            return this;
        }

        public Builder setSizeRange(long[] mSizeRange) {
            this.mSizeRange = mSizeRange;
            return this;
        }

        public Builder setWidthRange(long[] mWidthRange) {
            this.mWidthRange = mWidthRange;
            return this;
        }

        public Builder setHeightRange(long[] mHeightRange) {
            this.mHeightRange = mHeightRange;
            return this;
        }

        public Builder orderByDateTaken(Order order) {
            this.mOrderField = MediaStore.Images.Media.DATE_TAKEN;
            mOrder = order;
            return this;
        }

        public Builder setPageSize(int mPageSize) {
            this.mPageSize = mPageSize;
            return this;
        }

        public Configuration build() {
            return new Configuration(this);
        }
    }
}
