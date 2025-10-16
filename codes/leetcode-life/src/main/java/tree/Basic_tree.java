package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
    }

    private static void postOrderTree(TreeNode tree) {
        if (tree == null) {
            System.out.println("Post:Null" );
            return;
        }
        postOrderTree(tree.left);
        postOrderTree(tree.right);
        System.out.println("post:" + tree.val);

    }

    private static void midOrderTree(TreeNode tree) {
        if (tree == null) {
            System.out.println("mid:NULL");
            return;
        }
        midOrderTree(tree.left);
        System.out.println("mid：" + tree.val);
        midOrderTree(tree.right);
    }

    private static void preOrderTree(TreeNode tree) {
        if (tree == null){
            System.out.println("Pre：NULL");
            return;
        }
        System.out.println("Pre：" + tree.val);
        preOrderTree(tree.left);
        preOrderTree(tree.right);
    }
}
