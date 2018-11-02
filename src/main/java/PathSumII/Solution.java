package PathSumII;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//一发入魂
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        calc(root, sum, result, 0, new ArrayList<>());
        return result;

    }

    public void calc(TreeNode root, int sum, List<List<Integer>> result, int fromFather, List<Integer> temp) {

        if (root != null) {
            if (root.left == root.right) {
                if (fromFather + root.val == sum) {
                    List<Integer> data = new ArrayList<>(temp);
                    data.add(root.val);
                    result.add(data);
                    return;

                }


            }

            int dataToFind = sum - fromFather - root.val;
            if (root.left != null) {
                temp.add(root.val);
                calc(root.left, sum, result, fromFather + root.val, temp);
                temp.remove(temp.size()-1);
            }
            if (root.right != null) {
                temp.add(root.val);
                calc(root.right, sum, result, fromFather + root.val, temp);
                temp.remove(temp.size()-1);
            }

        }


    }


    @Test
    public void test() {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> data1 = new ArrayList<>();
        data1.add(2);
        data1.add(3);
        result.add(data1);
        System.out.println(Arrays.deepToString(result.toArray()));
        List<Integer> data2 = new ArrayList<>(data1);
        data2.add(4);
        data1.add(5);
        result.add(data2);
        System.out.println(Arrays.deepToString(result.toArray()));


    }

}
