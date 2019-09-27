package cn.zmxblog.observer;


import java.util.ArrayList;
import java.util.List;

/**
 * 就是“被观察”的角色，它将所有观察者对象的引用保存在一个集合中。
 */
public class Subject {

    //保存注册的观察者对象
    private List<Observer> mObervers = new ArrayList<>();

    //注册观察者对象
    public void attach(Observer observer) {
        mObervers.add(observer);
        System.out.println("注册观察者对象"+observer.getClass());
    }

    //注销观察者对象
    public void detach(Observer observer) {
        mObervers.remove(observer);
        System.out.println("注销观察者对象");
    }

    //通知所有注册的观察者对象
    public void notifyEveryOne(String newState) {
        for (Observer observer : mObervers) {
            observer.update(newState);
        }
        System.out.println("通知所有注册的观察者对象");
    }


}
