package linkedList;

/**
 * 问题类型：
 * 链表基本操作问题：删除元素
 * <p>
 * Description
 * 删除链表中等于给定值 val 的所有节点
 *
 * @author dave
 * @since 2021/2/17 21:11
 */
public class NO_203_remove_linkedlist_elements_easy {

    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(2);

        ListNode ret = removeElements(listNodeHead, 2);
        LinkedListUtil.print(ret);
    }

    /**
     * 方法1：
     * 循环遍历
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {

        //头节点删除，特殊考虑
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode node = head;
        //链表只能向后搜索，当前node不是val
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

}
