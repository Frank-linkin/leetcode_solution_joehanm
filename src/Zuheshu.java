public class Zuheshu {
    //这个是求组合数的代码
    public static void main(String[] args) {
        int n = 36;
        int m = 12;
        //正确答案：12 5167 7700

        Zuheshu a = new Zuheshu();
        System.out.println(a.combinations(n,m));
    }

    //组合数示例
    public int combinations(int n,int m ){
        if(m==0||n==0){
            return 0;
        }

        int[] com = new int[m+1];
        com[0]=1;
        for(int i = 1 ; i<=n;i++){
            if(i<m){
                for(int j = i;j>=1;j--){
                    com[j] = com[j]+com[j-1];
                    System.out.printf("%d ",com[j]);
                }
            }
            else{
                for(int j=m;j>=1;j--){
                    com[j] = com[j]+com[j-1];
                    System.out.printf("%d ",com[j]);
                }
            }
            System.out.println();
        }
        return com[m];
    }
}
