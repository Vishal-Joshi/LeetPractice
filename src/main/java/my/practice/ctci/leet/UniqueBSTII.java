package my.practice.ctci.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Joshi
 */
public class UniqueBSTII {

    public static void main(String[] args) {
        UniqueBSTII bst = new UniqueBSTII();
        bst.generateTrees(2);
    }

    public List<TreeNode> generateTrees(int n) {

        return generateTree(1, n);


    }


    private List<TreeNode> generateTree(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if(start>end){
            result.add(null);
            return result;
        }

        for(int i=start; i<=end; i++){
            List<TreeNode> leftSubtrees = generateTree(start, i-1);
            List<TreeNode> rightSubtrees = generateTree(i+1,end);

            for(TreeNode left: leftSubtrees){
                for(TreeNode right: rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    result.add(root);
                    String leftStr = (root.left!=null ? String.valueOf(root.left.val):"null");
                    String rightStr = (root.right!=null ? String.valueOf(root.right.val):"null");
                    System.out.printf("root: %d, left: %s, right: %s%n", root.val, leftStr, rightStr);
                }
            }

        }
        return result;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
