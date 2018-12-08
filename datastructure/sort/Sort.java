import java.util.Random;


/**
 * Sorting Algorithms
 */
public class Sort {
    /**
     * quick sort
     */
    public static void quickSort(int[] nums){
        sort(nums, 0, nums.length - 1);
    }

    /**
     * insertion sort
     * time: O(n^2)
     * space: O(1)
     */
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int element = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > element) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = element;
        }
    }

    private static void sort(int[] nums, int lo, int hi){
        if(hi <= lo){ return; }
        int j = partition(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    private static void sortImproved(int[] nums, int lo, int hi) {
        // used 3-way. two pointers: lt, gt which can handle array which contains duplicates
        if (hi <= lo) {return;}
        int lt = lo, i = lo + 1, gt = hi;
        int pivot = nums[lo];
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, lt++, i++);
            } else if (nums[i] > pivot) {
                // don't need i++ since we need to check swaped nums[i]
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sortImproved(nums, lo, lt - 1);
        sortImproved(nums, gt + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int left = lo;
        int right = hi + 1;
        int pivot = nums[lo];
        while(true){
            while(nums[++left] > pivot){
                if(left == hi) { break; }
            }
            while(nums[--right] < pivot){
                if(right == lo) { break; }
            }
            if(left >= right){ break; }
            swap(nums, left, right);
        }
        swap(nums, lo, right);
        return right;
    }

    private static int partition2(int[] nums, int lo, int hi) {
        int i = lo, j = lo, pivot = nums[hi];
        while (j < hi) {
            if (nums[j] <= pivot) {
                swap(nums, j, i++);
            }
            j++;
        }
        swap(nums, i, hi);
        return i;
    }

    private void shuffle(int[] nums) {
        final Random random = new Random();
        for(int ind = 1; ind < nums.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(nums, ind, r);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
