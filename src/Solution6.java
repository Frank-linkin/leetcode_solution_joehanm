import org.junit.Test;

public class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int minRows = Math.min(s.length(),numRows);
        StringBuilder[] buffer = new StringBuilder[minRows];
        for(int i = 0 ; i<buffer.length;i++){
            buffer[i]=new StringBuilder();
        }

        boolean goingDown = false;
        int curRow = 0;
        for(char c:s.toCharArray()){
            buffer[curRow].append(c);
            if(curRow==0||curRow==minRows-1) goingDown=!goingDown;
            curRow+=goingDown?1:-1;
        }
        for(int i = 1;i<buffer.length;i++){
            buffer[0].append(buffer[i]);
        }
        return buffer[0].toString();
    }


    @Test
    public void main(){
        String s = "paypalishiring";
        int minRows = 3;
        System.out.println(
                convert(s,minRows)
        );
    }
}
