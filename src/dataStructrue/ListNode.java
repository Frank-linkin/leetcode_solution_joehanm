package dataStructrue;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; this.next = null;}
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void  showLinkedList(){
        ListNode p = this;
        System.out.printf("LinkedList:");
        while(p!=null) {
            System.out.printf("%d ",p.val);
            p = p.next;
        }
    }
}
