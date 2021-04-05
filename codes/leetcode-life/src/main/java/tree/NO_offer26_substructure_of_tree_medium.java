package tree;

/**
 * 问题类型：
 * 树的比较问题，子树问题
 * <p>
 * Description
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * NO_100的题目衍生题目
 *
 * @author dave
 * @since 2021/4/5 20:50
 */
public class NO_offer26_substructure_of_tree_medium {

    public static void main(String[] args) {
        //叶子节点
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2, left, null);
        TreeNode tree = new TreeNode(1, null, right);

        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(2, left1, null);
        TreeNode tree1 = new TreeNode(1, null, right1);
        boolean ret = isSubStructure(tree, tree1);
        System.out.println(ret);
    }

    /**
     * 方法1：
     * 递归方法，各个条件覆盖判断；
     * Description
     *
     * @Param [A, B]
     * @retrun boolean
     * @since 2021/4/5 22:42
     */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (A.val == B.val && hasMath(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    private static boolean hasMath(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return hasMath(a.left, b.left) && hasMath(a.right, b.right);
    }
}
