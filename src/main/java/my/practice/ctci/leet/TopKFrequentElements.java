package my.practice.ctci.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vishal Joshi
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> intCount = new HashMap<>();
        for (int num : nums) {
            Integer alreadyCount = intCount.get(num);
            if (alreadyCount != null) {
                intCount.put(num, ++alreadyCount);
            } else {
                intCount.put(num, 1);
            }
        }

        List<List<Integer>> bucketSort = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            bucketSort.add(new ArrayList<>());
        }


        for (Map.Entry<Integer, Integer> entry : intCount.entrySet()) {
            System.out.println("entry.getValue(): " + entry.getValue() + " entry.getKey():" + entry.getKey());

            bucketSort.get(entry.getValue()).add(entry.getKey());
        }

        int[] result = new int[k];
        for (int i = bucketSort.size() - 1, j = 0; i >= 0 && j < k; i--) {
            if (!bucketSort.get(i).isEmpty()) {
                for (int elem : bucketSort.get(i)) {
                    result[j] = elem;
                    j++;
                    if (j >= k) {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements topElem = new TopKFrequentElements();
        int[] n = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        topElem.topKFrequent(n, k);
    }

}
