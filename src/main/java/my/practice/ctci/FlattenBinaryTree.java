package my.practice.ctci;

/**
 * @author Vishal Joshi
 */
public class FlattenBinaryTree {

    public static void main(String[] args) {
        FlattenBinaryTree bt = new FlattenBinaryTree();
//        TreeNode root = new TreeNode(1);
//        root.left=new TreeNode(2, new TreeNode(3), new TreeNode(4));
//        root.right = new TreeNode(5, null, new TreeNode(6));

        TreeNode root = new TreeNode(2);
        root.left=new TreeNode(1);
        root.right = new TreeNode(4, new TreeNode(3), null);
        bt.flatten(root);
    }

    public void flatten(TreeNode root) {

        if(root ==null || (root.left == null && root.right == null)){
            return;
        }
        System.out.println(root.val);
        if (root.left == null) {
            flatten(root.right);
        } else {
            TreeNode tempRight = root.right;

            root.right = root.left;
            flatten(root.left);
            flatten(tempRight);
            rightMost(root).right = tempRight;
            root.left = null;
        }
    }

    private TreeNode rightMost(TreeNode node){
        if(node.right==null){
            return node;
        }

        return rightMost(node.right);
    }
}

class TreeNode {
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
