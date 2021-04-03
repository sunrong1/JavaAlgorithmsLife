package tree;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题类型：
 * 树的层序遍历问题
 * <p>
 * Description
 * 按从叶子节点所在层到根节点所在的层，逐层从左向右遍历
 *
 * @author dave
 * @since 2021/4/3 22:06
 */
public class NO_107_binary_tree_level_order_traversal_II_medium {

    public static void main(String[] args) {
        //叶子节点
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2, left, null);
        TreeNode tree = new TreeNode(1, null, right);
        List<List<Integer>> ret = levelOrderBottom(tree);
        ArrayUtil.printIntListList(ret);
    }

    /**
     * 方法1：
     * 递归方法，代码最简单
     * Description
     *
     * @Param [root]
     * @retrun java.util.List<java.util.List < java.lang.Integer>>
     * @since 2021/4/3 22:08
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> data = new ArrayList<>();
        levelOrderBottomSmall(root, 1, data);
        //数组反转
        for (int i = 0, j = data.size() - 1; i < j; i++, j--) {
            List<Integer> temp = data.get(i);
            data.set(i, data.get(j));
            data.set(j, temp);
        }
        return data;
    }

    /**
     * 方法1：
     * "归“的过程保存数据,右问题，只有在满二叉树的场景才可以；
     * Description
     *
     * @Param [root, row, data]
     * @retrun void
     * @since 2021/4/3 22:27
     */
    private static void levelOrderBottomSmall_noGoodExample(TreeNode root, int row, List<List<Integer>> data) {
        if (root == null) {
            return;
        }
        levelOrderBottomSmall(root.left, row + 1, data);
        levelOrderBottomSmall(root.right, row + 1, data);
        //利用递归的"归"的过程调用，保存数据，注意数组的序号编号和row的关系
        while (data.size() < row) {
            data.add(new ArrayList<>());
        }
        data.get(data.size() - row).add(root.val);
    }

    /**
     * 方法2：
     * 在”递“的过程保存数据，不过要进行数组的反转
     * Description
     *
     * @Param [root, row, data]
     * @retrun void
     * @since 2021/4/3 22:27
     */
    private static void levelOrderBottomSmall(TreeNode root, int row, List<List<Integer>> data) {
        if (root == null) {
            return;
        }
        if (data.size() < row) {
            data.add(new ArrayList<>());
        }
        data.get(row - 1).add(root.val);

        levelOrderBottomSmall(root.left, row + 1, data);
        levelOrderBottomSmall(root.right, row + 1, data);
    }
}
