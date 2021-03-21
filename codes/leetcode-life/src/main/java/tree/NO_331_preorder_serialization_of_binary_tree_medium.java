package tree;

/**
 * 问题类型：
 * 树的遍历问题
 * <p>
 * Description
 * 验证二叉树的前序序列化,序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值
 *
 * @author dave
 * @since 2021/3/21 20:27
 */
public class NO_331_preorder_serialization_of_binary_tree_medium {

    public static void main(String[] args) {
        String preorder = "1,#";
        boolean ret = isValidSerialization(preorder);
        System.out.println(ret);
    }

    public static boolean isValidSerialization(String preorder) {
        return true;
    }
}
