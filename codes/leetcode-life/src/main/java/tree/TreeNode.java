package tree;

/**
 * 问题类型：
 * 树结构问题，树的定义
 * <p>
 * Description
 * 基础：
 * 左孩子右兄弟表示法：可以使用二叉树表示森林，相互之间的转换参考：http://www.360doc.com/content/18/0623/13/11935121_764636401.shtml
 * 几个定义和结论
 * 1. n个节点的树的指针域的个数 = kn ，使用到的指针的个数 n-
 * 2. 二叉树，度为0（叶子）的节点比度为2的节点数多1，节点数 = n0 + n1 + n2 =n1 + 2n2 + 1 ===>n0 = n2 + 1
 * <p>
 * 节点n的高度 : n节点到叶子节点所有路径上包含节点个数的最大值。叶子节点的高度为1，往上节点的高度依次递增。
 * <p>
 * 注意：层数，高度，都是以1为起点编号的
 * 节点n的深度 : 从根节点到节点n唯一的路径的长，根节点深度为1
 * <p>
 * 层数：根节点为第一层，往下一次递增。
 * 树中节点的最大层数称之为树的深度或者高度，所以在基数为1时树的深度=树的高度=最大层数
 * 但是节点的深度和高度并没有必然的关系
 * 节点的度：节点拥有的子树的个数，度为0的节点称之为叶子节点
 * <p>
 * 树的度：是树内所有节点度的最大值
 * 树的深度：树内所有节点深度的最大值，也就是所有叶子节点深度的最大值，也就是树的层数
 * 树的高度：树内所有节点高度的最大值，也就是根节点的高度，也就是数的层数
 *
 * @author dave
 * @since 2021/2/24 6:51
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
