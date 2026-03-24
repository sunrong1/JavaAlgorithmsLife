package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 问题类型：
 * 链表的环形问题，数学问题；脑筋急转弯
 * <p>
 * Description
 * 返回链表开始入环的第一个节点
 *
 * @author dave
 * @since 2021/3/5 20:49
 */
public class NO_142_linkedlist_cycle_ii_medium {

    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(4);
        listNodeHead.next.next.next = listNodeHead;
        //boolean ret = hasCycle(listNodeHead);
        ListNode ret = detectCycle2(listNodeHead);
        System.out.println(ret.val);
    }

    /**
     * 方法1
     * 数学推导，脑筋急转弯
     * 前置条件：fast 的速度 = 2* slow的位置，假设head距离环的焦点为J点，环的长度为C
     * 三步推导，第一步，slow指针走到相交点的时候，fast再环中走了a的位置。还剩余C-a 步到J点，
     * important->也是slow和fast的距离是C -a 步，fast走C-a步就追上slow了
     * 第二步，当fast走C-a步追上slow的时候，slow再环的位置就是C-a的位置，还差a步就到J节点了。
     * 第三步：head走到J点，slow就走到J点了
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        //专门创建一个快指针和一个慢指针
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        //找到第一次相交的节点node
        while (fast != null) {
            if (fast == slow) {
                break;
            }
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null) {
            return null;
        }
        ListNode node = head;
        while (node != slow) {
            node = node.next;
            slow = slow.next;
        }
        return node;

    }

    /**
     * 快慢指针方法，数学找出规律
     * 首先确定存在环，fast的速度是slow的2倍，就是要求Dsj
     * fast = 2* slow
     * sj = from start to joint
     * Dsj：the distance from start to joint
     * 
     * fast = Dsj + C + x
     * slow = Dsj + x
     * 2*slow = fast ==> Dsj + C + x = 2Dsj + 2x ==> C = Dsj+ x
     * ==> Dsj = C - x
     * 神奇的，有一个点再走C-x步就到joint点了，数学推理
     * 
     * 
     * @date 2026/3/24 13:30
     * @param head
     * @return
     */
    public static ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 首先找到相交的节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        // slow 和 head 一起走，相遇的点就是相交的点；恰好的数学推论，哈哈
        ListNode node = head;
        while (node != slow) {
            slow = slow.next;
            node = node.next;
        }
        return node;
    }

    /**
     * 方法2 hashSet方法
     * 第一个检测重合的点就是相交的点
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle_set(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        //找到第一次相交的节点node
        ListNode node = head;
        while (node.next != null) {
            if (!set.add(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * hashset方法，空间占用较大
     * 
     * @date 2026/3/24 13:00
     * @param head
     * @return
     */
    public static ListNode detectCycle_set2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 创建hashset，保存节点
        Set<ListNode> set = new HashSet<>();
        // 创建指针节点
        ListNode node = head;
        while (node.next != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }
}
