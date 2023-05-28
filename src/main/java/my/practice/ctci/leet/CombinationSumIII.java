package my.practice.ctci.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Joshi
 */
public class CombinationSumIII {
    List<List<Integer>> result;

    public static void main(String[] args) {
        CombinationSumIII sum = new CombinationSumIII();
        sum.combinationSum3(3, 7);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int k, int remaining, List<Integer> sublist){
        if(sublist.size()==k && remaining==0){
            result.add(new ArrayList<>(sublist));
            return;
        }

        if(sublist.size()==k || remaining<=0){
            return;
        }

        for(int i=start; i<10 && remaining>=i; i++){
            sublist.add(i);
            backtrack(i+1, k, remaining-i, sublist);
            sublist.remove(sublist.size()-1);
        }
    }

}
