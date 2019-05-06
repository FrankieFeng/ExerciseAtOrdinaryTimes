package com.annotation.test;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019/1/15 下午5:23
 * @modified :
 **/
/**
 * 注解使用
 */
public class Apple {

    @FruitName()
    private String appleName;
    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    private String appleProvider;

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }
    public String getAppleColor() {
        return appleColor;
    }
    @FruitProvider(id=1,name="陕西红富士集团",address="陕西省西安市延安路89号红富士大厦")
    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }
    public String getAppleName() {
        return appleName;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
    public String getAppleProvider() {
        return appleProvider;
    }

    public void displayName(){
        System.out.println("水果的名字是：苹果");
    }
}
