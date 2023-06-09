package my.practice.ctci.leet;

import java.util.Arrays;

/**
 * @author Vishal Joshi
 */
public class RemoveDuplicatesFromSortedArrayLeet {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(nums);
        //System.out.println(nums);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
                printArray(nums);
            }
        }
        return i + 1;
    }

    private static void printArray(int[] nums){
        System.out.println(Arrays.toString(nums));
    }
}
