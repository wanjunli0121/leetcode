/*
Given an index k, return the kth row of the Pascal's triangle.
For example, given k = 3, return [1,3,3,1].
*/

package a0119_PascalsTriangleTwo;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = ret.size() - 1; j >= 1; j--) {
                ret.set(j, ret.get(j - 1) + ret.get(j));
            }
            ret.add(1);
        }
        return ret;
    }
}
