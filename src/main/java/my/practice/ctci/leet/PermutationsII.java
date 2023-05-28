package my.practice.ctci.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vishal Joshi
 */
public class PermutationsII {

    public static void main(String[] args) {
        PermutationsII permutations = new PermutationsII();
        System.out.println(permutations.permuteUnique(new int[]{1,1,2}));
    }

    List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<Integer> currentList, int[] nums, boolean[] used){
        if(currentList.size()==nums.length){
            result.add(new ArrayList<>(currentList));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i]){
                continue;
            }

            if(i > 0 && nums[i] == nums[i-1] && !used[i - 1]){
                System.out.print("rejecting: " +i+" "+nums[i]);
                continue;
            }
            currentList.add(nums[i]);
            used[i]=true;
            System.out.println(Arrays.toString(used));
            System.out.println(currentList);
            backtrack(currentList, nums, used);
            used[i]=false;
            currentList.remove(currentList.size()-1);
            System.out.println(Arrays.toString(used));
            System.out.println(currentList);

        }

    }
}
