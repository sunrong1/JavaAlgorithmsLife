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

    /**
     * 方法2：
     * 迭代法，辅助stack 使用
     *
     * @param root
     * @return
     */
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
            //弹出最左边的节点
            node = stack.pop();
            //如果没有右子树，或者右子树之前已经访问过了，就可以保存当前节点的数据
            //PS：这个地方难理解，还是得画个图辅助理解下，left-> right -> root
            if (node.right == null || pre == node.right) {
                array.add(node.val);
                pre = node;
                //当前节点已经访问过了，不用压栈，需要pop 下一个节点了
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
