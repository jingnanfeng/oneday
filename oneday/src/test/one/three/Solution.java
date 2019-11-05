package test.one.three;

/**
 * @author nanfeng
 * @date 2019-03-19 22:14
 */

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class Solution {

    public int[] towSum(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for(int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]!=target){
                    continue;
                }
                return new int[]{nums[i],nums[j]};
            }
        }
        return null;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,2,6,};
        Solution solution = new Solution();
        int[] a = solution.towSum(nums,4);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }


    }
}
