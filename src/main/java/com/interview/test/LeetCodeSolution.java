package com.interview.test;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-03-04 19:50
 * @modified :
 **/
public class LeetCodeSolution {

    /**
     * 从排序数组中删除重复项
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {

        int res = 0;
        if (nums == null) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[res]) {
                res++;
                int tmep = nums[res];
                nums[res] = nums[i];
                nums[i] = tmep;
            }
        }
        return ++res;
    }

    /**
     * 买卖股票的最佳时机 II 贪心法
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //关键点在于 d3 - d1  = d3 - d2 + d2 + d1
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    /**
     * 旋转数组
     *
     * @param nums
     * @param k
     */
    public void rotateVersion1(int[] nums, int k) {
        int lenth = nums.length;
        for (int j = 0; j < k; j++) {
            int temp = nums[lenth - 1];
            for (int i = lenth - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }

    }

    public void rotateCersion2(int[] nums, int k) {
        if (nums.length == 0)
            return;

        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }


    public void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = temp;
        }
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1)
            return false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> num1Map = new HashMap<>();

        for (int i : nums1) {
            num1Map.merge(i, 1, (a, b) -> a + b);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (num1Map.get(i) != null && num1Map.get(i) > 0) {
                list.add(i);
                num1Map.put(i, num1Map.get(i) - 1);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {

            res[i++] = integer;
        }
        return res;
    }

    public int[] intersectV2(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        Set<Integer> list = new HashSet<>();
        while (i != nums1.length && j != nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[list.size()];
        int k = 0;
        for (Integer integer : list) {

            res[k++] = integer;
        }
        return res;


    }


    public int[] plusOne(int[] digits) {
        if (digits.length == 0){
            return new int[]{};
        }
        int i = digits.length - 1;
        while((digits[i] + 1 )%10 == 0){
            digits[i] = 0;
            i--;
        }

        return digits;
    }

    public static void main(String[] args) {
        LeetCodeSolution leetCodeSolution = new LeetCodeSolution();
        int[] ints = new int[]{1, 2, 2, 1};
        System.out.println(leetCodeSolution.containsDuplicate(ints));

        int[] ints2 = new int[]{2, 2};
        int[] res = leetCodeSolution.plusOne(ints);


        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }


    }
}
