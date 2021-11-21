import org.junit.Test;

public  class test {

    public static void main(String[] args) {

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

}
