package cn.zmxblog.observer;

public abstract class AbstractObserver implements Observer{
    //观察者状态
    private String observerState;

    @Override
    public void update(String newState) {
        observerState = newState;
    }

    public String getObserverState() {
        return observerState;
    }

    public void setObserverState(String observerState) {
        this.observerState = observerState;
    }
}
