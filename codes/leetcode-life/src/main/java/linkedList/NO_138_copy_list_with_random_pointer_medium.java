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
        //p= head.next的方式不是太好
        p = head.next;
        while (p != null) {
            if (p.random != null) {
                //p的random指针，指向的下一个节点，更新下一个节点的random
                //神来之笔
                p.random = p.random.next;
                //p从head节点的时候复制方法
                //p.next.random = p.random.next;
            }
            if (p.next != null) {
                p = p.next.next;
            }

        }
        //Step3：拆成两个独立的链表
        Node newNode = new Node(-1);
        Node pNew = newNode;
        p = head;
        while (p != null && p.next != null) {
            //更新指针域
            pNew.next = p.next;
            //更新指针域
            p.next = p.next.next;
            pNew = pNew.next;
            p = p.next;
        }
        return newNode.next;
    }
}
