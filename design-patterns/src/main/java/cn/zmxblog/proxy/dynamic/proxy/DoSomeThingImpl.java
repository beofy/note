package cn.zmxblog.proxy.dynamic.proxy;

import java.io.Serializable;

public class DoSomeThingImpl implements DoSomeThing, Serializable {
    @Override
    public String say() {
        return "说话。。。。";
    }
}
