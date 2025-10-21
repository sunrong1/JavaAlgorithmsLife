package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题类型：
 * 树递归问题
 * <p>
 * Description
 * 树的镜像反转
 *
 * @author dave
 * @since 2021/4/2 22:49
 */
public class NO_226_invert_binary_tree_easy {

    public static void main(String[] args) {
        //      10
        //     /
        //    9
        //   / \
        //  2   3
        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(10, 9, 2, null, null, 3));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);
        TreeUtil.leveOrderTree(invertTree1(tree));
    }

    /**
     * 递归反转,每个节点都进行左右的反转
     * 递归公式，递归停止条件
     * @param root
     * @return
     * @since 2025-10
     */
    private static TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null || root.right != null) {
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
        }
        if (root.left != null) {
            invertTree1(root.left);
        }
        if (root.right != null) {
            invertTree1(root.right);
        }
        return root;
    }

    /**
     * 方法1：
     * 递归算法题，只需要分解成子函数，然后证明他是正确之后，就可以，
     * 不需要详解他的整个执行过程；
     * Description
     *
     * @Param [root]
     * @retrun tree.TreeNode
     * @since 2021/4/2 23:01
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tree = root.left;
        root.left = root.right;
        root.right = tree;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
