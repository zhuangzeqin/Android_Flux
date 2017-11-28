package com.eeepay.cn.zzq.demo.flux.dispatcher;

import com.eeepay.cn.zzq.demo.flux.actions.Action;
import com.eeepay.cn.zzq.demo.flux.stores.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * Flux框架中的Dispatcher部分，存放 Dispatcher.java 文件，一个应用中只需要一个Dispatcher
 * Dispatcher是中心枢纽，管理所有的数据流
 * 作者：zhuangzeqin
 * 时间: 2017/11/28-15:28
 * 邮箱：zzq@eeepay.cn
 */
public class Dispatcher {
    private static volatile Dispatcher mInstance = null;
    private final List<Store> stores = new ArrayList<>();

    private Dispatcher() {
    }

    public static Dispatcher getInstance() {
        if (mInstance == null) {
            synchronized (Dispatcher.class) {
                if (mInstance == null) {
                    mInstance = new Dispatcher();
                }
            }
        }
        return mInstance;
    }

    /**
     * 注册
     * @param store
     */
    public void register(final Store store) {
        if (!stores.contains(store)) {
            stores.add(store);
        }
    }

    /**
     * 反注册
     * @param store
     */
    public void unregister(final Store store) {
        stores.remove(store);
    }

    /**
     * 调度
     * @param action
     */
    public void dispatch(Action action) {
        post(action);
    }

    private void post(final Action action) {
        for (Store store : stores) {
            store.onAction(action);
        }
    }
}
