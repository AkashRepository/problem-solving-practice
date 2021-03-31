package string;

public class GenerateNumberFromWords {

    class Solution {
        // take letters in this specific order because they have atleast one character unique than any number which has to come.
        //Example : zero have 'z', two have 'w', six have 'x'...we can have seven after five as once 'v' have already comes in the list it becomes unique.
        char[][] arr = new char[][]{{'z','e','r','o'},
                {'t','w','o'},
                {'s','i','x'},
                {'f','o','u','r'},
                {'e','i','g','h','t'},
                {'t','h','r','e','e'},
                {'f','i','v','e'},
                {'s','e','v','e','n'},
                {'o','n','e'},
                {'n','i','n','e'}};

        public String originalDigits(String s) {
            int n = s.length();
            int[] freq = new int[26];
            StringBuilder out = new StringBuilder();
            int i = 0;
            for(i=0;i<n;i++){
                char c = s.charAt(i);
                freq[c-'a']++;
            }
            int t = 0;
            int[] map = new int[]{0,2,6,4,8,3,5,7,1,9}; //mapping of index and number
            int[] outArr = new int[10];
            for(char[] c :  arr){
                int min = Integer.MAX_VALUE;
                for(char ch: c){
                    min = Math.min(min, freq[ch-'a']);
                }
                if(min>0 && min!=Integer.MAX_VALUE){
                    // if we have all the characters present in the digit so we can append it same number of times it has the minimum count of each character.
                    //example: 22 will have minimum 2 times 't', 'w' and 'o'
                    for(char ch: c){
                        freq[ch-'a'] = freq[ch-'a'] - min;
                    }
                    outArr[map[t]]=min;
                }
                t++;
            }
            for(i=0;i<10;i++){
                while(outArr[i]-->0){
                    out.append(i);
                }
            }
            return out.toString();
        }
    }
}
