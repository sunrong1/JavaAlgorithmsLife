package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static tree.TreeUtil.*;

/**
 * @program: JavaAlgorithmsLife
 * @description: 树的基本操作
 * @author: dave
 * @create: 2025/10/15 12:50
 **/
public class Basic_tree {
    public static void main(String[] args) {
        //      3
        //     /
        //    2
        //   / \
        //  9   10
        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);
        preOrderTree(tree);
        midOrderTree(tree);
        postOrderTree(tree);
        leveOrderTree(tree);
    }


}
