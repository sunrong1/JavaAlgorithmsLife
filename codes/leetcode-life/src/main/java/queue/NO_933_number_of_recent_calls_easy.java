package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题类型：
 * 队列问题，阶段的数据统计
 * <p>
 * Description
 *
 * @author dave
 * @since 2021/3/14 20:03
 */
public class NO_933_number_of_recent_calls_easy {


}

/**
 * 了解测试用例的执行过程，更好理解
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
class RecentCounter {

    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    //[t -3000,t] 时间内所有的请求数
    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000) {
            //删除当前节点
            q.poll();
        }
        return q.size();
    }
}
