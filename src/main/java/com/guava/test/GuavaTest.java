package com.guava.test;

import com.google.common.base.*;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;

import javax.sql.rowset.Predicate;
import java.util.*;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2018/6/5 下午4:59
 * @modified :
 **/
public class GuavaTest {

    public static void main(String[] args) {
//        String a = MoreObjects.toStringHelper("MyObject")
//                .add("x", 1).add("c", 2)
//                .toString();
//        System.out.println(a);


        //mutimap
        Multimap<String, String> map = HashMultimap.create();
        map.put("PEK", "CA1501");
        map.put("SHA", "CA1502");
        map.put("PEK", "CA1506");
        map.put("PEK", "CA1508");
        map.put("PEK", "CA1501");
        map.put("SHA", "CA1502");
        map.put("PEK", "CA1506");
        map.put("PEK", "CA1508");
        System.out.println(map);

        //HashMap
        Map<String, String> Hashmap = new HashMap<String, String>();
        Hashmap.put("PEK", "CA1501");
        Hashmap.put("SHA", "CA1502");
        Hashmap.put("PEK", "CA1506");
        Hashmap.put("PEK", "CA1508");
        System.out.println(Hashmap);

        //BiMap
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("PEK", "CA1501");
        biMap.put("SHA", "CA1502");

        //value can  not  repeat must ues forceput
        biMap.forcePut("PVG", "CA1501");
        System.out.println(biMap);
        //get key by value
        System.out.println(biMap.inverse().get("CA1501"));
        //inverse twice times
        System.out.println(biMap.inverse().inverse().get("SHA"));

        //Table
        Table<String, String, String> table = HashBasedTable.create();
        table.put("CA1501", "CA1502", "1");
        table.put("CA1502", "CA1503", "1");
        table.put("CA1503", "CA1501", "1");

        for (Table.Cell cell : table.cellSet()) {
            System.out.println(cell.getRowKey() + "," + cell.getColumnKey() + "," + cell.getValue());
        }

        table.columnKeySet().forEach(c -> System.out.println(c));
        table.rowKeySet().forEach(r -> System.out.println(r));
        table.values().forEach(v -> System.out.println(v));
        System.out.println(table);

        //

        String preOnn = Joiner.on("").useForNull(" ").join(null, " ", "");


        System.out.println(String.valueOf(Strings.isNullOrEmpty(" ")));


        System.out.println(numJewelsInStones("z", "ZZ"));


        System.out.println(replaceSpace(new  StringBuffer("We Are Happy") ));

        ListNode listNode1 = new ListNode(10);
        ListNode listNode2 = new ListNode(5);
        listNode1.next = listNode2;

        System.out.println(   printListFromTailToHead(listNode1));

        printListFromTailToHead(listNode1).forEach(p-> System.out.println(p.toString()));


        for (int i = 0; i < 10 ; i++) {
            push(i);
        }


        for (int i = 0; i < 10; i++) {
            System.out.println(pop());
        }


        System.out.println(  minNumberInRotateArray(new int[]{3,4,5,6,1,2}));

        System.out.println(Fibonacci(-20));

        System.out.println(JumpFloor(3));

        System.out.println(JumpFloorII(30));

        System.out.println(RectCover(10));


        System.out.println(NumberOf1(3));


        System.out.println(Power(2,-3));
        a = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8,9};
        quickSort(0,9);


        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }


        HashMap hashMapmap = new HashMap();

        hashMapmap.put("a","a");


        Hashtable hashtable = new Hashtable();
        hashtable.put(null,null);


    }


    public static int numJewelsInStones(String J, String S) {
        char[] sChar = S.toCharArray();
        char[] jChar = J.toCharArray();
        int num = 0;
        for (int i = 0; i < sChar.length; i++) {
            for (int j = 0; j < jChar.length; j++) {
                if (jChar[j] == sChar[i])
                    num++;
            }
        }
        return num;
    }


    //剑指 offer
    public boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++){
            for (int j = 0 ;j< array[0].length;j++){
                if (array[i][j] == target)
                    return true;
            }
        }

        return false;


    }

    public static  String replaceSpace(StringBuffer str) {

        String res = "";
        for (int i = 0; i < str.length() ; i++) {

            if (str.charAt(i) == ' '){
                res+="%20";
            }else {
                res+=str.charAt(i);
            }

        }
        return res;
    }

    public static  ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        Stack<ListNode> nodeStack = new Stack<>();
        nodeStack.push(listNode);
        while (listNode.next!=null){
            nodeStack.push(listNode.next);
            listNode = listNode.next;
        }

        ArrayList<Integer> res = Lists.newArrayList();

        while(!nodeStack.isEmpty()){
           res.add(nodeStack.pop().val);
        }

        return res;
    }

    public static  class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }


    //两个栈实现一个队列
   static Stack<Integer>  stack1 = new Stack<Integer>();
  static   Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public  static int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        int min = array[0];
        for (int anArray : array) {
            if (anArray < min)
                return anArray;
        }
        return min;


    }
    //斐波那契数列
    public static int Fibonacci(int n) {
        if (n < 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        else
            return Fibonacci(n-1)+Fibonacci(n-2);
    }

    //青蛙跳台阶 暴力膜 不好使
    public static int JumpFloor2(int target) {
        int count  = 0;
        for (int i = 0; i < target + 1 ; i++) {
            for (int j = 0; j < target + 1 ; j++) {
                if (i+2*j == target)
                    count++;
            }
        }

        return count;


    }
    public static int JumpFloor(int target) {
        if (target <= 0)
            return 0;
        else if (target == 1)
            return 1;
        else if (target == 2)
            return 2;
        else
            return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    //变态跳台阶
    public static int JumpFloorII(int target) {
        if (target <= 0 )
            return 0;
        else if (target == 1)
            return 1;
        else
            return 2*JumpFloorII(target -1);
    }

    //矩形覆盖
    public static  int RectCover(int target) {
        if (target <= 0)
            return 0;
        else if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        else
            return RectCover(target - 1) + RectCover(target - 2);

    }

    //输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
    public static  int NumberOf1(int n) {
        String nStr = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < nStr.length(); i++) {
            if ('1' == nStr.charAt(i))
                count++;
        }

        return count;
    }

    //给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    public static double Power(double base, int exponent) {

        return 0;
    }

    //快速排序
    static int[] a;

    public static void quickSort(int left,int right){
        if (left > right)
            return;
        int temp = a[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (a[j] >= temp && i < j) {
                j--;
            }
            while (a[i] <= temp ) {
                i++;
            }
            int t = a[j];
            a[j] = a[i];
            a[i] = t;
        }
        a[left] = a[i];
        a[i] = temp;
        quickSort(left, i - 1);
        quickSort(i + 1, right);
    }

}
