package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树的递归创建、使用基本问题
 * <p>
 * Description
 *
 * @author dave
 * @since 2021/2/28 6:42
 */
public class TreeUtil {
    /**
     * 通过前序遍历
     * 递归创建二叉树
     * 遇到null返回，否则会一直是主节点
     * 举例：
     * [1, 2, null, null, 3, 4, null, null, 5, null, null]
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     * @param array
     * @return
     */
    public static TreeNode createBinaryTree(Queue<Integer> array) {
        if (array == null || array.isEmpty()) {
            return null;
        }

        TreeNode node = null;
        Integer data = array.poll();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(array);
            node.right = createBinaryTree(array);
        }
        return node;
    }

    /**
     * 失败的案例，i是值传递，递归中使用失败
     *
     * @param array
     * @param i
     * @return
     */
    public static TreeNode createBinaryTree_mini_fail(List<Integer> array, int i) {
        if (array == null) {
            return null;
        }
        if (i > array.size() - 1) {
            return null;
        }
        TreeNode node = null;
        Integer data = array.get(i);
        if (data != null) {
            node = new TreeNode(data);
            i++;
            node.left = createBinaryTree_mini_fail(array, i);
            i++;
            node.right = createBinaryTree_mini_fail(array, i);
        }
        return node;
    }

    /**
     * 层序遍历
     * @param tree
     */
    public static void leveOrderTree(TreeNode tree) {
        if (tree == null) {
            System.out.println("层序：NULL");
            return;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(tree);
        while (!nodes.isEmpty()){
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                System.out.println("层序：" + node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }

        }

    }

    public static void postOrderTree(TreeNode tree) {
        if (tree == null) {
            System.out.println("Post:Null" );
            return;
        }
        postOrderTree(tree.left);
        postOrderTree(tree.right);
        System.out.println("post:" + tree.val);

    }

    public static void midOrderTree(TreeNode tree) {
        if (tree == null) {
            System.out.println("mid:NULL");
            return;
        }
        midOrderTree(tree.left);
        System.out.println("mid：" + tree.val);
        midOrderTree(tree.right);
    }

    public static void preOrderTree(TreeNode tree) {
        if (tree == null){
            System.out.println("Pre：NULL");
            return;
        }
        System.out.println("Pre：" + tree.val);
        preOrderTree(tree.left);
        preOrderTree(tree.right);
    }

}
