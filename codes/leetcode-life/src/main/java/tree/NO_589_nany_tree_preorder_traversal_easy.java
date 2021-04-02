package tree;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题类型：
 * 树的遍历问题-前序遍历，递归
 * <p>
 * Description
 * 给定一个 N 叉树，返回其节点值的前序遍历
 *
 * @author dave
 * @since 2021/2/24 21:57
 */
public class NO_589_nany_tree_preorder_traversal_easy {
    public static void main(String[] args) {

        Node node1 = new Node(3);
        Node node2 = new Node(2);
        List<Node> children1 = new ArrayList<Node>();
        children1.add(node1);
        children1.add(node2);
        Node tree = new Node(1, children1);
        List<Integer> ret = preorder(tree);
        ArrayUtil.print(ret);
    }

    /**
     * 方法1：
     * 递归过程，只需要进行子问题划分即可，不需要理解整个执行过程（这个需要大量的思考和练习中锻炼出来）
     * Description
     *
     * @Param [root]
     * @retrun java.util.List<java.lang.Integer>
     * @since 2021/4/2 22:44
     */
    public static List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        preorder_small(root, ret);
        return ret;

    }

    public static void preorder_small(Node root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        ret.add(root.val);
        if (root.children == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            preorder_small(root.children.get(i), ret);
        }


    }

}
