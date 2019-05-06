package com.guava.test;

import java.util.Scanner;

/**
 * @author : fengyuchen
 * @discription :两个大数字相加
 * @date : created on 2018/7/2 下午8:07
 * @modified :
 **/
public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        String numA = sc.nextLine();
        System.out.println("请输入第二个数字：");
        String numB = sc.nextLine();
        System.out.println(twoBigSum(numA, numB));
    }

    private static String twoBigSum(final String numA, final String numB) {
        try {
            String shortOne = numA;
            String longOne = numB;
            //找到短的数字和长的数字
            if (numA.length() > numB.length()) {
                shortOne = numB;
                longOne = numA;
            } else if (numA.length() < numB.length()) {
                shortOne = numA;
                longOne = numB;
            }
            //在短的数字前面补充0 使它和长的数字一样长
            shortOne = suplyZero4Short(shortOne, longOne.length() - shortOne.length());
            return twoSameLongSum(shortOne, longOne);
        } catch (Exception e) {
            return numA;
        }
    }

    private static String twoSameLongSum(String big, String small) {
        int length = big.length();
        //用于存储某一位要不要进位 如果进位就在它的前一位存储1 否则存0
        int[] indexDivide10 = getInitArray(length + 1);
        //用于存储某一位两个数求和后%10的结果
        int[] indexCellng10 = getInitArray(length + 1);
        for (int i = length; i > 0; i--) {
            //char - '0' 可以转化为 int
            int indexA = big.charAt(i - 1) - '0';
            int indexB = small.charAt(i - 1) - '0';
            indexDivide10[i - 1] = (indexA + indexB + indexDivide10[i]) / 10;
            indexCellng10[i] = (indexA + indexB + indexDivide10[i]) % 10;
        }
        //循环中没有将第一位的1存到结果中，在这里补上
        indexCellng10[0] = indexDivide10[0];
        StringBuilder finalRes = new StringBuilder();
        for (int i = firstNoZeroPos(indexCellng10); i < indexCellng10.length; i++) {
            finalRes.append(indexCellng10[i]);
        }
        return finalRes.toString();
    }

    /**
     * 找到结果数组中第一个不为0的位置
     * 防止输入的数字前面本身就有很多个0
     *
     * @param intArray
     * @return
     */
    private static int firstNoZeroPos(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] != 0) {
                return i;
            }
        }
        return intArray.length - 1;
    }

    /**
     * 初始化长度为length的值全是0的int数组
     *
     * @param length
     * @return
     */
    private static int[] getInitArray(int length) {
        int[] res = new int[length];
        for (int i = 0; i < res.length; i++) {
            res[i] = 0;
        }
        return res;
    }

    /**
     * 在num的前面补充suplyCount个0
     *
     * @param num
     * @param suplyCount
     * @return
     */
    private static String suplyZero4Short(String num, int suplyCount) {
        String temp = "";
        for (int i = 0; i < suplyCount; i++) {
            temp = temp.concat("0");
        }
        return temp + num;
    }
}
