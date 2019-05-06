package com.interview.test;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019/1/15 下午2:04
 * @modified :
 **/
public class testExtends {
        public static void main(String[] args) {
            Wine a = new JNC();
            a.fun2();
            Wine b = new Wine();
            b.fun1();
            JNC c = new JNC();
            c.fun1("a");
        }
        public static  class Wine {
            public void fun1(){
                System.out.println("Wine 的Fun.....");
                fun2();
            }

            public void fun2(){
                System.out.println("Wine 的Fun2...");
            }
        }

        public static class JNC extends Wine{
            /**
             * @desc 子类重载父类方法
             *        父类中不存在该方法，向上转型后，父类是不能引用该方法的
             * @param a
             * @return void
             */
            public void fun1(String a){
                System.out.println("JNC 的 Fun1...");
                fun2();
            }

            /**
             * 子类重写父类方法
             * 指向子类的父类引用调用fun2时，必定是调用该方法
             */
            public void fun2(){
                System.out.println("JNC 的Fun2...");
            }
        }

}
