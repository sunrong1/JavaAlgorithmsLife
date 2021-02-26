package tree;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 问题类型：
 * 树的遍历问题，层序遍历，广度优先搜索，递归
 * <p>
 * Description
 * 即逐层地，从左到右访问所有节点
 *
 * @author dave
 * @since 2021/2/26 7:08
 */
public class NO_102_binary_tree_level_order_traversal_medium {
    public static void main(String[] args) {
        //叶子节点
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2, left, null);
        TreeNode tree = new TreeNode(1, null, right);
        List<List<Integer>> ret = levelOrder(tree);
        ArrayUtil.printIntListList(ret);
    }

    /**
     * 方法1：
     * 使用队列，保存每一层的节点，使用广度优先搜索，逐层向下遍历
     * 关键点：每层需要遍历的节点数，可以通过初始的queue大小确定
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> level = new LinkedList<TreeNode>();
        level.offer(root);
        //开始逐层遍历
        while (!level.isEmpty()) {
            //当前层的数据保存，并且存储下一层的要遍历的节点
            int size = level.size();
            List<Integer> levelValue = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {

                TreeNode current = level.poll();
                levelValue.add(current.val);
                if (current.left != null) {
                    level.offer(current.left);
                }
                if (current.right != null) {
                    level.offer(current.right);
                }
            }
            ret.add(levelValue);
        }
        return ret;
    }

}
