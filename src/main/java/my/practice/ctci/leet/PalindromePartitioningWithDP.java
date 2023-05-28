package my.practice.ctci.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vishal Joshi
 */
public class PalindromePartitioningWithDP {

    public static void main(String[] args) {
        PalindromePartitioningWithDP partioning = new PalindromePartitioningWithDP();
        partioning.partition("aab");
    }

    List<List<String>> result=new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length()==1){
            result.add(Arrays.asList(s));
            return result;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        backtrack(s, 0, new ArrayList<>(), dp);
        return result;
    }

    private void backtrack(String s, int start, List<String> partialResult, boolean[][] dp){
        if(start>=s.length()){
            result.add(new ArrayList<>(partialResult));
            return;
        }

        for(int end=start; end<s.length(); end++){
            if(s.charAt(start)==s.charAt(end) && (start<end && dp[start+1][end-1])){
                dp[start][end]=true;
                String substr = s.substring(start, end+1);
                partialResult.add(substr);
                backtrack(s, end+1, partialResult, dp);
                partialResult.remove(partialResult.size()-1);
            }
        }
    }
}
