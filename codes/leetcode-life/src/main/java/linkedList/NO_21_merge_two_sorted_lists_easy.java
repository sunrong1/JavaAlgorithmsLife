package linkedList;

/**
 * 问题类型：
 * 链表问题，单链表;递归问题
 * <p>
 * Description
 * 将两个升序链表合并为一个新的 升序 链表并返回
 *
 * @author dave
 * @since 2021/2/16 20:54
 */
public class NO_21_merge_two_sorted_lists_easy {

    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(4);

        ListNode listNodeHead2 = new ListNode(2);

        //LinkedListUtil.printLinkedList(mergeTwoLists(listNodeHead, listNodeHead2));
        LinkedListUtil.print(mergeTwoLists_recursion(listNodeHead, listNodeHead2));
    }

    /**
     * 方法1：暴力解法
     * 三个链表指针移动，循环保存数据
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode preHead = new ListNode(-1);

        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 != null ? l1 : l2;
        return preHead.next;
    }

    /**
     * 方法2：递归解法
     * 将大问题，可以递归分解成小问题，递归保存数据
     * 时间和空间复杂度，都是O(m+n)
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists_recursion(ListNode l1, ListNode l2) {

        //递归的停止条件
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        //递归的归并条件
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists_recursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_recursion(l2.next, l1);
            return l2;
        }

    }
}
