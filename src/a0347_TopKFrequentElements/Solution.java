/*
Given a non-empty array of integers,
return the k most frequent elements.
For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n),
where n is the array's size.
*/

package a0347_TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        // map saves the frequency of each element in nums.
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        // bucket[i] is a list saving all elements in nums with frequency i.
        for (int key: map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(key);
        }
        List<Integer> result = new ArrayList<Integer>();

        // Frequency from large to small.
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j: bucket[i]) {
                    if (result.size() < k) {
                        result.add(j);
                    } else {
                        return result;
                    }
                }
            }
        }
        return result;
    }

}
