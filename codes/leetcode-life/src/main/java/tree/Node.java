package tree;

import java.util.List;

/**
 * 问题类型：
 * N叉树问题，一般树的定义
 * <p>
 * Description
 *
 * @author dave
 * @since 2021/2/24 22:00
 */
public class Node {
    int val;
    List<Node> children;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
