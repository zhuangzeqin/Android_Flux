package com.eeepay.cn.zzq.demo.flux.otto;

import android.support.annotation.NonNull;

import com.eeepay.cn.zzq.demo.flux.model.Message;

/**
 * 描述：主界面事件驱动事件
 * 作者：zhuangzeqin
 * 时间: 2017/11/28-17:36
 * 邮箱：zzq@eeepay.cn
 */
public class MainStoreEvent extends StoreChangeEvent<Message> {

    public MainStoreEvent(@NonNull String operationType, Message data) {
        super(operationType, data);
    }
}
