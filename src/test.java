import dataStructrue.ListNode;
import dataStructrue.TreeNode;
import org.junit.Test;
import java.util.Arrays;
import java.util.LinkedList;

public  class test {

    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(3);
    }


    @Test
    public void test1(){
        TreeNode node1 = new TreeNode(3);
        change(node1);
        System.out.println(node1.val);
    }
    public void change(TreeNode node){
        node.val = 4;
    }

    @Test
    public void testLamda(){
        Integer[] data = {2,6,4,3,5};
//        Arrays.sort(data,(Integer a,Integer b)-> {
//            return b-a;
//        });
//        for(Integer p:data){
//            System.out.printf("%d  ",p);
//        }

        ListNode[] nodes = new ListNode[5];
        for(int i = 0 ; i< nodes.length; i++){
            nodes[i] = new ListNode(data[i]);
        }
        //记住lamda表达式约等于函数
        //有参数表，箭头过后就是个大括号
        Arrays.sort(nodes,(ListNode a,ListNode b)->{
            return b.val-a.val;
        });
        for(ListNode a: nodes) {
            System.out.printf("%d ",a.val);
        }
    }

    @Test
    public void testStringBuilder(){
        //StringBuilder可以连接任何基本类型int,char,boolean,double
        //当然也可以连接String和StringBuilder
        StringBuilder builder = new StringBuilder();
        builder.append('a');
        builder.append('b');
        builder.append('c');
        System.out.println(builder.toString());
        builder.append(123);
        System.out.println(builder.toString());

        StringBuilder builder1=new StringBuilder();
        builder1.append(true);
        //两个builder相连
        builder1.append(builder);
        System.out.println(builder1);
    }

}
