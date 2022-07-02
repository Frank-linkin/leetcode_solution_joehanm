package NowCoder.Alibaba;

import org.junit.Test;

import java.util.Scanner;
import java.util.Arrays;

//https://www.nowcoder.com/test/question/a55198d2e65746009110226f2f6c8533?pid=30440638&tid=55998340
public class Alibaba_2021_practice_1 {
    static class Data {
        public int x;
        public int y;

        public Data(int x) {
            this.x = x;
            this.y = 0;
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        Data a = new Data(3);
        Alibaba_2021_practice_1 main = new Alibaba_2021_practice_1();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            if (i != t - 1) {
                System.out.printf("%d\n", main.findMax(n, in));
            } else {
                System.out.printf("%d", main.findMax(n, in));

            }
        }
    }

    public int findMax(int n, Scanner in) {
        if (n == 1) {
            return 1;
        }
        Data[] products = new Data[n];
        for (int j = 0; j < n; j++) {
            products[j] = new Data(in.nextInt());
        }
        for (int j = 0; j < n; j++) {
            products[j].y = in.nextInt();
        }

        Arrays.sort(products, (Data a, Data b) -> {
            if (a.x != b.x) {
                return a.x - b.x;
            } else {
                return b.y - a.y;
            }
        });
        int[] lenIndex = new int[n + 1];
        lenIndex[1] = 0;
        int curMax = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            if (products[i].y > products[lenIndex[max]].y) {
                max++;
                lenIndex[max] = i;
            } else {
                int left = 1, right = max;
                while (left < right) {
                    int mid = left + ((right - left) >> 1);
                    if (products[lenIndex[mid]].y < products[i].y) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                lenIndex[left] = i;
            }
            //System.out.printf("(%d，%d) ",products[i].x,products[i].y);
            //System.out.printf("%d :",curMax);
            //for(int a : lenIndex){
            //    System.out.printf("%d ",a);
            //}
            //System.out.println();
            max = max < curMax ? curMax : max;
        }
        //System.out.println();
        return max;
    }
    /**
     * 用nlogn的复杂度解决最长单调子序列问题
     */
//    10,10,20,30,40,40,45,46,50,60,61
//    40,30,50,70,10, 9,10,15,20,21,21

    /**
     * 测试用例
     * 4
     * 11
     * 10 10 20 30 40 40 45 46 50 60 61
     * 40 30 50 70 10  9 10  15 20 21 22
     * 12
     * 10 10 20 30 40 40 45 46 50 60 61 62
     * 40 30 50 70 10  9 10  55 56 57 58 59
     * 14
     * 10 10 20 30 40 40 45 46 50 60 61 62 64 65
     * 40 30 50 70 10  9 10  55 56 57 11 12 58 59
     * 2
     * 10 20
     * 30 10
     */

    @Test
    public void test_binary_search() {
        int[] data = {1, 1, 5, 9, 9, 18};
        for (int a : data) {
            System.out.printf("%d ", a);
        }
        System.out.println();
        System.out.println("searchFirstBiggerOrEqual=" + searchFirstBiggerOrEqual(data, 0, data.length - 1, 0));
        System.out.println("searchFirstBiggerOrEqual=" + searchFirstBiggerOrEqual(data, 0, data.length - 1, 1));
        System.out.println("searchFirstBiggerOrEqual=" + searchFirstBiggerOrEqual(data, 0, data.length - 1, 2));
        System.out.println("searchFirstBiggerOrEqual=" + searchFirstBiggerOrEqual(data, 0, data.length - 1, 10));
        System.out.println("searchFirstBiggerOrEqual=" + searchFirstBiggerOrEqual(data, 0, data.length - 1, 18));
        System.out.println("searchFirstBiggerOrEqual=" + searchFirstBiggerOrEqual(data, 0, data.length - 1, 19));

        System.out.println();
        System.out.println("searchFirstBigger=" + searchFirstBigger(data, 0, data.length - 1, 0));
        System.out.println("searchFirstBigger=" + searchFirstBigger(data, 0, data.length - 1, 1));
        System.out.println("searchFirstBigger=" + searchFirstBigger(data, 0, data.length - 1, 2));
        System.out.println("searchFirstBigger=" + searchFirstBigger(data, 0, data.length - 1, 10));
        System.out.println("searchFirstBigger=" + searchFirstBigger(data, 0, data.length - 1, 18));
        System.out.println("searchFirstBigger=" + searchFirstBigger(data, 0, data.length - 1, 19));

        System.out.println();
        System.out.println("searchLastSmaller=" + searchLastSmaller(data, 0, data.length - 1, 0));
        System.out.println("searchLastSmaller=" + searchLastSmaller(data, 0, data.length - 1, 1));
        System.out.println("searchLastSmaller=" + searchLastSmaller(data, 0, data.length - 1, 2));
        System.out.println("searchLastSmaller=" + searchLastSmaller(data, 0, data.length - 1, 10));
        System.out.println("searchLastSmaller=" + searchLastSmaller(data, 0, data.length - 1, 18));
        System.out.println("searchLastSmaller=" + searchLastSmaller(data, 0, data.length - 1, 19));

        System.out.println();
        System.out.println("searchLastSmallerOrEqual=" + searchLastSmallerOrEqual(data, 0, data.length - 1, 0));
        System.out.println("searchLastSmallerOrEqual=" + searchLastSmallerOrEqual(data, 0, data.length - 1, 1));
        System.out.println("searchLastSmallerOrEqual=" + searchLastSmallerOrEqual(data, 0, data.length - 1, 2));
        System.out.println("searchLastSmallerOrEqual=" + searchLastSmallerOrEqual(data, 0, data.length - 1, 10));
        System.out.println("searchLastSmallerOrEqual=" + searchLastSmallerOrEqual(data, 0, data.length - 1, 18));
        System.out.println("searchLastSmallerOrEqual=" + searchLastSmallerOrEqual(data, 0, data.length - 1, 19));

        System.out.println();
        System.out.println("searchEqual=" + searchEqual(data, 0, data.length - 1, 0));
        System.out.println("searchEqual=" + searchEqual(data, 0, data.length - 1, 1));
        System.out.println("searchEqual=" + searchEqual(data, 0, data.length - 1, 2));
        System.out.println("searchEqual=" + searchEqual(data, 0, data.length - 1, 10));
        System.out.println("searchEqual=" + searchEqual(data, 0, data.length - 1, 18));
        System.out.println("searchEqual=" + searchEqual(data, 0, data.length - 1, 19));
    }

    public int searchEqual(int[] nums, int left, int right, int target) {
        //大于或等于target可能在nums里面找不到
        if (target > nums[right] || target < nums[left]) {
            return -1;
        }
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }


    public int searchFirstBiggerOrEqual(int[] nums, int left, int right, int target) {
        //大于或等于target可能在nums里面找不到
        if (target > nums[right]) {
            return -1;
        }
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int searchFirstBigger(int[] nums, int left, int right, int target) {
        //target可能比任何nums中的数字大
        if (target >= nums[right]) {
            return -1;
        }
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int searchLastSmaller(int[] nums, int left, int right, int target) {
        //target可能比任何nums中都小
        if (nums[left] >= target) {
            return -1;
        }

        while (left < right) {
            //注意这里用right+1，防止了无线循环
            int mid = left + ((right + 1 - left) >> 1);
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int searchLastSmallerOrEqual(int[] nums, int left, int right, int target) {
        //target可能比任何nums中都小
        if (nums[left] > target) {
            return -1;
        }

        while (left < right) {
            //注意这里用right+1，防止了无线循环
            int mid = left + ((right + 1 - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}

