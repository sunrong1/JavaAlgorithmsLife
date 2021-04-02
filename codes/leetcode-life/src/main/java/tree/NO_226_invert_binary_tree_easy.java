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
 * @since 2021/4/2 22:49
 */
public class NO_226_invert_binary_tree_easy {

    public static void main(String[] args) {
        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);
        TreeNode ret = invertTree(tree);
        System.out.print(ret);
    }

    /**
     * 方法1：
     * 递归算法题，只需要分解成子函数，然后证明他是正确之后，就可以，不需要详解他的整个执行过程；
     * Description
     *
     * @Param [root]
     * @retrun tree.TreeNode
     * @since 2021/4/2 23:01
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tree = root.left;
        root.left = root.right;
        root.right = tree;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
