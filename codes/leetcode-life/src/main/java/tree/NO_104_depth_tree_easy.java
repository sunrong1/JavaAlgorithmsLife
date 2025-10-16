package tree;

import java.util.Stack;

/**
 * 问题类型：
 * 树的遍历问题，递归问题
 * <p>
 * Description
 * 求解树的最大深度。
 *
 * @author dave
 * @since 2025/10/9
 */
public class NO_104_depth_tree_easy {

    public static void main(String[] args) {
        //叶子节点
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2, left, null);
        TreeNode tree = new TreeNode(1, null, right);

        int ret = maxDepth1(tree);
        System.out.println(ret);
    }

    /**
     * 方法2  层序遍历
     * 使用stack优化二叉树的调用执行过程
     * @param root
     * @return
     */
    private static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth =0;
        //遍历一层 加1
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            depth++;
            //弹出所有的node

            Stack<TreeNode> stack1 = new Stack<>();
            int size = stack.size();
            //当前层的数量
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                stack1.add(node);
            }
            //实际可以把stack进行服用，知道他的大小即可，这样就可以节省存储空间
            while (!stack1.isEmpty()){
                TreeNode node = stack1.pop();
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            }

        }
        return depth;
    }

    /**
     * 方法1 深度优先搜索DFS，递归的方式
     * 递归的公式：max（root） = max(root.left) + max(root.right) +1
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft,maxRight) + 1;
    }
}
