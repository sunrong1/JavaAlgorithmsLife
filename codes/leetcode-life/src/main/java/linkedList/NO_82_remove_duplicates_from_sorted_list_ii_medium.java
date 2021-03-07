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
        //新步重复链表的起点
        ListNode curr = prenode;
        //双指针，判断是否存储重复，存在重复就进行删除，否则curr继续向向前走
        while (curr.next != null && curr.next.next != null) {
            //紧接的两个节点数值相同，发现重复，开始删除炒作
            if (curr.next.val == curr.next.next.val) {
                ListNode node = curr.next.next;
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                curr.next = node.next;
            } else {
                curr = curr.next;
            }
        }
        return prenode.next;

    }

}
