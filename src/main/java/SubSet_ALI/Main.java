package SubSet_ALI;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Another
 */
public class Main {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> data = new ArrayList<>();
        handle(data, nums, 0, new ArrayList<>());
        return data;
    }

    private void handle(List<List<Integer>> data, int[] nums, int position, List<Integer> cur) {
        if (position >= nums.length) {
            data.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[position]);
        handle(data, nums, position + 1, cur);
        cur.remove(cur.size() - 1);
        handle(data, nums, position+1, cur);

    }

    @Test
    public void test() {

        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> data = new ArrayList<>();
        data = subsets(nums);
        data.stream().forEach((listInteger)->{

            System.out.println(Arrays.deepToString(new List[]{listInteger}));

        });
    }
}
