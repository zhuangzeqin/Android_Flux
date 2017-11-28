package com.eeepay.cn.zzq.demo.flux.otto;

import android.support.annotation.NonNull;

/**
 * 描述：驱动事件
 * 作者：zhuangzeqin
 * 时间: 2017/11/28-17:04
 * 邮箱：zzq@eeepay.cn
 */
public class StoreChangeEvent<T> {
    private String operationType;//驱动类型
    private T data;//携带数据； 可以为空

    public T getData() {
        return data;
    }

    public String getOperationType() {
        return operationType;
    }

    public StoreChangeEvent(@NonNull String operationType, T data) {
        this.operationType = operationType;
        this.data = data;
    }
}
