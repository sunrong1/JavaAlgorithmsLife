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
 * @since 2021/4/25 13:49
 */
public class NO_236_comon_ancestor_tree_medium {

    public static void main(String[] args) {
        //      10
        //     /
        //    9
        //   / \
        //  2   3
        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(10, 9, 2, null, null, 3));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);
        // TreeUtil.leveOrderTree(lowestCommonAncestor(tree));
    }

    /**
     * 寻找最近的祖先
     * 递归：
     * 子问题：在一个node为节点的树中，寻找最近的祖先，分别在左右子树中查找，
     * 找到了就返回node这祖先；没有找到就返回null，哪个返回了，哪个是祖先。如果哪一路返回null，
     * 说明没有找到，继续向上找
     * @param root
     * @return
     * @since 2025-10
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

}
