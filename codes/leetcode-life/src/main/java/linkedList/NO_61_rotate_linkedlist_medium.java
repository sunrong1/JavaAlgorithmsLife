package linkedList;

/**
 * 问题类型：
 * 链表问题，循环链表
 * <p>
 * Description
 * 旋转链表，将链表每个节点向右移动 k 个位置
 *
 * @author dave
 * @since 2021/3/5 6:59
 */
public class NO_61_rotate_linkedlist_medium {

    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(4);
//        listNodeHead.next.next.next = new ListNode(5);
        //LinkedListUtil.printLinkedList(removeNthFromEnd(listNodeHead, 2));
//        LinkedListUtil.printLinkedList(removeNthFromEnd_optimization(listNodeHead, 2));
        LinkedListUtil.print(rotateRight(listNodeHead, 1));

    }

    /**
     * 循环链表法
     * 这个真难写。。
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        int n = 1;
        //查找最后一个节点，然后进行首位相连
        while (node.next != null) {
            n++;
            node = node.next;
        }
        node.next = head;

        //目标是找到tail节点，当前再Head上
        ListNode tail = head;
        int i = 0;
        //向右旋转k次，我就要走n - k-1步，到达的那个节点作为头节点，根据链表的特点，所以我让走到n -k -1的位置
        // 然后从当前节点.next =null,返回下一个节点作为head
        while (i < n - k % n - 1) {
            tail = tail.next;
            i++;
        }
        ListNode newNode = tail.next;
        tail.next = null;
        return newNode;
    }

}
