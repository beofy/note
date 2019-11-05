package cn.zmxblog.delegate;

public class Chinese implements IHello {
    @Override
    public void sayHello() {
        System.out.println("你好！");
    }
}
