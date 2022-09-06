/*
Given a digit string,
return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order,
your answer could be in any order you want.
*/

package a0017_LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            String s = map.get(c);
            if (list.isEmpty()) {
                for (int j = 0; j < s.length(); j++) {
                    list.add(String.valueOf(s.charAt(j)));
                }
            } else {
                List<String> tempList = new ArrayList<>();
                for (String value : list) {
                    for (int j = 0; j < s.length(); j++) {
                        tempList.add(value + s.charAt(j));
                    }
                }
                list = tempList;
            }
        }
        return list;
    }

}
