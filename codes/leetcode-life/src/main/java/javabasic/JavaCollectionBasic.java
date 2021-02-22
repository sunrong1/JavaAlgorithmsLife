package javabasic;


import java.util.*;

/**
 * Java util中包含集合类Collections，主要实现了常用的三大集合类型：List set map类型；
 * set：一伙，一团，不相同但是类似；
 *
 * @author dave
 */
public class JavaCollectionBasic {
    public static void main(String arg[]) {

        /**
         * List ：有序列表类型
         * 实现方式ArrayList LinkedList两种
         * LinkedList类型：同样可以应用于Deque  Queue，Deque实现那Stack类型
         */
        List<String> nameList = new ArrayList<String>();
        nameList.add("sunrong");
        nameList.add("wang");
        for (String s : nameList) {
            System.out.println("list:" + s);
        }
        List<String> nameLinked = new LinkedList<String>();
        nameLinked.add("sunrong2");
        nameLinked.add("wang2");
        for (String s : nameLinked) {
            System.out.println("linkedList:" + s);
        }


        /**
         * key-value 映射表Map，使用较多的实现时HashMap
         * 不重复集合Set，使用较多的时使用HashMap封装的HashSet
         *
         */
        Map<String, String> stringMap = new HashMap<String, String>();

        //hashset 内部使用map实现
        Set<String> setNames = new HashSet<String>();

        /**
         * 队列的的操作方式
         * queue : 传统单端队列，只能一头进，一头出
         * deqeue ：双端队列，两头都能进出
         */
        Queue<Character> characterQueue = new LinkedList<Character>();
        //add remove 方法会抛异常
        characterQueue.add('a');
        characterQueue.add('b');
        System.out.println("queue:" + characterQueue.remove());
        System.out.println("queue:" + characterQueue.remove());

        characterQueue.offer('a');
        characterQueue.offer('b');
        System.out.println("queuePeek:" + characterQueue.peek());
        System.out.println("queue:" + characterQueue.poll());
        System.out.println("queue:" + characterQueue.poll());
        System.out.println("queue:" + characterQueue.poll());

        //双端队列
        Deque<Character> characterDeque = new LinkedList<Character>();

        characterDeque.offerFirst('a');
        characterDeque.offerFirst('b');
        System.out.println("dequePeek:" + characterDeque.peekFirst());
        System.out.println("deque:" + characterDeque.pollLast());
        System.out.println("deque:" + characterDeque.pollLast());
        System.out.println("deque:" + characterDeque.pollLast());
        /**
         * stack的类型，再计算机中应用非常广泛
         * 因为历史原因，没有stack的接口，但是可以借用deque实现，推荐使用deque实现
         * 使用deque实现时，注意使用push pop peek 方法，避免使用其他方法
         */
        Stack<Character> characterStack = new Stack<Character>();
        System.out.println("stack:" + characterStack.empty());
        characterStack.add('a');
        characterStack.add('b');
        //peek 只读取不删除
        System.out.println("stack:" + characterStack.peek());
        System.out.println("stack:" + characterStack.pop());
        System.out.println("stack:" + characterStack.pop());

        Deque<Character> stackDeque = new LinkedList<Character>();
        stackDeque.push('a');
        stackDeque.push('b');

        System.out.println("stackDeque:" + stackDeque.peek());
        System.out.println("stackDeque:" + stackDeque.pop());
        System.out.println("stackDeque:" + stackDeque.pop());

    }
}

