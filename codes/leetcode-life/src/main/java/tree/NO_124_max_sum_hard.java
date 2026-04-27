package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题类型：
 * 树的递归查询问题，锻炼树的使用
 * <p>
 * Description
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。给定一个二叉树的根节点 root ，返回其 最大路径和
 *
 * @author dave
 * @since 2021/4/4 20:02
 */
public class NO_124_max_sum_hard {

    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        //       -10
        //      /   \
        //     9     20
        //          /  \
        //         15   7
        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(-10, 9, 20, null, null, 15, 7));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);
        TreeUtil.levelOrderTree(tree);
        int ret = maxPathSum(tree);
        System.out.println("max path sum: " + ret);
    }

    /**
     * 最大路径和
     * 思路：递归返回每个节点向上贡献的最大路径
     * 对于每个节点，计算经过该节点的最大路径和 = max(左贡献, 0) + 节点值 + max(右贡献, 0)
     * 全局变量记录最大路径和
     *
     * @param root 根节点
     * @return 最大路径和
     */
    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 左右子树的贡献，如果是负数则不选（取0）
        int leftGain = Math.max(dfs(node.left), 0);
        int rightGain = Math.max(dfs(node.right), 0);

        // 经过当前节点的最大路径和（作为中点）
        int pathThroughNode = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, pathThroughNode);

        // 返回经过当前节点向上延伸的最大路径（只能走一条分支）
        return node.val + Math.max(leftGain, rightGain);
    }
}
