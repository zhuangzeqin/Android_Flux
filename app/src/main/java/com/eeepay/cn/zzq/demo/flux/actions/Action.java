package com.eeepay.cn.zzq.demo.flux.actions;

import android.support.annotation.NonNull;

/**
  * 描述：Flux框架中的Action部分，存放不同类型的XXXAction.java
  * 作者：zhuangzeqin
  * 时间: 2017/11/28-15:21
  * 邮箱：zzq@eeepay.cn
  */
public class Action<T> {
    private final String type;//action 类型
    private final T data;//携带数据； 可以为空

    Action(@NonNull String type, T data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public T getData() {
        return data;
    }
}
