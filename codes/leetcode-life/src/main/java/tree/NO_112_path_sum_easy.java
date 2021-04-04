package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题类型：
 * 树的递归查询问题，锻炼树的使用
 * <p>
 * Description
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum
 *
 * @author dave
 * @since 2021/4/4 20:02
 */
public class NO_112_path_sum_easy {

    public static void main(String[] args) {

        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);
        boolean ret = hasPathSum(tree, 15);
        System.out.println(ret);
    }

    /**
     * 方法1：
     * 递归方法，可以锻炼递归的写法；
     * Description
     * 注意每条路径都没有target的时候，才返回false
     *
     * @Param [root, targetSum]
     * @retrun boolean
     * @since 2021/4/4 20:21
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        //递归
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        if (root.left != null && hasPathSum(root.left, targetSum - root.val)) {
            return true;
        }
        if (root.right != null && hasPathSum(root.right, targetSum - root.val)) {
            return true;
        }
        return false;
    }
}
