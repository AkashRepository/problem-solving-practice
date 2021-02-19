public class ShortestCompletingWord {

    public static void main(String[] args) {
        ShortestCompletingWord o = new ShortestCompletingWord();
        System.out.println(o.shortestCompletingWord("1s3 PSt",
                new String[]{"step", "steps", "stripe", "stepple"}));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int out = Integer.MAX_VALUE;
        String output = null;
        int[] arr = count(licensePlate);
        for (String w : words) {
            int[] arr2 = count(w);
            boolean f = areAllZero(arr.clone(), arr2);
            if (f && out > w.length()) {
                out = w.length();
                output = w;
            }
        }
        return output;

    }

    private int[] count(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c))
                    arr[c - 'A']++;
                else
                    arr[c - 'a']++;
            }

        }
        return arr;
    }

    private boolean areAllZero(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (b[i] > 0) {
                a[i] = a[i] - b[i];
            }
            if (a[i] > 0)
                return false;
        }
        return true;
    }
}
