/*
Related to question Excel Sheet Column Title.
Given a column title as appear in an Excel sheet,
return its corresponding column number.
For example:
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
*/

package a0171_ExcelSheetColumnNumber;

public class Solution {

    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result = result * 26 + columnTitle.charAt(i) - 'A' + 1;
        }
        return result;
    }

}
