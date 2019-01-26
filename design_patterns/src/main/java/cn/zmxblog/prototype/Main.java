package cn.zmxblog.prototype;

/**
 * @Auther: Administrator
 * @Date: 2019/1/21 22:23:23
 * @Description: asd
 */
public class Main {


    public static void main(String[] args) {

        //原型模式
        //1.通过反射赋值（spring采用）
        //2.通过object的clone方法(浅克隆)
        //3.通过简单对象赋值
        //shallowClone();
        deepClone();
    }

    /**
     * 原型模式-浅克隆
     * @param:
     * @auther: Administrator
     * @date: 2019/1/21 22:38
     *
     * @return:
     */
    public static void shallowClone(){
        ChinesePeople chinesePeople = new ChinesePeople("张三");

        Car car =new Car();
        car.setBrandName("辉腾");

        chinesePeople.setCar(car);
        try {
            // 通过重写父类的clone方法,实现对象的克隆
            // 对象的引用不一致，但属性的引用相等，即所谓浅克隆
            ChinesePeople chinesePeople1 = (ChinesePeople) chinesePeople.clone();
            System.out.println(chinesePeople==chinesePeople1);
            System.out.println("chinesePeople: "+chinesePeople.getCar().getBrandName()+"----- chinesePeople1:"+chinesePeople1.getCar().getBrandName());
            System.out.println(chinesePeople.getCar()==chinesePeople1.getCar());

            //浅克隆 修改原体的属性，克隆体的属性相应发生变化
            chinesePeople.getCar().setBrandName("大众");
            System.out.println("chinesePeople: "+chinesePeople.getCar().getBrandName()+"----- chinesePeople1:"+chinesePeople1.getCar().getBrandName());
            System.out.println(chinesePeople.getCar()==chinesePeople1.getCar());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 原型模式-深克隆
     * @param:
     * @auther: Administrator
     * @date: 2019/1/21 22:39
     *
     * @return:
     */
    public static void deepClone(){
        ChinesePeople chinesePeople = new ChinesePeople("张三");

        Car car =new Car();
        car.setBrandName("辉腾");
        chinesePeople.setCar(car);

        //通过序列化产生克隆对象
        //对象的引用不一致，对象属性相同，引用不一致，即所谓深克隆
        ChinesePeople chinesePeople1 = chinesePeople.deepClone();

        System.out.println(chinesePeople==chinesePeople1);
        System.out.println("chinesePeople: "+chinesePeople.getCar().getBrandName()+"----- chinesePeople1:"+chinesePeople1.getCar().getBrandName());
        System.out.println(chinesePeople.getCar()==chinesePeople1.getCar());

        //深克隆 修改各自对象的属性，只改变当前对像的属性
        chinesePeople.getCar().setBrandName("大众");
        System.out.println("chinesePeople: "+chinesePeople.getCar().getBrandName()+"----- chinesePeople1:"+chinesePeople1.getCar().getBrandName());
        System.out.println(chinesePeople.getCar()==chinesePeople1.getCar());

    }

}
