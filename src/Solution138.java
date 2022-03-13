import com.sun.jndi.cosnaming.IiopUrl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
        public Node(){
            this.val = 0;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        //用个HashMap记录新老的对应关系
        if ( head == null ) {
            return null;
        }

        Node newHead = new Node(-1);
        Node p = head ,q = newHead;

        Map<Node,Node> map = new HashMap<Node,Node>();
        map.put(null,null);
        while(p!=null) {
            q.next = new Node(p.val);
            map.put(p,q.next);

            q=q.next;
            p = p .next;
        }

        q = newHead.next;
        p = head;
        while(p!=null) {
            q.random = map.get(p.random);

            q = q.next;
            p = p.next;
        }

        return newHead.next;
    }

    @Test
    public void test1(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;

        Node head = null;

        Map<Node,Node> nodeHashMap = new HashMap<Node,Node>();
        nodeHashMap.put(null,node1);
        Node node = nodeHashMap.get(null);
        System.out.println(node.val);
    }
}
