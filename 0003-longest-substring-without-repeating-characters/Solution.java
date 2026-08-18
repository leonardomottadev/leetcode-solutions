/*

Given a string `s`, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.


Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.


Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Example 4:

Input: s = "1R1T7"
Output: 4

Example 5

Input: s = "mjvhmi"
Output: 5

Constraints:

- `0 <= s.length <= 105`
- `s` consists of English letters, digits, symbols and spaces.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public static void main(String args[]) {
        // Example 1 - Output: 3
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        // Example 2 - Output: 1
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        // Example 3 - Output: 3
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        // Example 4 - Output: 4
        System.out.println(lengthOfLongestSubstring("1R1T7"));
        // Example 5 - Output: 5
        System.out.println(lengthOfLongestSubstring("mjvhmi"));
    }

   public static int lengthOfLongestSubstring(String s) {
        int size = 0;
	    Set<Character> set = new HashSet<>();
	    for(int i = 0; i < s.length(); i++) {

	        char c = s.charAt(i);

            if(set.contains(c)) {
	            if(set.size() > size) {
	              size = set.size();
	            }

                set.clear();

                for(int j = i - 1; j >= 0; j--) {
                    set.add(s.charAt(j));
                    if(s.charAt(j) == c) {
                        break;
                    }
                }
	        }
	        set.add(c);
	    }
	    if(set.size() > size) {
		    return set.size();
	    }
	    return size;
    }

}
