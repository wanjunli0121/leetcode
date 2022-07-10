/*
Find all possible combinations of k numbers that add up to a number n,
given that only numbers from 1 to 9 can be used
and each combination should be a unique set of numbers.
Ensure that numbers within the set are sorted in ascending order.
Example 1:
Input: k = 3, n = 7
Output:
[[1,2,4]]
Example 2:
Input: k = 3, n = 9
Output:
[[1,2,6], [1,3,5], [2,3,4]]
*/

package a0216_CombinationSumThree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), k, n, 1);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int k, int n, int start) {
        if (tempList.size() == k) {
            if (n == 0) {
                list.add(new ArrayList<>(tempList));
            }
        } else {
            for (int i = start; i <= 9 && i <= n; i++) {
                tempList.add(i);
                backtrack(list, tempList, k, n - i, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
