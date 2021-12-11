import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution6 {
    //version 202104
    public String convert_version1(String s, int numRows) {
        if (numRows == 1) return s;
        int minRows = Math.min(s.length(), numRows);
        StringBuilder[] buffer = new StringBuilder[minRows];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = new StringBuilder();
        }

        boolean goingDown = false;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            buffer[curRow].append(c);
            if (curRow == 0 || curRow == minRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }
        for (int i = 1; i < buffer.length; i++) {
            buffer[0].append(buffer[i]);
        }
        return buffer[0].toString();
    }

    //version 20211204_01
    //这个控制流程思考起来还是很复杂的。一定要真正向明白多种情况之后再动笔
    public String convert_version20211204_01(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        char[] resp = new char[s.length()];
        int diff = numRows - 1;
        int posResp = 0;
        int position = 0;
        for (int i = 0; i < numRows; i++) {
            position = 0;

            if (i == 0) {
                while (position < s.length()) {
                    resp[posResp++] = s.charAt(position);
                    position += 2 * diff;
                }
                continue;
            }

            if (i == numRows - 1) {
                position += diff;
                while (position < s.length()) {
                    resp[posResp++] = s.charAt(position);
                    position += 2 * diff;
                }
                continue;
            }
            int add = i;
            while (position + add < s.length()) {
                resp[posResp++] = s.charAt(position + add);
                add = diff - add;
                position += diff;
            }
        }
        return new String(resp);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() == 1) {
            return s;
        }

        ArrayList<StringBuilder> resultList = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            resultList.add(new StringBuilder());
        }

        int pos = 0;
        int curRow = 0;
        boolean goingDown = false;
        char[] str = s.toCharArray();
        while (pos < s.length()) {
            resultList.get(curRow).append(str[pos++]);
            if (curRow == numRows - 1 || curRow == 0) goingDown = !goingDown;
            curRow = curRow + (goingDown ? 1 : -1);
        }
        StringBuilder resp = new StringBuilder();
        for (StringBuilder row : resultList) {
            resp.append(row);
        }
        return resp.toString();
    }


    @Test
    public void main() {
  /*      String s = "PAYPALISHIRING";
        int minRows = 3;
        System.out.println

   */
    }
}