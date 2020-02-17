package com.baidu.assignment6;

import java.util.List;

public interface Callback {
    void onSuccess(List<ImageBean> beanList);
    void onFailure();
}
