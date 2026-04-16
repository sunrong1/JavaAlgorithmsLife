package tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
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
        // 构造测试用例，3层二叉树
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2, left, null);
        TreeNode tree = new TreeNode(1, null, right);

        int ret = maxDepth3(tree);
        System.out.println(ret);
    }

    /**
     * 方法2 层序遍历
     * 使用stack优化二叉树的调用执行过程
     * 使用栈的非递归方式计算二叉树的最大深度
     * 
     * @param root 二叉树的根节点
     * @return 二叉树的最大深度，空树返回0
     */
    private static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        // 遍历一层 加1
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            depth++;
            // 弹出所有的node

            Stack<TreeNode> stack1 = new Stack<>();
            int size = stack.size();
            // 当前层的数量
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                stack1.add(node);
            }
            // 实际可以把stack进行服用，知道他的大小即可，这样就可以节省存储空间
            while (!stack1.isEmpty()) {
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
     * 
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft, maxRight) + 1;
    }

    /**
     *
     * 练习1 ：使用递归的方式
     * 左右并行往下进行递归遍历，找到最大深度
     * 
     * @param root
     * @return
     * @since 2026/1/28 12:52
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth2(root.left);
        int r = maxDepth2(root.right);
        return Math.max(l, r) + 1;
    }

    /**
     *
     * 练习2 ：使用队列的方式
     * 
     * @param root
     * @return
     * @since 2026/2/4 12:52
     */
    public static int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        // 用队列进行层次遍历
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            // 遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                // 弹出当前层的所有节点
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }

    /**
     * the depth of the tree using a different approach
     * THe easy way is to use the 层序遍历
     * 
     * @date 2026/4/16 13:20
     * @param root
     * @return
     */
    public static int maxDepth_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 1. create the queue
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        // Use queue for level order traversal
        while (!queue.isEmpty()) {
            depth++;
            // 1. get the size of the queue,the know the number of nodes in the current
            // level
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 2. add the children of the node to the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }

    /**
     * use the
     * 1.1 递归三要素
     * 基本情况（Base Case）：当节点为空时，深度为0
     * 递归关系：当前节点深度 = max(左子树深度, 右子树深度) + 1
     * 递归方向：从根节点开始，先处理左右子树，再处理当前节点（后序遍历）
     * 
     * @date 2026/4/16 13:30
     * @param root
     * @return
     */
    public static int maxDepth_416(TreeNode root) {
        // Recursive approach to calculate the depth
        // 1. 递归的终止条件, 如果root为空，则返回0,说明到了最低层
        if (root == null) {
            return 0;
        }
        // 2. 递归的公式，max(root) = max(root.left) + max(root.right) + 1
        int left = maxDepth_416(root.left);
        int right = maxDepth_416(root.right);
        int depth = Math.max(left, right) + 1;
        return depth;
    }

}
