package tree;

/**
 * 问题类型：
 * 平衡二叉树问题
 * <p>
 * Description
 * 判断是否是高度平衡二叉树
 * 定义：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * 平衡树(Balance Tree，BT) 指的是，任意节点的子树的高度差都小于等于1
 *
 * @author dave
 * @since 2021/2/27 21:11
 */
public class NO_110_balanced_binary_tree_easy {

    public static void main(String[] args) {
        //叶子节点
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2, left, null);
        TreeNode tree = new TreeNode(1, null, right);
        boolean ret = isBalanced(tree);
        System.out.println(ret);
    }

    public static boolean isBalanced(TreeNode root) {
        return true;
    }
}
