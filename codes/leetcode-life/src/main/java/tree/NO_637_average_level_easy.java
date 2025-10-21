package tree;

import util.ArrayUtil;

import java.util.*;

/**
 * @program: JavaAlgorithmsLife
 * @description: 二叉树层次遍历
 * @author: dave
 * @create: 2025/10/20 13:05
 **/
public class NO_637_average_level_easy {

    public static void main(String[] args) {
        //      3
        //     /
        //    2
        //   / \
        //  9   10
        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);
        List<Double> ret = averageOfLevels(tree);
        ArrayUtil.print(ret);
    }


    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        if (ret == null) {
            return ret;
        }
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            double sum =0;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                sum += node.val;
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null){
                    nodes.add(node.right);
                }
            }
            ret.add(sum/size);
        }
        return ret;
    }

}
