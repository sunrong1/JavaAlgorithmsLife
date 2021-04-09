package tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题类型：
 * 树的层级特性问题
 * <p>
 * Description
 * 编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * @author dave
 * @since 2021/4/5 22:44
 */
public class NO_662_maximum_width_of_binary_tree_medium {

    public static void main(String[] args) {
        Queue<Integer> pretree = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10));
        TreeNode tree = TreeUtil.createBinaryTree(pretree);
        int ret = widthOfBinaryTree(tree);
        System.out.print(ret);
    }

    /**
     * 方法1：
     * 借助队列方式
     * Description
     * 注意满二叉树的结构，必须有左节点
     *
     * @Param [root]
     * @retrun int
     * @since 2021/4/7 7:04
     */
    public static int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int width = 0;
        //队列存储映射信息
        Deque<TreeNodePair> queue = new LinkedList<>();
        queue.push(new TreeNodePair(root, 0));
        //分层遍历队列中的元素    ****|********|**********
        while (!queue.isEmpty()) {
            int size = queue.size();
            //注意和满二叉树的结构相同，节点的大小从左到右递增; 1
            int l = queue.peek().index;
            int r = queue.peek().index;
            for (int i = 0; i < size; i++) {
                //弹出本层的节点
                TreeNodePair m = queue.poll();
                TreeNode node = m.node;
                r = m.index;
                //将下一层的节点压栈
                if (node.left != null) {
                    //防止溢出，当前的值，减去上一次的最小编号，进行编码
                    queue.add(new TreeNodePair(node.left, 2 * (r - l)));
                }
                if (node.right != null) {
                    queue.add(new TreeNodePair(node.right, 2 * (r - l) + 1));
                }
            }
            if (r + 1 - l > width) {
                width = r + 1 - l;
            }
        }
        return width;
    }

    static class TreeNodePair {
        TreeNode node;
        int index;

        public TreeNodePair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }


}
