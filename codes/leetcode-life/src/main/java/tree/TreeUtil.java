package tree;

import java.util.List;
import java.util.Queue;

/**
 * 问题类型：
 * 树的创建、使用基本问题
 * <p>
 * Description
 *
 * @author dave
 * @since 2021/2/28 6:42
 */
public class TreeUtil {
    /**
     * 前序遍历 递归创建二叉树
     *
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

}
