package com.eeepay.cn.zzq.demo.flux.stores;

import com.eeepay.cn.zzq.demo.flux.actions.Action;
import com.eeepay.cn.zzq.demo.flux.otto.BusProvider;
import com.eeepay.cn.zzq.demo.flux.otto.StoreChangeEvent;

/**
 * 描述：Flux框架中的Stores部分，存在各种类型的 XXXStore.java 文件
 * 作者：zhuangzeqin
 * 时间: 2017/11/28-15:38
 * 邮箱：zzq@eeepay.cn
 */
public abstract class Store<T> {
    protected Store() {
    }

    /**
     * 注册
     *
     * @param view
     */
    public void register(final Object view) {
        BusProvider.getInstance().register(view);
    }

    /**
     * 反注册
     *
     * @param view
     */
    public void unregister(final Object view) {
        BusProvider.getInstance().unregister(view);
    }

    /**
     * 发送改变
     */
    void postStoreChange(String operationType,T data) {
        /*传入操作类型，然后触发主界面更新 */
        BusProvider.getInstance().post(changeEvent(operationType,data));
    }
    //返回到view中的对象，在activity得到这个对象，通过operationtype来判断响应的操作去更新对应的ui
    public abstract StoreChangeEvent changeEvent(String operationType,T data);

    /**
     * 区分不同的Action
     * 所有逻辑的处理，在实现类中可以简单想象成对应着一个Activity（View）的增删改查的处理
     *
     * @param action
     */
    public abstract void onAction(Action action);
}
