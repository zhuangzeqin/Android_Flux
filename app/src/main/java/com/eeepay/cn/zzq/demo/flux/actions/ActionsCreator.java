package com.eeepay.cn.zzq.demo.flux.actions;

import com.eeepay.cn.zzq.demo.flux.dispatcher.Dispatcher;

/**
 * 描述：Flux的ActionCreator模块
 * ActionCreator会根据传入参数创建Action并通过Dispatcher发送给Store，
 * 所有订阅了这个Action的Store会接收到订阅的Action并消化Action
 * 作者：zhuangzeqin
 * 时间: 2017/11/28-15:52
 * 邮箱：zzq@eeepay.cn
 */
public class ActionsCreator {
    private static volatile ActionsCreator mInstance = null;
    private final Dispatcher dispatcher;

    private ActionsCreator(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public static ActionsCreator getInstance(Dispatcher dispatcher) {
        if (mInstance == null) {
            synchronized (ActionsCreator.class) {
                if (mInstance == null) {
                    mInstance = new ActionsCreator(dispatcher);
                }
            }
        }
        return mInstance;
    }

    /**
     * 发送调度
     * @param action
     */
    public void sendDispatch(Action action) {
        dispatcher.dispatch(action);
    }
}
