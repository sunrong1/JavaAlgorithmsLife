package linkedList;

/**
 * Description
 * 单链表
 *
 * @author dave
 * @since 2021/2/17 9:08
 */
public class ListNode {
    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
