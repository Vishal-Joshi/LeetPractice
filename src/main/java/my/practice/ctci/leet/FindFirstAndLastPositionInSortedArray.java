package my.practice.ctci.leet;

/**
 * @author Vishal Joshi
 */
public class FindFirstAndLastPositionInSortedArray {
    public static void main(String[] args) {
        //int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] nums = new int[]{1, 4};
        int target = 4;
        FindFirstAndLastPositionInSortedArray solution = new FindFirstAndLastPositionInSortedArray();
        System.out.println(solution.searchRange(nums, target));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        } else if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        } else {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
    }

    private int[] binarySearch(int[] nums, int start, int end, int toFind) {
        if(start<=end){
            int mid=(end+start)/2;

            if(nums[mid]==toFind){
                if(mid==0||nums[mid]>nums[mid-1]){
                    int left = mid;
                    int right = mid;
                    while(right<end && nums[right]==nums[right+1]){
                        right++;
                        System.out.println(right);
                    }
                    return new int[]{left, right};
                } else if(nums[mid]==nums[mid-1]){
                    int left = mid-1;
                    while(start<left&&nums[left]==nums[left-1]){
                        left--;
                    }
                    int right = mid;
                    while(right<end && nums[right]==nums[right+1]){
                        right++;
                    }
                    return new int[]{left, right};
                }
            } else if(nums[mid]<toFind){
                return binarySearch(nums, mid+1, end, toFind);
            } else {
                return binarySearch(nums, start, mid-1, toFind);
            }
        }
        return new int[]{-1, -1};
    }
}
