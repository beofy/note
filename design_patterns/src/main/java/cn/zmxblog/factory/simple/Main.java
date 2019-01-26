package cn.zmxblog.factory.simple;

import cn.zmxblog.factory.BenChi;
import cn.zmxblog.factory.BinLi;
import cn.zmxblog.factory.Car;

/**
 * @Auther: Administrator
 * @Date: 2019/1/21 23:58:58
 */
public class Main {

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Car car= simpleFactory.getCar("benchi");
        System.out.println(car.name());
        ;
        System.out.println(((BenChi)car).benChi);
        System.out.println(((BinLi)car));


    }
}
