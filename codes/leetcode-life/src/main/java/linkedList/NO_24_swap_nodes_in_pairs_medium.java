package linkedList;

/**
 * 问题类型：
 * 链表的问题，链表反转
 * <p>
 * Description
 * 两两交换其中相邻的节点，并返回交换后的链表
 *
 * @author dave
 * @since 2021/3/7 21:25
 */
public class NO_24_swap_nodes_in_pairs_medium {
    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(4);
        LinkedListUtil.print(swapPairs_iteration(listNodeHead));
    }

    /**
     * 方法1
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        swapPairs(head);
        return null;
    }

    /**
     * 方法2
     * 迭代法，三指针，保存当前位置、需要交换的两个节点的位置
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs_iteration(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //当前链表的位置
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode left = curr.next;
            ListNode right = curr.next.next;
            //这样更好写
            ListNode temp = right.next;
            right.next = left;
            left.next = temp;
            curr.next = right;
//            curr.next = right;
//            left.next = right.next;
//            right.next = left;

            curr = left;
        }
        return dummy.next;
    }
}
