package my.practice.ctci.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vishal Joshi
 */
public class ConstructBinaryTreeFromPreAndInOrder {

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreAndInOrder construct = new ConstructBinaryTreeFromPreAndInOrder();
        //System.out.println(construct.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
        System.out.println(construct.buildTree(new int[]{1,2}, new int[]{1,2}));
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }



    private TreeNode helper(int prestart, int instart, int inend, int[] preorder, int[] inorder){
        if(prestart>preorder.length-1 || instart>inend){
            return null;
        }


        TreeNode root = new TreeNode(preorder[prestart]);
        int inindex=0;
        for(int i = instart; i<=inend; i++){
            if(inorder[i]==root.val){
                inindex = i;
                break;
            }
        }

        root.left=helper(prestart+1, instart, inindex-1, preorder, inorder);
        int numsOnLeftOfRoot=inindex-instart;
        int preright=prestart+numsOnLeftOfRoot+1;
        root.right=helper(preright, inindex+1, inend, preorder, inorder);
        return root;
    }



    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
  }
}
