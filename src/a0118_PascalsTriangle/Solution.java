/*
Given numRows, generate the first numRows of Pascal's triangle.
For example, given numRows = 5,
Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

package a0118_PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(cur);
        }
        return ret;
    }

}
