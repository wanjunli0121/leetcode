/*
Given a positive integer,
return its corresponding column title as appear in an Excel sheet.
For example:
1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB
*/

package a0168_ExcelSheetColumnTitle;

public class Solution {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.insert(0, (char)('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return sb.toString();
    }

}
