package cn.zmxblog.observer;

/**
 * 是抽象的“观察”角色，它定义了一个更新接口，使得在被观察者状态发生改变时通知自己。
 */
public interface Observer {
    void update(String newState);
}
