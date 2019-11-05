package cn.zmxblog.prototype;

import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2019/1/21 22:12:12
 * @Description:
 */
public class Car implements Serializable {

    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
