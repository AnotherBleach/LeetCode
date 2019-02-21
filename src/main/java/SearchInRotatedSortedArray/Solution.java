package SearchInRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (target > nums[nums.length - 1]) {

                if (nums[mid] > target) right = mid - 1;
                else {

                    if (nums[mid] > nums[nums.length - 1])
                        left = mid + 1;
                    else right = mid - 1;


                }
            } else {

                if(nums[mid]<target)left = mid+1;
                else{

                    if(nums[mid]<nums[nums.length-1])right=mid-1;
                    else left = mid+1;

                }



            }


        }
        return -1;
    }
}
