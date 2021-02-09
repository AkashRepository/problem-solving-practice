public class LongestConsecutiveStringKOperations {

    public int characterReplacement(String s, int k) {
        if(s.length()==0)
            return 0;
        if(s.length()==1)
            return 1;
        // Count the number of A characters between a (starting index) to b (current index)
        int[] arr = new int[26];
        int a=0, b=1;
        arr[s.charAt(0)-'A']++;
        int max = 0;
        int maxTillNow = 1; // as starting 0th index is the longest repeating string
        for(;b<s.length();b++){
            int idx = s.charAt(b)-'A';
            arr[idx]++;
            maxTillNow = Math.max(arr[idx], maxTillNow);
            if((b-a+1) > maxTillNow + k){ // check is the repeating string is greater than which we can get by maximum occurances of a character + k operations
                arr[s.charAt(a)-'A']--;
                a++;
            } else {
                max = Math.max(max, b-a+1);
            }
        }
        return max;

    }
}
