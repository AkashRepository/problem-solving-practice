package greedy;

import java.util.HashMap;
import java.util.Map;

public class MinimumDeletionsCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        int n = s.length();
        int[] frequencyMap = new int[26]; // frequency map to keep track of number of occurrences
        int[] invertedMap = new int[n+1]; // index array to keep track of frequency count,
                                        // Eg. if any 2 characters occur 3 then invertedMap[3]=2
        for(char c: s.toCharArray()){
            frequencyMap[c-'a']++;
        }
        for(Integer value: frequencyMap){
            invertedMap[value]++;
        }
        // We have to use only 1 index for a value at a time.
        // If invertedMap[3] = 4, means 4 characters have 3 freq, so only one will be considered and other 3 (4-1)
        // will be leftOut to be settled in place where invertedMap[i]==0, or no one is having that index
        // all the remaining leftOut if they don't get any index by the end will be considered to be deleted.

        // The index which we have used means, same number of characters are placed at the position.
        // Eg. invertedMap[5] is used by character 'a',invertedMap[4] by 'b'. So string will be like "aaaaabbbb"
        // so 'used' variable is used to keep track of number of characters added in new string.
        // output will be length of input string  - length of new string (number of characters missing or deleted)
        int leftOut = 0, used = 0;
        for(int i=n;i>0;i--){
            if(invertedMap[i]==1){
                used += i;
            } else if(invertedMap[i]>1){
                leftOut = leftOut + invertedMap[i] - 1;
                used +=i;
            } else if(invertedMap[i]==0 && leftOut>0){
                invertedMap[i] = 1;
                leftOut--;
                used += i;
            }
        }
        return n - used;
    }
}
