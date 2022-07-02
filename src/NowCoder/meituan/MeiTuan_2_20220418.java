package NowCoder.meituan;

import java.util.Scanner;

public class MeiTuan_2_20220418 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hnow,mnow,htarget,mtarget;
        hnow = in.nextInt();
        mnow = in.nextInt();
        htarget = in.nextInt();
        mtarget = in.nextInt();
        MeiTuan_2_20220418 main = new MeiTuan_2_20220418();
        System.out.println(main.countMinutes(hnow,mnow,htarget,mtarget));
    }

    public int countMinutes(int hnow,int mnow,int htarget,int mtarget) {
        return (htarget-hnow-1)*60+(60-mnow)+mtarget;
    }
}
