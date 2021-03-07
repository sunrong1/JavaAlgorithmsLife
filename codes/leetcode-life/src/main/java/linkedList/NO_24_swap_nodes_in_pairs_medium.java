package linkedList;

/**
 * 问题类型：
 * 链表的问题，链表反转
 * <p>
 * Description
 * 两两交换其中相邻的节点，并返回交换后的链表
 *
 * @author dave
 * @since 2021/3/7 21:25
 */
public class NO_24_swap_nodes_in_pairs_medium {
    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(4);
        LinkedListUtil.print(swapPairs(listNodeHead));
    }

    /**
     * 方法1
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        return null;
    }

}
