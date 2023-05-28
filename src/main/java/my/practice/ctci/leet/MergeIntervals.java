package my.practice.ctci.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Joshi
 */
public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals intervals = new MergeIntervals();
        int[][] unmergedArray = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(intervals.merge(unmergedArray));
    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int start=0;
        List<int[]> mergedArrayList = new ArrayList<>();
        while(start<n){
            int[] i= intervals[start];
            int k = start;
            while(k<n){
                int[] j = intervals[k];
                if(i[1]<j[0]){
                    mergedArrayList.add(new int[]{i[0],i[1]});
                    break;
                } else {
                    i[1]=j[1];
                    if(k==n-1){
                        mergedArrayList.add(new int[]{i[0],i[1]});
                    }
                    k++;
                }
            }
            start=k;
        }

        return mergedArrayList.toArray(new int[mergedArrayList.size()][]);
    }
}
