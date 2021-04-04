package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题类型：
 * 树的节点树计算问题
 * <p>
 * Description
 * 完全二叉树 的根节点 root ，求出该树的节点个数
 *
 * @author dave
 * @since 2021/4/4 22:18
 */
public class NO_222_count_complete_tree_nodes_medium {

    public static void main(String[] args) {

        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);
        int ret = countNodes(tree);
        System.out.println(ret);
    }

    /**
     * 方法1：
     * 递归方法
     * Description
     *
     * @Param [root]
     * @retrun int
     * @since 2021/4/4 22:21
     */
    public static int countNodes(TreeNode root) {

        //递归结束条件
        if (root == null) {
            return 0;
        }
        int count_left = countNodes(root.left);
        int count_right = countNodes(root.right);
        return count_left + count_right + 1;
    }
}
