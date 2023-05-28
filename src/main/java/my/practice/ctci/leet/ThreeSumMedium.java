package my.practice.ctci.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vishal Joshi
 */
public class ThreeSumMedium {

    public static void main(String[] args) {
        ThreeSumMedium threeSum = new ThreeSumMedium();
        System.out.println(threeSum.threeSum(new int[]{1, 2, -2, -1}));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n<3){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int start=0;
        while(start<n-1 && nums[start]<=0) {
            int target = 0-nums[start];
            for(int i=start+1; i<n-1; i++) {
                int toFind=target-nums[i];
                int otherIndex=binarySearch(nums, i+1, n-1, toFind);
                if(otherIndex!=-1){
                    result.add(Arrays.asList(nums[start], nums[i], nums[otherIndex]));
                }
                while(i<n-1 && nums[i]==nums[i+1]){
                    i++;
                }
            }
            int prev = nums[start];
            while(start<n-1 && prev==nums[start]){
                start++;
            }
        }
        return result;
    }

    private int binarySearch(int[] nums, int start, int end, int toFind){
        if(start>end){
            return -1;
        }
        int mid = (end+start)/2;

        if(nums[mid]==toFind){
            return mid;
        }

        if(toFind<nums[mid]){
            return binarySearch(nums, start, mid-1, toFind);
        } else {
            return binarySearch(nums, mid+1, end, toFind);
        }
    }
}
