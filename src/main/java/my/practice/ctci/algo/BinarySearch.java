package my.practice.ctci.algo;

/**
 * @author Vishal Joshi
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] nums = new int[]{2, 6, 7, 8, 9, 11, 15};
        int toFind = 2;
        int index = search.find(nums, 0, nums.length - 1, toFind);
        System.out.println(index);
    }

    private int find(int[] nums, int l, int r, int toFind) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (toFind == nums[mid]) {
            return mid;
        } else if (toFind > nums[mid]) {
            return find(nums, mid + 1, r, toFind);
        } else {
            return find(nums, l, mid - 1, toFind);
        }
        //return -1;
    }

}
