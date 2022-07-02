import java.util.LinkedList;

public class Solution85 {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                "0010".toCharArray(),
                "1111".toCharArray(),
                "1111".toCharArray(),
                "1110".toCharArray(),
                "1100".toCharArray(),
                "1111".toCharArray(),
                "1110".toCharArray()



        };
        Solution85 a = new Solution85();
        System.out.println(a.maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        if ( matrix == null || matrix.length == 0|| matrix[0].length == 0 ) {
            return 0;
        }

        int[] height = new int[matrix[0].length];
        int maxAcreage = -1;
        int[] leftIndex = new int[matrix[0].length];
        int[] rightIndex = new int[matrix[0].length];
        LinkedList<Data> monotonousStack = new LinkedList<>();
        for(int i = 0 ; i< matrix.length ; i++ ) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                height[j] = matrix[i][j]=='0'?0:(height[j]+1);
                leftIndex[j] = -1;
                rightIndex[j] = matrix[0].length;
            }
            for(int p : height) {
                System.out.printf("%d ",p);
            }
            System.out.println();

            for(int j = 0 ; j < height.length ; j++ ) {
                while(monotonousStack.size()>0 && monotonousStack.getLast().height>height[j]){
                    Data last = monotonousStack.pollLast();
                    rightIndex[last.index] = j;
                }
                monotonousStack.addLast(new Data(j,height[j]));
            }
            monotonousStack.clear();

            for(int j = height.length-1;j>=0;j--) {
                while(monotonousStack.size()>0&&monotonousStack.getFirst().height>height[j]) {
                    Data first = monotonousStack.pollFirst();
                    leftIndex[first.index] = j;
                }
                monotonousStack.addFirst(new Data(j,height[j]));
            }
            monotonousStack.clear();

            for(int j = 0 ; j < height.length ; j++ ) {
                int acreage = (rightIndex[j]-leftIndex[j]-1)*height[j];
                maxAcreage = maxAcreage<acreage?acreage:maxAcreage;
            }
        }
        return maxAcreage;
    }

    class Data{
        Integer index;
        Integer height;
        public Data(Integer index, Integer height) {
            this.index = index;
            this.height = height;
        }
    }

}
