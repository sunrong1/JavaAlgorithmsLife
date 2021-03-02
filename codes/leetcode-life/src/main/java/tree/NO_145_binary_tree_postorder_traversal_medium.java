package tree;

import util.ArrayUtil;

import java.util.*;

/**
 * 问题类型：
 * 树的遍历问题，后序遍历
 * <p>
 * Description
 * 返回树的后序遍历
 *
 * @author dave
 * @since 2021/2/27 20:56
 */
public class NO_145_binary_tree_postorder_traversal_medium {
    public static void main(String[] args) {
        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);
        List<Integer> ret = postorderTraversal_iteration(tree);
        ArrayUtil.print(ret);
    }

    /**
     * 方法1：
     * 递归，有类似stack的味道，类似链表 NO_06offer
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> array = new ArrayList<>();
        postorderTraversal_mini(root, array);
        return array;
    }

    private static void postorderTraversal_mini(TreeNode root, List<Integer> array) {
        if (root == null) {
            return;
        }
        postorderTraversal_mini(root.left, array);
        postorderTraversal_mini(root.right, array);

        array.add(root.val);
    }

    public static List<Integer> postorderTraversal_iteration(TreeNode root) {
        List<Integer> array = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (node.right == null || pre == node.right) {
                array.add(node.val);
                pre = node;
                node = null;
            } else {
                //存在右子树未访问，将当前node压栈，继续循环访问右子树
                stack.push(node);
                node = node.right;
            }
        }
        return array;
    }
}
