import org.junit.Test;

import java.util.*;

public class QueueTest {

    @Test
    public void test1(){
        //首删尾插的队列
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove();
        System.out.println(queue);
    }

    @Test
    public void test2(){
        //栈
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println(stack);//[2, 1]
        stack.clear();

        //Deque也可以用作双端队列
        stack.addFirst(1);;
        stack.addFirst(2);;
        stack.addLast(3);
        System.out.println(stack);//[2, 1, 3]
        stack.pollFirst();
        stack.pollLast();
        System.out.println(stack);//[1]
    }

    @Test
    public void test3(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        //List可以转化成Integer类型的数组，但不能转化成int[]类型数组
        //但二维数组可以转化为int[][]类型，应该是跟java中一切都是对象有关
        Integer[] data = list.toArray(new Integer[list.size()]);

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        //List可以转化成Integer类型的数组，但不能转化成int[]类型数组
        Integer[] data1 = list.toArray(new Integer[list.size()]);
    }
}
