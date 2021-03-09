package linkedList;

/**
 * 问题类型：
 * 链表旋转问题
 * <p>
 * Description
 * K 个一组翻转链表
 *
 * @author dave
 * @since 2021/3/9 21:56
 */
public class NO_15_reverse_nodes_in_kgroup_difficult {

    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(4);
        listNodeHead.next.next.next = new ListNode(5);
        ListNode ret = reverseKGroup(listNodeHead, 2);
        LinkedListUtil.print(ret);
    }

    /**
     * 过程复杂，指针操作较多，还是得先用草稿画个图，代码写的快点
     * 是92题和206题的扩展
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
//        if (head == null || head.next == null) {
//            return head;
//        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //移动链表的当前指向位置
        ListNode curr = dummy;
        //拼接后链表的尾部
        ListNode tail = dummy;
        while (curr != null) {
            //截取的小链表的头节点
            ListNode smallHead = curr.next;
            //从位置0走到第k个节点上
            for (int i = 0; i < k; i++) {
                curr = curr.next;
                if (curr == null) {
                    return dummy.next;
                }
            }

            //小链表尾部节点置空
            ListNode remain = curr.next;
            curr.next = null;
            //小链表反转后，进行拼接
            tail.next = reverse(smallHead);
            smallHead.next = remain;
            //拼接后的尾部位置定位
            tail = smallHead;
            //curr的指向在反转过程中发生变化，所以要重新指向小链表的尾部
            curr = smallHead;
        }

        return dummy.next;
    }

    /**
     * 参考206题
     *
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {
        //判断多余
//        if (head == null || head.next == null) {
//            return head;
//        }
        ListNode left = null;
        ListNode right = head;
        while (right != null) {
            ListNode temp = right.next;
            right.next = left;

            left = right;
            right = temp;
        }
        return left;
    }
}
