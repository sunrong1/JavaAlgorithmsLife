package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 问题类型：
 * 链表环问题: 环的判断，【Floyd 判圈算法】（又称龟兔赛跑算法) 双指针的思路
 * <p>
 * Description
 * 给定一个链表，判断链表中是否有环
 *
 * @author dave
 * @since 2021/2/17 10:55
 */
public class NO_141_linkedList_cycle_easy {
    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = listNodeHead.next;
        //boolean ret = hasCycle(listNodeHead);
        boolean ret = hasCycle3(listNodeHead);
        System.out.println(ret);
    }

    /**
     * 快慢指针方法：
     * 快指针比慢指针快一步，这个可以手动画下
     * O ---》O----》O
     *
     * @param head
     * @return
     */
    private static boolean hasCycle3(ListNode head) {
        //特殊情况，当链表的长度比较少时
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow= head;//创建一个临时变量，缓存当前头节点的地址，也可以所指向当前头节点
        ListNode fast = head.next;// 指向慢指针的下一个
        while (fast != slow){
            slow = slow.next;
            //判空
            if (fast== null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 方法1：
     * 双指针思路，龟兔算法，快慢指针方法
     * 快指针始终比慢指针快1步，所以快指针总能追上慢指针
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * 方法2：
     * hash表方法，数据结构法
     *
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<ListNode>();
        while (head != null) {
            if (!listNodeSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
