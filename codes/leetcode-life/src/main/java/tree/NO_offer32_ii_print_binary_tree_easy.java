package tree;

import util.ArrayUtil;

import java.util.*;

/**
 * 问题类型：
 * 树递归查询问题问题
 * <p>
 * Description
 * 从上到下打印二叉树
 *
 * @author dave
 * @since 2021/4/3 6:46
 */
public class NO_offer32_ii_print_binary_tree_easy {

    public static void main(String[] args) {
        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);
        List<List<Integer>> ret = levelOrder(tree);
        ArrayUtil.printIntListList(ret);
    }

    /**
     * 方法1：
     * 递归打印，需要分解子问题，清晰表达子问题的表达含义
     * Description
     * 存储每层的层号信息，逐层保存每层的数据
     *
     * @Param [root]
     * @retrun java.util.List<java.util.List < java.lang.Integer>>
     * @since 2021/4/3 6:49
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> data = new ArrayList<>();
        levelOrderRecursion(root, 1, data);
        return data;
    }

    private static void levelOrderRecursion(TreeNode root, int line, List<List<Integer>> data) {
        if (root == null) {
            return;
        }
        //每个数组的数据，需要知道是在第几行
        if (data.size() < line) {
            //List<Integer> linedata = new ArrayList<>();
            data.add(new ArrayList<>());//简化写法
        }
        data.get(line - 1).add(root.val);
        levelOrderRecursion(root.left, line + 1, data);
        levelOrderRecursion(root.right, line + 1, data);
    }
}
