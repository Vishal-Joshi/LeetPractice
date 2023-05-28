package my.practice.ctci.leet;

import my.practice.ctci.models.TreeNode;

import java.util.*;

/**
 * @author Vishal Joshi
 */
public class AllFullBinaryTrees {


    public static void main(String[] args) {
        AllFullBinaryTrees afbt = new AllFullBinaryTrees();
        afbt.allPossibleFBT(3);
    }


    private Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {

        if(map.containsKey(n)){
            System.out.println("returning from map for n: "+n);
            return map.get(n);
        }


        if(n==1){
            List<TreeNode> oneList = Collections.singletonList(new TreeNode(0));
            map.put(n, oneList);
            return oneList;
        }

        List<TreeNode> list = new ArrayList<>();

        System.out.println("finding for n= "+n);
        for(int i=1; i<=n; i+=2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-i-1);
            for(TreeNode leftSubtree: left){
                for(TreeNode rightSubtree: right){
                    TreeNode root = new TreeNode(0);
                    root.left = clone(leftSubtree);
                    root.right = clone(rightSubtree);
                    list.add(root);
                }
            }
        }
        System.out.println("---------putting in map for n: "+n);
        map.put(n, list);
        return list;
    }

    public TreeNode clone(TreeNode tree)  {
        if (null == tree)
        {
            return null;
        }

        TreeNode new_tree = new TreeNode(tree.value);
        new_tree.left = clone(tree.left);
        new_tree.right = clone(tree.right);
        return new_tree;
    }

}
