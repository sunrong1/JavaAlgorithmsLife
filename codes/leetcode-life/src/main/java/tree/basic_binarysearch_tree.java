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
        boolean find = searchTree(tree,2);
        tree = insertTree(tree,2);
        boolean del = DelTreeNode(tree,9);
        System.out.println("seach 2:" + find);
        System.out.println("Del 2:" + del);
        TreeUtil.leveOrderTree(tree);
    }

    private static boolean DelTreeNode(TreeNode tree, int val) {
        if (tree == null) {
            return false;
        }
        if (tree.val == val){
            //情况1，无左右子节点
            if (tree.left == null && tree.right == null) {
                tree.val= -1;
                tree = null; //这种只是修改了引用的地址，实际树没有变化；
                return true;
            }
            //情况2，只有一个作子树
            if (tree.left == null){
                tree = tree.right;
            }
            if (tree.right == null) {
                tree = tree.left;
            }
            //情况3：有左右子树，就需要找到右子树中的最小值，替换当前节点
            TreeNode minNode = findMin(tree.right);
            tree.val = minNode.val;
            DelTreeNode(tree.right,minNode.val);
            return true;
        }
        else if (tree.val > val){
            return DelTreeNode(tree.left,val);
        }
        else {
            return DelTreeNode(tree.right,val);
        }
    }

    private static TreeNode findMin(TreeNode node) {
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    /**
     * 插入二叉查找树
     * 先找到位置，递归如果重复不允许插入，直接返回
     * @param tree
     * @param val
     * @return
     */
    private static TreeNode insertTree(TreeNode tree, int val) {
        //递归停止条件
        if (tree == null){
            return new TreeNode(val);
        }
        if (tree.val == val){
            return tree;
        }
        else if (tree.val > val) {
            tree.left = insertTree(tree.left,val);
        }
        else {
            tree.right = insertTree(tree.right,val);
        }
        return tree;
    }

    /**
     * 搜索二叉查找树
     * @param root
     * @param val
     * @return
     */
    public static boolean searchTree(TreeNode root,int val){
        if (root == null) {
            return false;
        }
        if (root.val== val){
            return true;
        }
        else if (root.val > val){
            return searchTree(root.left,val);
        }
        else {
            return searchTree(root.right,val);
        }
    }
}
