package map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 图的问题，BFS
 * @description: 207. 课程表，判断是否有环
 * @author: dave
 * @create: 2026/4/14 13:11
 **/
public class NO_207_number_course_mid {
    public static void main(String[] args) {
        int[][] grid = {
                {'1', '0'},// 0的后继课程是1
                {'0', '1'}
        };
        System.out.println(canFinish(2,grid));
    }

    /**
     * Method1: BFS,邻接矩阵方法
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        
         // 1. 邻接表，记录每个节点的后继课程
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // 2. 入度数组，记录每个节点的入度
        int[] inDegree = new int[numCourses];
    // 3. 构建图和入度
        for (int[] pre : prerequisites) {
            int next = pre[0];   // 依赖别人的课
            int prev = pre[1];   // 先修课
            graph.get(prev).add(next);  // prev 的后继课程是 next
            inDegree[next]++;           // next 的入度加1
        }

          
        // 4. 队列存储所有入度为0的节点（可以立刻学习的课）
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

         // 5. 记录已学习的课程数量
        int learned = 0;
        
        // 6. BFS，遍历所有入度为0的节点
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            learned++;
            // 遍历当前课程的所有后继课程
            for (int next : graph.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

           // 7. 判断是否学完了所有课程
        return learned == numCourses;
    }



    /**
     * Method: BFS,邻接表方法
     * @date 2026/4/15 13:11
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinishBFS2(int numCourses, int[][] prerequisites) {
        //1. 初始化邻接矩阵，记录每个节点的后继课程
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        //init inDegree
        int [] inDegree = new int[numCourses];
        //2. build graph and indegree
        for (int i = 0; i < prerequisites.length; i++) {
            int[] lesson = prerequisites[i];
            // 后继课程
            int next = lesson[0];
            // 先修课程,前序课程
            int pre = lesson[1];
            graph.get(pre).add(next);
            inDegree[next]++;
        }
        // 3. create queue and add all nodes with inDegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        //4. queue not empty
        int learned =0;
        //queue not empty, 先学可以先修的课程
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            learned++;
            for(int next : graph.get(pre)){
                inDegree[next]--;
                if (inDegree[next]==0) {
                    queue.offer(next);
                }
            }
        }
         
        
        return learned == numCourses;
    }
}