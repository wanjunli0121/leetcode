/*
Given n non-negative integers a1, a2, ..., an,
where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that
the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container,
such that the container contains the most water.
Note: You may not slant the container.
*/

package a0011_ContainerWithMostWater;

public class Solution {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int area = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                area = Math.max(area, height[left] * (right - left));
                // If we fix left and move right to i, for i where left < i < right,
                // no matter what height[i] is, the area is smaller.
                // So we fix right and move left.
                left++;
            } else {
                area = Math.max(area, height[right] * (right - left));
                right--;
            }
        }
        return area;
    }

}
