package cn.zmxblog.prototype;

import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2019/1/21 21:49:49
 * @Description:
 */
public class People implements Serializable {
    private Integer age;

    private String height;

    private String weight;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
