package my.practice.ctci.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Joshi
 */
public class NumbersWithConsecutiveDiff {
    public static void main(String[] args) {
        NumbersWithConsecutiveDiff diff = new NumbersWithConsecutiveDiff();
        System.out.println(diff.numsSameConsecDiff(3, 7));

    }

    List<Integer> result;
    public int[] numsSameConsecDiff(int n, int k) {
        result = new ArrayList<>();
        for(int start=1; start<=9; start++){
            backtrack(start, ""+start, n, k);
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i]=result.get(i);
        }
        return resultArray;
    }

    private void backtrack(int start, String current, int n, int k){
        if(current.length()==n){
            result.add(Integer.valueOf(current));
            return;
        }

        //String prev=current;
        int newVal=start+k;
        if(newVal<10){
            backtrack(newVal, current+newVal, n, k);
            //current=prev;
        }

        if(k!=0){
            newVal=start-k;
            if(newVal>=0){
                backtrack(newVal, current+newVal, n, k);
                //current=prev;
            }
        }
    }
}
