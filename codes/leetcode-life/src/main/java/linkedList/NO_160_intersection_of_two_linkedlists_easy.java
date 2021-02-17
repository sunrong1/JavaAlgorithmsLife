package linkedList;

import java.util.HashSet;

/**
 * 问题类型：
 * 链表重合元素问题 ：双指针法；数据结构法
 * <p>
 * Description
 * 找到两个单链表相交的起始节点。
 *
 * @author dave
 * @since 2021/2/17 12:27
 */
public class NO_160_intersection_of_two_linkedlists_easy {
    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        //listNodeHead.next.next = new ListNode(4);

        ListNode listNodeHead2 = new ListNode(2);
//        listNodeHead2.next = listNodeHead.next;
        //      ListNode listNodeHead3 = listNodeHead.next;
        //  listNodeHead3.next = null;
        //ListNode ret = getIntersectionNode(listNodeHead, listNodeHead2);
        ListNode ret = getIntersectionNode_pointer(listNodeHead, listNodeHead2);
        System.out.println(ret.val);
    }

    /**
     * 方法1：
     * 数据结构方法，使用set数据结构判断
     * 时间复杂度：O(m+n),占用空间较多O(m+n)
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        HashSet<ListNode> listNodeHashSet = new HashSet<ListNode>();
        while (headA != null) {
            listNodeHashSet.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (!listNodeHashSet.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 方法2：
     * 双指针法，不同长度的链表，分别走两边，长度就相同了，而且，第一次相交的点就是重合的起始点，“妙”
     * 时间复杂度：O(1),占用空间较多O(m+n)
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode_pointer(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        int i = 0;
        while (a != b) {
            //不相交的时候死循环，先a遍历完，再遍历B，再重复遍历B
            a = a.next != null ? a.next : headB;
            b = b.next != null ? b.next : headA;
            if (a == headB) {
                i++;
                if (i > 2) {
                    return null;
                }
            }

        }
        return a;
    }

}
