package cn.zmxblog.delegate;

public class HelloDelegate implements IHello{
    private IHello iHello;

    @Override
    public void sayHello() {
        iHello.sayHello();
    }

    /**
     * 委托中国人
     */
    public static IHello getChinese(){
        HelloDelegate helloDelegate = new HelloDelegate();
        helloDelegate.iHello = new Chinese();
        return helloDelegate;
    }

    /**
     * 委托美国人
     */
    public static IHello getAmerican(){
        HelloDelegate helloDelegate = new HelloDelegate();
        helloDelegate.iHello = new American();
        return helloDelegate;
    }

    public static void main(String[] args) {
        HelloDelegate.getChinese().sayHello();
        HelloDelegate.getAmerican().sayHello();
    }

}
