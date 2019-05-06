package com.interview.test;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-01-28 20:11
 * @modified :
 **/
public class Sword2Offer {

    public static void main(String[] args) {

        LinkList a = new LinkList(1);
        LinkList b = new LinkList(2);
        a.next = b;
        LinkList c = new LinkList(3);
        b.next = c;
        LinkList d = new LinkList(4);
        c.next = d;
        LinkList e = new LinkList(5);
        d.next = e;
        System.out.println(reverseListLoop(reverseListRecusive(a)).val);
    }

    static class LinkList {
        int val;
        LinkList next = null;

        LinkList(int val) {
            this.val = val;
        }
    }


    public static LinkList reverseListRecusive(LinkList head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkList newHead = reverseListRecusive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static LinkList reverseListLoop(LinkList head) {
        if (head == null) {
            return null;
        }
        LinkList next;
        LinkList pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


}
