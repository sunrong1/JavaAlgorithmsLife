package linkedList;

/**
 * 问题类型：
 * 链表排序问题，
 * <p>
 * Description
 * 输入 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前
 * 保留 两个分区中每个节点的初始相对位置
 *
 * @author dave
 * @since 2021/3/11 7:04
 */
public class NO_86_partition_list_medium {

    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(4);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(3);
        listNodeHead.next.next.next = new ListNode(1);
        LinkedListUtil.print(partition(listNodeHead, 3));
    }

    /**
     * 方法1
     * 双链表法
     * head = [1,4,3,2,5,2], x = 3 ===>[1,2,2,4,3,5]
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {

        if (head == null) {
            return head;
        }
        //头节点会发生变化，用虚拟头节点
        ListNode big = new ListNode(-1);
        ListNode bp = big;
        ListNode small = new ListNode(-1);
        ListNode sp = small;
        ListNode curr = head;
        while (curr != null) {
            //sp 加上节点后，指向最后一个节点;

            //sp.next= curr
            if (curr.val < x) {
                sp.next = curr;
                //不要疑惑，两种表达方式都可以
                //sp = sp.next;
                sp = curr;
            } else {
                bp.next = curr;
//                bp = bp.next;
                bp = curr;
            }
            curr = curr.next;
        }
        bp.next = null;
        sp.next = big.next;
        return small.next;
    }
}
