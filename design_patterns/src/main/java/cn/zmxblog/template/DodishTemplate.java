package cn.zmxblog.template;

public abstract class DodishTemplate implements Dodish {

    protected void doDishStep() {
        preparation();
        doing();
        carriedDishes();
    }

    @Override
    public abstract void preparation();

    @Override
    public abstract void doing();

    @Override
    public abstract void carriedDishes();
}
