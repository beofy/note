package cn.zmxblog.factory.simple;

import cn.zmxblog.factory.BaoMa;
import cn.zmxblog.factory.BenChi;
import cn.zmxblog.factory.BinLi;
import cn.zmxblog.factory.Car;

/**
 * @Auther: Administrator
 * @Date: 2019/1/21 23:58:58
 */
public class SimpleFactory {

    public Car getCar(String name){
        if(name.equals("baoma")){
            return new BaoMa();
        }
        if(name.equals("benchi")){
            return new BenChi();
        }
        if(name.equals("binli")){
            return new BinLi();
        }
        System.out.println("该工厂不能生产此"+name+"车！");
        return null;

    }
}
