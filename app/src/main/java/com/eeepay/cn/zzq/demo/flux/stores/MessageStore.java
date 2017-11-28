package com.eeepay.cn.zzq.demo.flux.stores;

import com.eeepay.cn.zzq.demo.flux.actions.Action;
import com.eeepay.cn.zzq.demo.flux.actions.MessageAction;
import com.eeepay.cn.zzq.demo.flux.model.Message;
import com.eeepay.cn.zzq.demo.flux.otto.MainStoreEvent;
import com.eeepay.cn.zzq.demo.flux.otto.StoreChangeEvent;

/**
 * 描述：Store包含应用的状态(state)和逻辑(logic)
 * Store负责管理App中一片区域的状态，而不是简单的ORM数据集
 * 作者：zhuangzeqin
 * 时间: 2017/11/28-15:41
 * 邮箱：zzq@eeepay.cn
 */
public class MessageStore extends Store<Message> {

    private Message mMessage = new Message();

    @Override
    public StoreChangeEvent changeEvent(String operationType, Message data) {
        return new MainStoreEvent(operationType, data);
    }

    @Override
    public void onAction(Action action) {
        final String operationType = action.getType();
        switch (operationType) {
            case MessageAction.ACTION_NEW_MESSAGE:
                final String data = (String) action.getData();
                //这里可以模拟网络请求
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                            String netData = "{\"welcome\":\"hello world!\"}";
                            mMessage.setMessage(data + " request data:" + netData);
                            //发送改变
                            postStoreChange(operationType, mMessage);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            case MessageAction.ACTION_NEW_TOAST:
                final String data2 = (String) action.getData();
                String netData = "{\"welcome\":\"hello world!\"}";
                mMessage.setMessage(data2 + " request data:" + netData);
                //发送改变
                postStoreChange(operationType, mMessage);
                break;
        }


    }
}
