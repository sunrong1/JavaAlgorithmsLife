package tree;

import util.ArrayUtil;

import java.util.*;

/**
 * @program: JavaAlgorithmsLife
 * @description: 右视图
 * @author: dave
 * @create: 2025/10/21 12:46
 **/
public class NO_199_right_side_tree_medium {
    public static void main(String[] args) {
        //      10
        //     /
        //    9
        //   / \
        //  2   3
        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(10, 9, 2, null, null, 3));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);
        ArrayUtil.print(rightSideView(tree));
    }

    /**
     * 方法1，层序遍历的最后一个数
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
                //找到当前层的最后一个节点
                if (i == size -1){
                    ret.add(node.val);
                }
            }
        }
        return ret;
    }

}
