package tree;

import java.util.*;

/**
 * 问题类型：
 * 二叉搜索树查找问题
 * <p>
 * Description
 * 一棵二叉搜索树，请找出其中第k大的节点
 * 二叉搜索树概念: 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
 *
 * @author dave
 * @since 2021/4/5 11:15
 */
public class NO_offer54_find_kth_number_binary_tree_easy {

    public static void main(String[] args) {
        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(3, 1, null, 2, null, null, 4));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);
        int ret = kthLargest_inorder(tree, 1);
        System.out.println(ret);
    }

    /**
     * 方法1：
     * 递归方法
     * Description
     * 找第kth大，就要数下右子树的个数，右边的数是大的；
     *
     * @Param [root, k]
     * @retrun int
     * @since 2021/4/5 11:24
     */
    public static int kthLargest(TreeNode root, int k) {
        int count_r = getCount(root.right);
        if (count_r >= k) {
            return kthLargest(root.right, k);
        } else if (count_r + 1 == k) {
            return root.val;
        }
        return kthLargest(root.left, k - count_r - 1);
    }

    private static int getCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getCount(root.left) + getCount(root.right) + 1;
    }

    /**
     * 方法2：
     * 中序遍历的方式
     * Description
     *
     * @Param [root, k]
     * @retrun int
     * @since 2021/4/5 19:42
     */
    public static int kthLargest_inorder(TreeNode root, int k) {
        List<Integer> data = new ArrayList<>();
        inorder(root, data);
        return data.get(data.size() - k);
    }

    private static void inorder(TreeNode root, List<Integer> data) {
        if (root == null) {
            return;
        }
        inorder(root.left, data);
        data.add(root.val);
        inorder(root.right, data);
    }
}
