package linkedList;

/**
 * 问题类型：
 * ..问题
 * <p>
 * Description
 * 复制带随机指针的链表,进行深COPY
 *
 * @author dave
 * @since 2021/3/13 21:03
 */
public class NO_138_copy_list_with_random_pointer_medium {

    public static void main(String[] args) {
        Node listNodeHead = new Node(4);
        listNodeHead.next = new Node(3);
        listNodeHead.next.next = new Node(3);
        listNodeHead.next.next.next = new Node(1);


        LinkedListUtil.print(copyRandomList(listNodeHead));
    }

    /**
     * 方法1
     * 分步平行复制法
     *
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        //Step1：相邻节点复制
        Node p = head;
        //相同位置交叉复制
        while (p != null) {
            Node node = new Node(p.val);
            node.next = p.next;
            node.random = p.random;
            p.next = node;
            p = node.next;
        }
        //Step2：更新新节点的random
        p = head.next;

        return null;
    }
}
