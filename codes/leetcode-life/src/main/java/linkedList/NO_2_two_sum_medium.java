package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题类型：
 * 链表的遍历操作
 * <p>
 * Description
 * 两个链表相加
 *
 * @author dave
 * @since 2025/9/20 13:42
 */
public class NO_2_two_sum_medium {
    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(3);
        listNodeHead.next = new ListNode(7);
//        listNodeHead.next.next = new ListNode(4);

        ListNode listNodeHead2 = new ListNode(9);
        listNodeHead2.next = new ListNode(2);

        LinkedListUtil.print(addTwoNumbers(listNodeHead, listNodeHead2));
    }

    /**
     * 1 3 4
     * 2
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //例外情况
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //创建一个带哨兵节点的链表
        ListNode ret = new ListNode(-1);
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode tt = ret;
        //考虑进位
        int add = 0;
        while (t1!= null && t2!= null){
            tt.next = new ListNode((t1.val + t2.val + add)% 10);
            add = (t1.val+ t2.val + add)/10;
            tt = tt.next;
            t1 = t1.next;
            t2 = t2.next;

        }
        //没有加完，继续加
        while (t1 != null){
            tt.next = new ListNode((t1.val + add) % 10);
            add = (t1.val+ add)/10;
            tt = tt.next;
            t1 = t1.next;
        }
        while (t2 != null){
            tt.next = new ListNode((t2.val + add) % 10);
            add = (t2.val+ add)/10;
            tt = tt.next;
            t2 = t2.next;
        }
        if (add != 0) {
            tt.next = new ListNode(1);
        }
        return ret.next;
    }
}
