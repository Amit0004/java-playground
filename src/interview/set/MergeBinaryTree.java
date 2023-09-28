package interview.set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }
}
public class MergeBinaryTree {

    public TreeNode merge(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;

        t1.val += t2.val;
        t1.right = merge(t1.right, t2.right);
        t1.left = merge(t1.left, t2.left);
        return t1;
    }
}
