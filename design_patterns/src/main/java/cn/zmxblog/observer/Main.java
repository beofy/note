package cn.zmxblog.observer;

public class Main {

    public static void main(String[] args) {

        ConcreteObserver subject = new ConcreteObserver();
        subject.attach(new ObserverA());
        subject.attach(new ObserverB());
        subject.attach(new ObserverC());

        subject.notifyEveryOne("123");
        subject.change("321");
    }
}
