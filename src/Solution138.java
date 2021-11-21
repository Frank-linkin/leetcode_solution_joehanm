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
    }

    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node newHead1 = new Node(0);
        Node newHead2 = new Node(0);
        newHead1.next = head;
        Node p = newHead1;
        Node q = newHead2;
        p=p.next;
        HashMap<Node, Node> map = new HashMap<>();
        while(p!=null){
            q.next = new Node(p.val);
            q.next.random = p.random;
            map.put(p,q.next);
            q=q.next;
            p=p.next;
        }
        q.next=null;

        q = newHead2;
        while(q.next!=null){
            q = q.next;
            if( q.random!=null ){
                q.random = map.get(q.random);
            }

        }
        return newHead2.next;
    }

    @Test
    public void test1(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;

        Node head = null;
    }
}
