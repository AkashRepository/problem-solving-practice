class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0)
            return 0;
        HashMap<Character, Integer> m = new HashMap<>();
        int start = 0, out = 1;
        for(int i=0;i<n;i++){
            if(m.containsKey(s.charAt(i)) && m.get(s.charAt(i)) >= start){
                start = m.get(s.charAt(i)) + 1;
                m.put(s.charAt(i), i);
            } else {
                m.put(s.charAt(i), i);
            }
            out = Math.max(out, i - start + 1);
        }
        return out;
    }
}
