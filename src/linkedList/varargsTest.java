package linkedList;

public class varargsTest {

    int varTest(int... data){
        System.out.println("进入到方法里了");
        return 1;
    }

    public static void main(String[] args) {
        int a = 3;
        varargsTest p = new varargsTest();
        a= p.varTest();
        System.out.println(a);

    }
}
