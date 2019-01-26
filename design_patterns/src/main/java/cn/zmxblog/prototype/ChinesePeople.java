package cn.zmxblog.prototype;

import java.io.*;

/**
 * @Auther: Administrator
 * @Date: 2019/1/21 22:15:15
 * @Description:
 */
public class ChinesePeople extends People implements Cloneable, Serializable {

    public ChinesePeople(String name) {
        this.name = name;
    }

    private String name;
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    /**
     * 浅克隆
     * @param: []
     * @auther: Administrator
     * @date: 2019/1/21 23:27
     * 
     * @return: 
     */
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    /**
     * 深克隆-通过序列化实现
     * @param: []
     * @auther: Administrator
     * @date: 2019/1/21 23:27
     *
     * @return:
     */
    public ChinesePeople deepClone(){
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            return (ChinesePeople)objectInputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
