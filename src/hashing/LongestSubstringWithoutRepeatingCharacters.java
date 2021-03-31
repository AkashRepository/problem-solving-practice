package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String A) {
        int out = 0;
        Map<Character, Integer> m = new HashMap<>();
        int i = 0;
        int start = 0;
        for(char c: A.toCharArray()){
            Integer value = m.get(c);
            if(value!=null && value>=start){
                start = value+1;
            }
            m.put(c, i);
            out = Math.max(out, i-start+1);
            i++;
        }
        return out;
    }
}
