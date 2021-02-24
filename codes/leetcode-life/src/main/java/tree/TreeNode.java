package tree;

/**
 * 问题类型：
 * 树结构问题，树的定义
 * <p>
 * Description
 *
 * @author dave
 * @since 2021/2/24 6:51
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
