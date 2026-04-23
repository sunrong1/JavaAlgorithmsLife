package tree;

/**
 * 问题类型：
 * 树的遍历问题，递归问题
 * <p>
 * Description
 * 检验这两棵树是否相同。
 *
 * @author dave
 * @since 2021/2/26 6:55
 */
public class NO_100_same_tree_easy {

    public static void main(String[] args) {
        //叶子节点
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2, left, null);
        TreeNode tree = new TreeNode(1, null, right);

        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(2, left1, null);
        TreeNode tree1 = new TreeNode(1, null, right1);
        boolean ret = isSameTree(tree, tree1);
        System.out.println(ret);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean ret = true;
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            ret = isSameTree(p.left, q.left);
            ret &= isSameTree(p.right, q.right);
        }
        return ret;
    }

    /**
     * 方法:
     * 递归，小问题可以解决，详细大问题可以解决
     * 切分小问题
     * 
     * @date 2026-4-23 13:25
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree2(TreeNode p, TreeNode q) {
        // 子问题的顺序是：根节点，左子树，右子树
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean ret = isSameTree2(p.left, q.left);
        ret = ret && isSameTree2(p.right, q.right);
        return ret;
    }
}
