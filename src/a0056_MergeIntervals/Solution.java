/*
Given a collection of intervals, merge all overlapping intervals.
Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

package a0056_MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new IntervalComparator());
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval: intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                // If the list of merged intervals is empty
                // or if the current interval does not overlap with the previous,
                // simply append it.
                merged.add(interval);
            } else {
                // Otherwise, there is overlap, so we merge the current and previous intervals.
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    private static class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a1, int[] a2) {
            return Integer.compare(a1[0], a2[0]);
        }
    }

}
