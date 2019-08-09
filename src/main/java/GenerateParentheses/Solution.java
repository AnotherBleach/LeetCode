package GenerateParentheses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Another
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        calc(result, n, 1, 0, 1,new StringBuilder("("));
        return result;
    }

    public void calc(List<String> result, int n, int leftNums,int rightNums, int pos, StringBuilder current) {

        if (pos == 2 * n) {
            result.add(current.toString());
            return;
        }
        //case 1
        if (leftNums < n && pos != 2 * n - 1) {
            calc(result, n, leftNums + 1, rightNums,pos + 1, current.append("("));
            current.deleteCharAt(current.length() - 1);
            if (rightNums < n&&rightNums<leftNums) {
                calc(result, n, leftNums,rightNums+1, pos + 1, current.append(")"));
                current.deleteCharAt(current.length() - 1);
            }
        }

        //case 2
        else {
            if (rightNums < n&&rightNums<leftNums) {
                calc(result, n, leftNums,rightNums+1, pos + 1, current.append(")"));
                current.deleteCharAt(current.length() - 1);
            }
        }

    }

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(new List[]{generateParenthesis(4)}));

    }
}
