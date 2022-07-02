import org.junit.Test;

import java.util.Stack;

public class Solution71 {
    public String simplifyPath(String path) {
        char[] cpath = path.toCharArray();
        Stack<String> s = new Stack<String>();
        int lastp=0;
        int count=0;
        for(int i =0;i<cpath.length;i++){
            if(cpath[i]=='.'){
                if((i+1)<cpath.length&&cpath[i+1]=='.'){
                        i++;
                        if(!s.isEmpty()){
                            s.pop();
                        }
                }
                //else:如果是一个'.'的话就do nothing
            }

            if(cpath[i]=='.'||cpath[i]=='/'){
                count=0;
                lastp = i;
            }
            else if((cpath[i]>='a'&&cpath[i]<='z')||(cpath[i]>='A'&&cpath[i]<='Z')){
               count++;
               if(i+1==cpath.length){
                   s.push(new String(cpath,lastp+1,count));
//                   System.out.println("stack:"+s);
               }
               else if(cpath[i+1]=='.'||cpath[i+1]=='/'){
//                   System.out.println("stack:"+s);
                   s.push(new String(cpath,lastp+1,count));
                }
            }
        }

        //开始最终路径
        if(s.isEmpty()){
            return "/";
        }

        StringBuilder re = new StringBuilder();
        while(!s.isEmpty()){
            re.insert(0,s.pop());
            re.insert(0,"/");
        }


        return re.toString();
    }

    @Test
    public void test2(){
        String test1 = "/home/";
        String test2 = "/../";
        String test3 = "/home//foo/";
        String test4 = "/a/./b/../../c/";
        String test5 = "/a/../../b/../c//.//";
        String test6 = "/a//b////c/d//././/..";

        Solution71 solution = new Solution71();
//        System.out.println("test1:"+solution.simplifyPath(test1));
//        System.out.println("test2:"+solution.simplifyPath(test2));
//        System.out.println("test3:"+solution.simplifyPath(test3));
//        System.out.println("test4:"+solution.simplifyPath(test4));
//        System.out.println("test5:"+solution.simplifyPath(test5));
        System.out.println("test6:"+solution.simplifyPath(test6));
    }
}
