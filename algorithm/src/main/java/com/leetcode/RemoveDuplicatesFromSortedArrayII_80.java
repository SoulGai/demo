package com.leetcode;

/**
 * @program: leetcode
 * @description: 80. 删除有序数组中的重复项 II
 * @author: SoulGai
 * @create: 2024-12-08 14:31
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 **/
public class RemoveDuplicatesFromSortedArrayII_80 {

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int fast = 2,slow = 2;
        while(fast < n){
            if(nums[slow-2] != nums[fast]){
                nums[slow] = nums[fast];
                slow +=1;
            }
            fast +=1;
        }
        return slow;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }
}
