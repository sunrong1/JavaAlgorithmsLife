package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: JavaAlgorithmsLife
 * @description: 二叉搜索树
 * @author: dave
 * @create: 2025/10/20 13:23
 **/
public class basic_binarysearch_tree {
    public static void main(String[] args) {
        //      10
        //     /
        //    9
        //   / \
        //  2   3
        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(10, 9, 2, null, null, 3));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);

    }
}
