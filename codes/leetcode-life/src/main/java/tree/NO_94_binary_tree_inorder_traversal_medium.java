package tree;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 问题类型：
 * 树的遍历问题-中序遍历，读取和顺序右关系，递归，stack回溯方法
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

    private static void inorderTraversal_small(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        inorderTraversal_small(root.left, ret);
        ret.add(root.val);
        inorderTraversal_small(root.right, ret);
    }

    /**
     * 方法2：
     * 迭代方法，stack
     * <p>
     * 先找到最左边的节点，再保存数据，再遍历右边的所有节点
     */
    public static List<Integer> inorderTraversal_iteration(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ret.add(node.val);
            //右子树进行遍历访问
            node = node.right;
        }
        return ret;
    }
}
