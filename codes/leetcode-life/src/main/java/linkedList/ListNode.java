package linkedList;

/**
 * Description
 * 单链表
 * 特点：只能从前向后搜索，所以删除的时候，要搜索到他的前一个节点才能删除；
 * 头节点可以时有效数据也可以是无效数据，头节点时有效数据的时候，删除比较困难，要判断下一个节点是否为空；返回值也要特殊处理
 * 所以链表经常增加哑节点进行优化操作
 * <p>
 * 数组和链表思路总结：https://leetcode-cn.com/problems/delete-middle-node-lcci/solution/yi-wen-gao-ding-chang-jian-de-lian-biao-wen-ti-hua/
 *
 * @author dave
 * @since 2021/2/17 9:08
 */
public class ListNode {
    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
