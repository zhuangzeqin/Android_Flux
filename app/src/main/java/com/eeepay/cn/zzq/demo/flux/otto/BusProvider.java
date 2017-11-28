package com.eeepay.cn.zzq.demo.flux.otto;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * 描述：为了不频繁的创建Bus类的对象，我们这里创建一个单例类解决这个问题
 * 在Android程序开发的过程中想要不同的组件之间进行有效的通信可以使用这个库。通过otto库可以
 * 降低程序之间的耦合性。
 * 作者：zhuangzeqin
 * 时间: 2017/11/28-14:48
 * 邮箱：zzq@eeepay.cn
 */
public final class BusProvider extends Bus {
    private BusProvider() {
        super(ThreadEnforcer.ANY);
    }

    private static class SingletonHolder {
        private static final BusProvider INSTANCE = new BusProvider();
    }

    public static BusProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
