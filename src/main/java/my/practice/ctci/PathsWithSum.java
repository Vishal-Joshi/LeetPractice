package my.practice.ctci;

import my.practice.ctci.models.TreeNode;

import java.util.HashMap;

/**
 * 4.12 Paths with sum solution
 * @author Vishal Joshi
 */
public class PathsWithSum {

    public int countPathsWithSum(TreeNode node, int targetSum) {
        return countPathsWithSum(node, targetSum, 0, new HashMap<Integer, Integer>());
    }

    private int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (node == null) {
            return 0;
        }
        runningSum += node.getValue();
        System.out.println("running sum at node: "+node.getValue()+" is: "+runningSum);
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        if (runningSum == targetSum) {
            totalPaths++;
            System.out.println("running sum found-------: "+node.getValue()+" is: "+ totalPaths);
        }

        incrementHashTable(pathCount, runningSum, 1);
        System.out.println("totalPaths before: "+totalPaths);
        totalPaths += countPathsWithSum(node.getLeft(), targetSum, runningSum, pathCount);
        System.out.println("totalPaths after left of node: "+node.getValue()+" is: "+ totalPaths);
        totalPaths += countPathsWithSum(node.getRight(), targetSum, runningSum, pathCount);
        System.out.println("totalPaths after right of node: "+node.getValue()+" is: "+ totalPaths);
        incrementHashTable(pathCount, runningSum, -1);

        return totalPaths;
    }

    private void incrementHashTable(HashMap<Integer, Integer> pathCount, int key, int delta) {
        int newValueToAdd = pathCount.getOrDefault(key, 0) + delta;
        if (newValueToAdd == 0) {
            pathCount.remove(key);
        } else {
            pathCount.put(key, newValueToAdd);
        }
        System.out.println(pathCount);
    }
}
