package combine;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Another
 */
public class Main {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        handle(result, n, k, 0, 1, new ArrayList<>());
        return result;
    }

    private void handle(List<List<Integer>> result, int n, int k, int pos,int cur, List<Integer> temp) {
        if(pos>=k){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=cur;i<=n;i++)
        {
            temp.add(i);
            handle(result,n,k,pos+1,i+1,temp);
            temp.remove(temp.size()-1);
        }

    }
    @Test
    public void test()
    {
        List<List<Integer>> result = combine(4,2);
        result.stream().forEach((listInteger)->{

            System.out.println(Arrays.deepToString(new List[]{listInteger}));

        });
    }

}
