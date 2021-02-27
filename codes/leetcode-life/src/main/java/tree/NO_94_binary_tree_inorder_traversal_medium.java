package tree;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题类型：
 * 树的遍历问题-中序遍历，读取和顺序右关系，递归
 * <p>
 * Description
 * 二叉树的中序遍历
 *
 * @author dave
 * @since 2021/2/24 6:56
 */
public class NO_94_binary_tree_inorder_traversal_medium {

    public static void main(String[] args) {
        //叶子节点
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2, left, null);
        TreeNode tree = new TreeNode(1, null, right);
        List<Integer> ret = inorderTraversal(tree);
        ArrayUtil.print(ret);
    }

    /**
     * 方法1
     * 递归算法
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        inorderTraversal_small(root, ret);
        return ret;
    }

    public static void inorderTraversal_small(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        inorderTraversal_small(root.left, ret);
        ret.add(root.val);
        inorderTraversal_small(root.right, ret);
    }

    /**
     * 方法2：
     * TODO: 迭代方法
     */

}
