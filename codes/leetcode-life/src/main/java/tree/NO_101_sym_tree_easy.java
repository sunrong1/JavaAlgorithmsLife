package tree;

/**
 * 问题类型：
 * 树的遍历问题，递归问题
 * <p>
 * Description
 * 检验这两棵树是否对称。
 *
 * @author dave
 * @since 2026/4/21 13:25
 */
public class NO_101_sym_tree_easy {

    public static void main(String[] args) {
        //叶子节点
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        TreeNode tree = new TreeNode(2, left, right);

        boolean ret = isSymTree(tree);
        System.out.println(ret);
    }

    public static boolean isSymTree(TreeNode root) {
        boolean ret = true;
        if (root == null) {
            return true;
        }
        // else if (root.left == null && root.right == null) {
        //     return true;
        // } 
        // if (root.left != null && root.right != null) {
        //     // 左右节点值不相等，则不是对称树
        //     if (root.left.val != root.right.val) {
        //         return false;
        //     }
        // }
        // if (root.left == null || root.right == null) {
        //     return false;
        // }
        ret = isSymTree_mirror(root.left, root.right);
        return ret;
    }

    /**
     * 核心是通过镜像比较两个子树，进行递归进行比对
     * 递归公式，递归停止条件
     * @param left
     * @param right
     * @return
     */
    private static boolean isSymTree_mirror(TreeNode left, TreeNode right) {
    
         if (left == null && right == null) {
            return true;
        } 
        if (left != null && right != null) {
            // 左右节点值不相等，则不是对称树
            if (left.val != right.val) {
                return false;
            }
        }
        if (left == null || right == null) {
            return false;
        }
        boolean ret = isSymTree_mirror(left.left, right.right);
        ret &= isSymTree_mirror(left.right, right.left);
        return ret;
    }
}
