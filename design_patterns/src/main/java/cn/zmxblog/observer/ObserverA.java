package cn.zmxblog.observer;

public class ObserverA extends AbstractObserver implements Observer{

    @Override
    public void update(String newState) {
        super.update(newState);
        System.out.println("ObserverA....");
    }
}
