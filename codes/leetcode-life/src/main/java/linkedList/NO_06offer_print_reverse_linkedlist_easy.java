package linkedList;

import util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 问题类型：
 * 链表遍历问题,stack结构使用，反转数组，递归使用
 * <p>
 * Description
 * 从尾到头反过来返回每个节点的值
 *
 * @author dave
 * @since 2021/2/27 20:20
 */
public class NO_06offer_print_reverse_linkedlist_easy {
    public static void main(String[] args) {

        ListNode listNodeHead = new ListNode(1);
        listNodeHead.next = new ListNode(3);
        listNodeHead.next.next = new ListNode(2);

        int[] ret = reversePrint_recurce(listNodeHead);
        ArrayUtil.print(Arrays.stream(ret).boxed().collect(Collectors.toList()));
    }

    /**
     * 方法1：
     * 借助stack的先进后出的特性输出
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        int size = stack.size();
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = stack.pop();
        }
        return ret;
    }

    /**
     * 方法2：
     * 反转数组
     *
     * @param head
     * @return
     */
    public static int[] reversePrint_fori(ListNode head) {

        List<Integer> array = new ArrayList<>();
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        int size = array.size();
        int[] ret = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ret[size - 1 - i] = array.get(i);
        }
        return ret;
    }

    /**
     * @param head
     * @return
     */
    public static int[] reversePrint_recurce(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        List<Integer> list = new ArrayList<>();
        reversePrint_recurce(head, list);
        int[] b = list.stream().mapToInt(Integer::valueOf).toArray();
        return b;
    }

    private static void reversePrint_recurce(ListNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        //放在这里就是正序遍历
        //list.add(head.val);
        reversePrint_recurce(head.next, list);
        //放在这里就是倒序遍历
        list.add(head.val);
    }
}


