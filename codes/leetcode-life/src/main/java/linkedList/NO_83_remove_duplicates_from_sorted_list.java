package linkedList;

/**
 * 问题类型：
 * 链表问题：节点删除；
 * <p>
 * Description
 * 排序链表，删除所有重复的元素，保证只出现一次
 *
 * @author dave
 * @since 2021/2/17 10:01
 */
public class NO_83_remove_duplicates_from_sorted_list {
    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(3);
        listNodeHead.next.next.next = new ListNode(4);
        //  LinkedListUtil.printLinkedList(deleteDuplicates(listNodeHead));
        LinkedListUtil.print(deleteDuplicates_recursion(listNodeHead));
    }

    /**
     * 方法1
     * 单指针移动即可，跳过数字重复的节点
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode pre = head;
        while (pre != null && pre.next != null) {
            if (pre.val == pre.next.val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }

    /**
     * 方法2
     * 递归，跳过数字重复的节点
     * 从后向前递归，一直到head节点；
     * 递归前进，组成一个链表的结构：1->3->3-> 4 ;到尾节点4的时候，开始递归返回，4 -> 3 ,再上返回的时候，出现了相等，于是返回了当前节点的next，于是4->3,最后合并1
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates_recursion(ListNode head) {
        if (head == null) {
            return head;
        }
        head.next = deleteDuplicates_recursion(head.next);
        if (head.next != null && head.val == head.next.val) {
            return head.next;
        }
        return head;
    }

}
