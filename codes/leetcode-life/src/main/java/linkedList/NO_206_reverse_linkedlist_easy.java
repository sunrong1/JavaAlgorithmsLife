package linkedList;

/**
 * 问题类型：
 * 链表反转问题
 * <p>
 * Description
 * 反转一个单链表
 *
 * @author dave
 * @since 2021/3/5 22:24
 */
public class NO_206_reverse_linkedlist_easy {

    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(4);
        //boolean ret = hasCycle(listNodeHead);
        ListNode ret = ReverseList(listNodeHead);
        LinkedListUtil.print(ret);
    }

    /**
     * 方法1
     * 双指针迭代法
     *
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        //两个两个一组，循环迭代反转
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
