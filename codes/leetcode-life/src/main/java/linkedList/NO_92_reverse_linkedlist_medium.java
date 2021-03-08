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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //起始点，走到left -1个节点
        ListNode leftnode = dummy;
        int pos = 0;
        //for 循环可能更好理解点
        while (pos < left - 1) {
            leftnode = leftnode.next;
            pos++;
        }
        //需要旋转的节点的起始节点
        ListNode mNode = leftnode.next;

        ListNode rightNode = leftnode;
        while (pos < right) {
            rightNode = rightNode.next;
            pos++;
        }
        //截取的旋转链表后的尾部
        ListNode tail = rightNode.next;


        rightNode.next = null;
        ListNode mhead = reverseList_2(mNode);

        //头部
        leftnode.next = mhead;
        //之前的头部节点，就是现在的尾部节点
        mNode.next = tail;

        return dummy.next;
    }

    private static ListNode reverseList(ListNode mNode) {
        if (mNode == null || mNode.next == null) {
            return mNode;
        }
        ListNode newHead = reverseList(mNode.next);
        mNode.next.next = mNode;
        mNode.next = null;
        return newHead;
    }

    /**
     * 方法2
     * 双指针迭代
     *
     * @param head
     * @return
     */
    private static ListNode reverseList_2(ListNode head) {
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
