package linkedList;

/**
 * 问题类型：
 * 链表问题：节点删除，双指针法的变形，三指针法
 * <p>
 * Description
 * 给定一个排序链表，删除所有含有重复数字的节点，有重复的就一个不留
 *
 * @author dave
 * @since 2021/3/6 22:02
 */
public class NO_82_remove_duplicates_from_sorted_list_ii_medium {
    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(3);
        listNodeHead.next.next.next = new ListNode(4);
        LinkedListUtil.print(DeleteDuplicates(listNodeHead));
//        LinkedListUtil.print(deleteDuplicates_recursion(listNodeHead));
    }


    public static ListNode DeleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prenode = new ListNode(-1);
        prenode.next = head;
        //当前链表增加的起点
        ListNode curr = prenode;
        //双指针，数数，大于1个就执行删除，否则步删除
        ListNode left = prenode.next;
        ListNode right = prenode.next.next;
        while (right.next != null) {


        }

    }

}
