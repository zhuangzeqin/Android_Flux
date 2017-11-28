package com.eeepay.cn.zzq.demo.flux.model;

/**
 * 描述：消息的实体Messge
 * 作者：zhuangzeqin
 * 时间: 2017/11/28-15:24
 * 邮箱：zzq@eeepay.cn
 */
public class Message {
    private String mText;

    public Message() {
    }

    public Message(String text) {
        mText = text;
    }

    public String getMessage() {
        return mText;
    }

    public void setMessage(String text) {
        mText = text;
    }
}
