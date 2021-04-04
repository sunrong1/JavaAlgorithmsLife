package tree;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题类型：
 * 树的层序遍历问题
 * <p>
 * Description
 * 先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行
 *
 * @author dave
 * @since 2021/4/3 22:46
 */
public class NO_103_binary_tree_z_level_order_traversal_medium {
    public static void main(String[] args) {
        //叶子节点
        TreeNode leftLevel2 = new TreeNode(4);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2, left, null);
        TreeNode tree = new TreeNode(1, leftLevel2, right);
        List<List<Integer>> ret = zigzagLevelOrder(tree);
        ArrayUtil.printIntListList(ret);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> data = new ArrayList<>();
        zigzagLevelOrderSmall(root, 1, data);
        //奇数层反转，即，奇数data数组值反转
        for (int i = 1; i < data.size(); i += 2) {
            for (int j = 0, k = data.get(i).size() - 1; j < k; j++, k--) {
                int temp = data.get(i).get(j);
                data.get(i).set(j, data.get(i).get(k));
                data.get(i).set(k, temp);
            }
        }
        return data;
    }

    private static void zigzagLevelOrderSmall(TreeNode root, int row, List<List<Integer>> data) {
        if (root == null) {
            return;
        }
        if (data.size() < row) {
            data.add(new ArrayList<>());
        }
        data.get(row - 1).add(root.val);
        zigzagLevelOrderSmall(root.left, row + 1, data);
        zigzagLevelOrderSmall(root.right, row + 1, data);
    }

}
