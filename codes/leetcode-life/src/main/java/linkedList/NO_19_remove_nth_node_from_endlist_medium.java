package linkedList;

/**
 * 问题类型：
 * ..问题
 * <p>
 * Description
 *
 * @author dave
 * @since 2021/2/20 20:23
 */
public class NO_19_remove_nth_node_from_endlist_medium {
    public static void main(String[] args) {
        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(4);

        //LinkedListUtil.printLinkedList(removeNthFromEnd(listNodeHead, 2));
//        LinkedListUtil.printLinkedList(removeNthFromEnd_optimization(listNodeHead, 2));
        LinkedListUtil.printLinkedList(removeNthFromEnd_count(listNodeHead, 2));

    }

    /**
     * 方法1：
     * 双指针法，一个快指针，一个慢指针，快指针先提前走n步骤，然后再同时走
     * 当快指针.next到达尾部为null的时候，慢指针的.next就是要删除的节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        int i = 1;
        while (i <= n) {
            //fast指针快速的走到慢指针的n个节点前面，如果还没走到就为null，直接返回
            if (fast == null) {
                return head;
            }
            fast = fast.next;
            i++;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //两种结束方式，一种时fast == null，一种时fast.next ==null
        //fast== null时，只有再链表长度恰好是n时
        //删除头节点，特殊处理
        if (slow == head) {
            if (fast == null) {
                head = head.next;
            } else {
                head.next = head.next.next;
            }
        } else {
            slow.next = slow.next.next;
        }
        return head;
    }

    /**
     * 方法1的优化：
     * 优化方法：删除头节点真比较困难，就使用一个哑节点作为头节点的方式
     * 双指针法，一个慢指针指向哑节点，一个快指针，快指针先提前走n步骤，然后再同时走
     * 当快指针的next节点到达尾部null的时候，慢指针的.next就是要删除的节点
     * <p>
     * 好处：简化了对头节点的特殊处理
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd_optimization(ListNode head, int n) {

        if (head == null) {
            return head;
        }

        ListNode tempNode = new ListNode(-1);
        tempNode.next = head;
        ListNode fast = tempNode;
        ListNode slow = tempNode;
        int i = 1;
        while (i <= n) {
            fast = fast.next;
            //fast指针快速的走到慢指针的n个节点前面，如果还没走到就为null，直接返回
            if (fast == null) {
                return head;
            }
            i++;
        }
        //fast不可能为null，除非n>length
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //删除slow节点的下一个节点即可
        slow.next = slow.next.next;
        return tempNode.next;
    }

    /**
     * 方法2：
     * 参考数组的操作，搜索倒数第n个节点，就是搜索正序中的length - n个节点；
     * 对于链表来说，要删除第n个节点，就是要找到length-n-1个节点，再删除他的后一个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd_count(ListNode head, int n) {

        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (n > length) {
            return head;
        }

        ListNode tempNode = new ListNode(-1);
        tempNode.next = head;
        ListNode findNode = tempNode;
        int i = 0;
        //长度为1时，删除倒数第一个数，寻找前一个节点，就是当前的节点，就是1-1
        //长度为2时，删除n =1，寻找前一个节点就是 2-1，当前节点的下一个节点
        while (i < length - n) {
            findNode = findNode.next;
            i++;
        }
        findNode.next = findNode.next.next;

        return tempNode.next;
    }
}
