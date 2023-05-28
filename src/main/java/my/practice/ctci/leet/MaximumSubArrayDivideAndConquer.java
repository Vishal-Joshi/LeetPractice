package my.practice.ctci.leet;

import java.util.Arrays;

/**
 * @author Vishal Joshi
 */
public class MaximumSubArrayDivideAndConquer {
    public static void main(String[] args) {
        MaximumSubArrayDivideAndConquer maxSubArray = new MaximumSubArrayDivideAndConquer();
        int nums[] = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maSum = maxSubArray.findMaxSubarraySum(nums, 0, nums.length - 1);
        System.out.println(maSum);
    }

    private int findMaxSubarraySum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        System.out.printf("leftSum (%s, left=%d, mid=%d%n", Arrays.toString(nums), left, mid);
        int leftSum = findMaxSubarraySum(nums, left, mid);
        System.out.printf("leftSum=%d%n", leftSum);
        System.out.printf("rightSum (%s, mid+1=%d, right=%d%n", Arrays.toString(nums), mid + 1, right);
        int rightSum = findMaxSubarraySum(nums, mid + 1, right);
        System.out.printf("rightSum=%d%n", rightSum);
        System.out.printf("crossMidSum (%s, left=%d, mid=%d, right=%d%n", Arrays.toString(nums), left, mid, right);
        int crossMidSum = findCrossArraySum(nums, left, mid, right);
        System.out.printf("crossMidSum=%d%n", crossMidSum);
        if (leftSum >= rightSum && leftSum >= crossMidSum) {
            return leftSum;
        }

        if (rightSum >= leftSum && rightSum >= crossMidSum) {
            return rightSum;
        }
        return crossMidSum;
    }

    private int findCrossArraySum(int[] nums, int left, int mid, int right) {
        int leftsum = Integer.MIN_VALUE;
        int rightsum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--){
            sum += nums[i];
            if (leftsum < sum){
                leftsum = sum;
            }
        }

        sum = 0;
        for (int j = mid + 1; j <= right; j++){
            sum += nums[j];
            if (rightsum < sum){
                rightsum = sum;
            }
        }

        return leftsum + rightsum;
    }

    private String printArray(int[] nums) {
        return Arrays.toString(nums);
    }
}
