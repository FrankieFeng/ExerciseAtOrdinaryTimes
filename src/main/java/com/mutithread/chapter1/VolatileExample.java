package com.mutithread.chapter1;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-03-18 22:03
 * @modified :
 **/
public class VolatileExample {
        int x = 0;
        volatile boolean v = false;
        public void writer() {
            x = 42;
            v = true;
        }
        public void reader() {
            if (v == true) {
                // 这里 x 会是多少呢？
            }
        }
}
