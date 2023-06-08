package my.practice.ctci.leet;

import java.util.Arrays;

/**
 * @author Vishal Joshi
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if(nums.length==0 || nums.length==1){
            return false;
        }
        Arrays.sort(nums);

        int i=0;
        int current = nums[i];

        while(i < nums.length)
        if(current == nums[++i]) {
            return true;
        }
        current=nums[i];
        return false;

    }

}
