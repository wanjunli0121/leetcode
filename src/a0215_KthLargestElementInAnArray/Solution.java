/*
Find the kth largest element in an unsorted array.
Note that it is the kth largest element in the sorted order,
not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

package a0215_KthLargestElementInAnArray;

//import java.util.PriorityQueue;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (i < hi && less(nums[++i], nums[lo]));
            while (j > lo && less(nums[lo], nums[--j]));
            if (i >= j) {
                break;
            }
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    private boolean less(int v, int w) {
        return v < w;
    }

    private void exch(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }

//    Method 2:
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int i = 0; i < nums.length; i++) {
//            pq.offer(nums[i]);
//            if (pq.size() > k) {
//                pq.poll();
//            }
//        }
//        return pq.peek();
//    }

}
