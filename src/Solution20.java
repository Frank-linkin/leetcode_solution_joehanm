import java.util.*;

public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char tem;
        for(int i=0;i<s.length();i++){
            tem = s.charAt(i);
            if(tem == '('||tem=='{'||tem == '['){
                stack.push(tem);
            }
            else if(stack.isEmpty()){
                return false;
            }
            else if( tem == ')'){
                if(stack.peek()!='('){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
            else if( tem == ']'){
                if(stack.peek()!='[')
                    return false;
                else
                    stack.pop();

            }
            else if( tem == '}'){
                if(stack.peek()!='{'){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}
