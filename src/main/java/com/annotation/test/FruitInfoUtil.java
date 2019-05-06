package com.annotation.test;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019/1/15 下午5:24
 * @modified :
 **/
import com.cache.test.RedisLockAspect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 注解处理器
 */
public class FruitInfoUtil {
    public static void getFruitInfo(Class clazz){

        String strFruitName=" 水果名称：";
        String strFruitColor=" 水果颜色：";
        String strFruitProvicer="供应商信息：";

        Field[] fields = clazz.getDeclaredFields();

        for(Field field :fields){
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                strFruitName=strFruitName+fruitName.value();
                System.out.println(strFruitName);
            }
            else if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor= (FruitColor) field.getAnnotation(FruitColor.class);
                strFruitColor=strFruitColor+fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            }
            else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider= (FruitProvider) field.getAnnotation(FruitProvider.class);
                strFruitProvicer=" 供应商编号："+fruitProvider.id()+" 供应商名称："+fruitProvider.name()+" 供应商地址："+fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(FruitColor.class)){
//                FruitProvider fruitProvider= (FruitProvider) methods.equals(FruitProvider.class);
                System.out.println();
            }
        }




    }


    public static void main(String[] args) {
        Apple a = new Apple();
       getFruitInfo(Apple.class);

        RedisLockAspect redisLockAspect = new RedisLockAspect();

        System.out.println(redisLockAspect);

    }
}
