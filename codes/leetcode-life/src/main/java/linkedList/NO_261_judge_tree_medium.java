package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 问题类型：
 * 并查集问题
 * 给定编号从 0 到 n-1 的 n 个节点和一个无向边列表 edges（每个元素是一对节点），请判断这些节点和边是否能构成一棵有效的树。
 * <p>
 * Description: 判断给定的节点和边是否能构成一棵有效的树
 * @author dave
 * @since 2021/3/5 22:05
 */
public class NO_261_judge_tree_medium {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{0,2},{0,3},{1,4}};
        boolean ret = validTree(5,edges);
        System.out.println(ret);
    }

    public static boolean validTree(int n, int[][] edges) {
        // if edges.length != n - 1 , return false;
        // if edges.length <n- 1, it will have a piont without edge
        // if edges.length > n - 1, it will have a circle
        if (edges.length != n -1) {
            return false;
        }
        // 初始化并查集, 每个节点都是一个集合，每个节点都指向自己
        int parent [] = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            // 0
            int parentX = find(parent, x);
            // 1
            int parentY = find(parent, y);
            //核心：若两个节点的根相同，说明它们已在同一集合中，添加这条边会形成环
            //多加一边，就会形成环，溢出
            if (parentX == parentY) {
                return false;
            }
            // 简单合并：将rootX的父节点设为rootY，0 --》1
            parent[parentX] = parentY;
           
        }
        return true;
    }

    // 查找x的根节点
    private static int find(int[] parent, int x) {
        // 路径压缩算法，将访问过的节点直接指向根节点
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    
}
