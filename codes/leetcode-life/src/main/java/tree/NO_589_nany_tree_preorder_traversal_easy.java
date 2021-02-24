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
        ArrayUtil.printIntList(ret);
    }

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
