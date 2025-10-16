package tree;

import util.ArrayUtil;

import java.util.*;

/**
 * 问题类型：
 * 树的遍历问题，前序遍历
 * <p>
 * Description
 * 节点值的 前序 遍历
 *
 * @author dave
 * @since 2021/3/2 6:53
 */
public class NO_144_binary_tree_preorder_traversal_medium {

    public static void main(String[] args) {
        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);
//        List<Integer> ret = preorderTraversal(tree);
        List<Integer> ret = preorderTraversal1(tree);
//        List<Integer> ret = preorderTraversal_iteration(tree);
        ArrayUtil.print(ret);
    }

    private static List<Integer> preorderTraversal1(TreeNode tree) {
        List<Integer> ret = new ArrayList<>();
        //遍历一次加一个
        return null;
    }

    /**
     * 方法1
     * 递归，常用的比较好理解的递归
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        TreeNode node = root;
        preorderTraversal_mini(node, ret);
        return ret;
    }

    private static void preorderTraversal_mini(TreeNode root, List<Integer> ret) {

        if (root == null) {
            return;
        }
        ret.add(root.val);
        preorderTraversal_mini(root.left, ret);
        preorderTraversal_mini(root.right, ret);

    }

    /**
     * 方法2
     * 迭代，借用栈，对节点进行逐个迭代遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal_iteration(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                ret.add(node.val);
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
        return ret;
    }
}
