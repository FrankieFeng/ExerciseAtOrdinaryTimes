package com.interview.test;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019/1/15 下午2:16
 * @modified :
 **/
public class TestWine2 {
    public static void main(String[] args) {
        //定义父类数组
        Wine[] wines = new Wine[2];
        //定义两个子类
        JNC jnc = new JNC();
        JGJ jgj = new JGJ();
        Wine wine=new Wine();

        //父类引用子类对象
        wines[0] = jnc;
        wines[1] = jgj;

        for(int i = 0 ; i < 2 ; i++){
            System.out.println(wines[i].toString() + "--" + wines[i].drink());
        }
        System.out.println("-------------------------------");
        System.out.println(jnc.toString() + "--" + jnc.drink());
        System.out.println(jgj.toString() + "--" + jgj.drink());
    }
    public static class Wine {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Wine(){
        }

        public String drink(){
            return "喝的是 " + getName();
        }

        /**
         * 重写toString()
         */
        public String toString(){
            return null;
        }
    }

    public static class JNC extends Wine{
        public JNC(){
            setName("JNC");
        }

        /**
         * 重写父类方法，实现多态
         */
        public String drink(){
            return "喝的是 " + getName();
        }

        /**
         * 重写toString()
         */
        public String toString(){
            return "Wine : " + getName();
        }
    }

    public static class JGJ extends Wine{
        public JGJ(){
            setName("JGJ");
        }

        /**
         * 重写父类方法，实现多态
         */
        public String drink(){
            return "喝的是 " + getName();
        }

        /**
         * 重写toString()
         */
        public String toString(){
            return "Wine : " + getName();
        }
    }
}