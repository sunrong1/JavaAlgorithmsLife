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
        ListNode ret = ReverseList_recurse(listNodeHead);
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
            return head;
        }
        System.out.println("node 值：" + head.val);

        //开始两两反转 1->2->3->null ===>  null 1 2 3 null
        //while的结束位置判断，推导清楚
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

    /**
     * 方法2
     * 讲解参考：https://leetcode-cn.com/problems/reverse-linked-list/solution/shi-pin-jiang-jie-die-dai-he-di-gui-hen-hswxy/
     * 递归方法:1. 大问题拆成子问题；2.子问题的求解的方式和大问题的方式是一致的 3.存在最小子问题
     * 先找到尾节点，利用回溯过程，进行链表的反转
     *
     * @param head
     * @return
     */
    public static ListNode ReverseList_recurse(ListNode head) {

        //递归的结束条件
        if (head == null || head.next == null) {
            return head;
        }
        System.out.println("递node 值：" + head.val);

        //1->2->3->null ====>
        //递归，一个个节点进行反转 head-> node1->null
        //node 反转后的头节点
        ListNode newHead = ReverseList_recurse(head.next);
        System.out.println("归node 值：" + head.val);

        //进行反转操作
        head.next.next = head;
        //防止出现循环链表
        head.next = null;
        return newHead;
    }

    /**
     * 两两反转
     * 思想：分割两部分的思想，一部分是反转的部分的new linklist，一部分是未反转的部分old linklist
     * pre = null, 表示新链表的头节点
     * cur 表示未反转的链表的头节点
     * 1次反转后：
     * 
     * @param head
     * @return
     */
    private static ListNode reverseList_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null; // 前驱节点，初始为Null，新链表的第一个节点
        ListNode cur = head; //
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
