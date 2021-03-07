package linkedList;

/**
 * 问题类型：
 * 链表问题，反转
 * <p>
 * Description
 * 反转从位置 m 到 n 的链表
 * 1->2->3->4->5->NULL, m = 2, n = 4 ===》 1->4->3->2->5->NULL
 *
 * @author dave
 * @since 2021/3/7 9:36
 */
public class NO_92_reverse_linkedlist_medium {
    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(4);
        //boolean ret = hasCycle(listNodeHead);
        ListNode ret = reverseBetween(listNodeHead, 1, 2);
        LinkedListUtil.print(ret);
    }


    /**
     * 方法1
     * 迭代法
     *
     * @param head
     * @param left  起始节点为1
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {

        //1->2->3->4->5->NULL, m = 2, n = 4 ===》 1->4->3->2->5->NULL
        //先找到要反转链表的起始位置，然后进行子链表反转；反转完成后，对接
        //
        //开始两两反转 1->2->3->null ===>  null 1 2 3 null
        //找到反转的起始点位置,curr
        ListNode curr = new ListNode(-1);
        curr.next = head;
        //起始点，找到需要反转两边的前一个节点
        int pos = 0;
        while (pos < left - 1) {
            curr = curr.next;
            pos++;
        }
        ListNode pre = null;
        while (pos < right) {
            ListNode node = curr.next;
            node.next = null;
        }
        return null;
    }

}
