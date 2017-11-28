package com.eeepay.cn.zzq.demo.flux.actions;

import android.support.annotation.NonNull;

/**
 * 描述：一个消息的Action
 * 作者：zhuangzeqin
 * 时间: 2017/11/28-15:26
 * 邮箱：zzq@eeepay.cn
 */
public class MessageAction extends Action<String> {
    public static final String ACTION_NEW_MESSAGE = "new_message";
    public static final String ACTION_NEW_TOAST = "new_toast";
    public MessageAction(@NonNull String type, String data) {
        super(type, data);
    }
}
