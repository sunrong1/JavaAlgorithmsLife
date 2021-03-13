package linkedList;

/**
 * 问题类型：
 * 双指针的链表的数据结构定义
 * <p>
 * Description
 * 双指针的链表问题
 *
 * @author dave
 * @since 2021/3/13 21:04
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
