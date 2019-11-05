package cn.zmxblog.observer;

/**
 * 具体的观察者
 */
public class ConcreteObserver extends Subject{

    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState) {
        state = newState;
        System.out.println("状态发生改变，通知观察者");
        //状态发生改变，通知观察者
        notifyEveryOne(newState);
    }

}
