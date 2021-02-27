package tree;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

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
        //叶子节点
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2, left, null);
        TreeNode tree = new TreeNode(1, null, right);
        List<Integer> ret = postorderTraversal(tree);
        ArrayUtil.print(ret);
    }

    /**
     * 递归，右类似stack的味道，类似链表 NO_06offer
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> array = new ArrayList<>();
        postorderTraversal_mini(root, array);
        return array;
    }

    public static void postorderTraversal_mini(TreeNode root, List<Integer> array) {
        if (root == null) {
            return;
        }
        postorderTraversal_mini(root.left, array);
        postorderTraversal_mini(root.right, array);

        array.add(root.val);
    }
}
