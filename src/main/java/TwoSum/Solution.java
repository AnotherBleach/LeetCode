package TwoSum;

import javax.swing.text.html.parser.Entity;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    class entity implements Comparator<entity> {
        int index;
        int data;

        public int getData() {
            return data;
        }

        public int getIndex() {
            return index;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public int compare(entity o1, entity o2) {
            return o1.data-o2.data;
        }
    }
    public int[] twoSum(int[] nums, int target) {

        entity[] stores = new entity[nums.length];
        for(int i=0;i<stores.length;i++)
        {
            stores[i] = new entity();
            stores[i].setIndex(i);
            stores[i].setData(nums[i]);

        }
        Arrays.sort(stores,new entity());
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int cur = stores[left].data + stores[right].data;
            if (cur == target)
                return new int[]{stores[left].index, stores[right].index};
            else if (cur > target)
                right--;
            else left++;

        }

        return new int[]{};
    }
}
