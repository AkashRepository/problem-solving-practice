package dynamicprogramming;

public class DecodeWays {

    public int numDecodings(String s) {
        int n = s.length();
        int[] arr = new int[n];

        if(n<2){
            return s.charAt(0)!='0'?1:0;
        }

        //base case for 0th and 1st index
        if(s.charAt(0)=='0'){
            arr[0]=0;
            arr[1]=0;
        } else if (s.charAt(1)=='0'){
            arr[1] = (s.charAt(0)=='1' || s.charAt(0)=='2')?1:0;
        } else {
            arr[0]=1;
            arr[1]=1;
            int current = s.charAt(1)-'0';
            int prev = s.charAt(0)-'0';
            prev = prev*10 + current;
            if(prev>=10 && prev<=26){
                arr[1] = arr[1] + 1;
            }
        }

        for(int i=2;i<n;i++){
            int current = s.charAt(i)-'0';
            if(current>0){// it is between 1 to 9
                arr[i] = arr[i] + arr[i-1];
            }

            int prev = s.charAt(i-1)-'0';
            prev = prev*10 + current;
            if(prev>=10 && prev<=26){
                arr[i] = arr[i] + arr[i-2];
            }
            // cases like "80" in this case arr[i] = 0, so do not copy previous
        }
        return arr[n-1];
    }
}
