package linkedList;

/**
 * Description
 * 链表工具类
 *
 * @author dave
 * @since 2021/2/17 9:38
 */
public class LinkedListUtil {
    public static void printLinkedList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
