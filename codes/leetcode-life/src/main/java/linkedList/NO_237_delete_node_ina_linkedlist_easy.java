package linkedList;

/**
 * 问题类型：
 * 单链表节点编辑问题，删除节点
 *
 * <p>
 * Description
 * 以删除某个链表中给定的（非末尾）节点
 *
 * @author dave
 * @since 2021/2/26 21:43
 */
public class NO_237_delete_node_ina_linkedlist_easy {
    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(2);

        deleteNode(listNodeHead);
        LinkedListUtil.print(listNodeHead);
    }

    public static void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
