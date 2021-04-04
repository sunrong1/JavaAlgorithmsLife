package tree;

/**
 * 问题类型：
 * 树的三大遍历的关系问题
 * <p>
 * Description
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * (树中没有重复的元素)
 *
 * @author dave
 * @since 2021/4/4 20:30
 */
public class NO_105_construct_binary_tree_from_pre_and_inorder_traversal_medium {
    public static void main(String[] args) {

        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode ret = buildTree(preorder, inorder);
        System.out.print(ret);
    }

    /**
     * 方法1：
     * 递归方法；
     * Description
     * 主要是绘图解决，辅助理解
     * 1.找根节点 2. 递归建立左子树 3，递归建立右子树
     * 【root, 1,2,3】
     * 【1,2,root,3】
     *
     * @Param [preorder, inorder]
     * @retrun tree.TreeNode
     * @since 2021/4/4 20:36
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //递归的结束条件
        if (preorder.length == 0) {
            return null;
        }
        //根节点位置,在中序遍历序列中,(注意条件是树中没有重复元素)
        int pos = 0;
        while (inorder[pos] != preorder[0]) {
            pos++;
        }
        //获取左子树的前序遍历，和中序遍历
        int[] lpre = new int[pos];
        int[] lin = new int[pos];
        for (int i = 0; i < pos; i++) {
            //左子树的前序遍历和左子序的中序遍历
            lpre[i] = preorder[i + 1];
            lin[i] = inorder[i];
        }
        int[] rpre = new int[preorder.length - 1 - pos];
        int[] rin = new int[preorder.length - 1 - pos];
        int num = 0;
        for (int i = pos + 1; i < preorder.length; i++) {
            rpre[num] = preorder[i];
            rin[num] = inorder[i];
            num++;
        }

        //递归中子问题解决，逐渐构建结果
        TreeNode node = new TreeNode(preorder[0]);
        node.left = buildTree(lpre, lin);
        node.right = buildTree(rpre, rin);
        return node;
    }
}
