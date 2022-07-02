import org.junit.Test;

public class Solution378 {
    /**
     * 使用思路二来求解
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null&&matrix.length==0){
            return 0;
        }
        int left = matrix[0][0],right=matrix[matrix.length-1][matrix[0].length-1];
        while(left<right){
            int mid = left+((right-left)>>1);
            System.out.printf("left=%d right=%d mid=%d",left,right,mid);
            int count =searchAndCount(matrix,matrix.length-1,0,mid);
            System.out.printf("count=%d\n",count);
            if(count>=k){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return right;
    }

    public int searchAndCount(int[][] matrix,int p,int q,int target){
        if(p>=matrix.length||q>=matrix[0].length){
            return 0;
        }
        int count=0;
        int m = p,n=q;
        while(n<matrix[0].length&&matrix[m][n]<=target){
            n++;
        }
        if(n>=matrix[0].length){
            return (n-q)*(m+1);
        }
        while(m>=0&&matrix[m][n]>target){
            m--;
        }
        if(m==-1){
            return (n-q)*(p+1);
        }
        return (n-q)*(p+1)+(m+1)+searchAndCount(matrix,m,n+1,target);
    }

    @Test
    public void test1(){
        int[][] data = {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };
        //[[1,3,5],[6,7,12],[11,14,14]]
        System.out.println(kthSmallest(data,8));
    }
    /*
    思路一：k个矩阵进行归并排序
    思路二：使用题解写的二分查找
        二分查找不仅可以使用mid==target来判断，也可以使用left==right时判断。
    把这两种方法都实现一遍。
     */
}
