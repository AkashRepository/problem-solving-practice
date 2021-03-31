import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MoonAndUmbrella {

    private static int getValue(char a, char b, int x, int y){
        if(a=='C' && b == 'J'){
            return x;
        } else if (a=='J' && b =='C'){
            return y;
        }
        return 0 ;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        int t = 1;
        while(t<=tc){
            String[] arrStr = br.readLine().trim().split(" ");

            int x = Integer.parseInt(arrStr[0]);
            int y = Integer.parseInt(arrStr[1]);
            String str = arrStr[2];
            int n = str.length();
            int out = 0;
            for(int i=1;i<n;i++) {
                char a = str.charAt(i-1);
                char b = str.charAt(i);
                if(a!='?' && b!='?'){
                    out = out + getValue(a,b, x, y);
                } else if(a=='?' && b!='?' && i!=1){
                    if(str.charAt(i-2)!=b){
                        out = out + getValue(str.charAt(i-2),b, x, y);
                    }
                } else if (a=='?' && b=='?' && i!=1){
                    char start = str.charAt(i-2);
                    int temp = i+1;
                    while(temp< n && str.charAt(temp)=='?'){
                        temp++;
                    }
                    if(temp<n){
                        char end = str.charAt(temp);
                        if(start!=end){
                            out = out + getValue(start, end, x, y);;
                        }
                    }
                }
            }
            System.out.println("Case #"+t+": "+out);
            t++;
        }
        br.close();
    }
}