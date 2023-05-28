package my.practice.ctci.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Joshi
 */
public class SubsetsUsingBacktracking {
    List<List<Integer>> result = new ArrayList();
    int n, len;

    public static void main(String[] args) {
        SubsetsUsingBacktracking subset = new SubsetsUsingBacktracking();
        System.out.println(subset.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for(len=0; len<=n; len++){
            backtrack(0, new ArrayList<>(), nums);
        }
        return result;
    }

    private void backtrack(int first, List<Integer> subList, int[] nums){
        if(subList.size()==len){
            result.add(new ArrayList(subList));
            return;
        }

        for(int i=first; i<n; i++){
            subList.add(nums[i]);
            backtrack(i+1, subList, nums);
            subList.remove(subList.size()-1);
        }
    }
}
