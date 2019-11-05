package cn.zmxblog.proxy.dynamic.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //被代理的目标类
        DoSomeThing doSomeThing = new DoSomeThingImpl();

        DoSomeThingProxy doSomeThingProxy = new DoSomeThingProxy(doSomeThing);

        /* 获取被代理接口实例对象 */
        final Object proxyInstance = Proxy.newProxyInstance(
                doSomeThingProxy.getClass().getClassLoader(),
                doSomeThing.getClass().getInterfaces(),
                doSomeThingProxy);

        DoSomeThing proxy = (DoSomeThing)proxyInstance;
        proxy.say();
    }


}
