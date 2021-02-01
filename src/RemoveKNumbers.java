import java.util.Stack;

public class RemoveKNumbers {

    public String removeKdigits(String num, int k) {
        Stack<Integer> s = new Stack<>();
        int[] arr = new int[num.length()];
        if (k == 1 && arr.length == 1)
            return "0";

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt("" + num.charAt(i));
        }
        boolean f = true;
        int out = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];

            while (!s.isEmpty() && f && s.peek() > min) {
                s.pop();
                out++;
                if (out == k)
                    f = false;
            }
            s.push(min);

        }
        String str = "";
        while (!s.isEmpty()) {
            if (out == k)
                str = s.pop() + str;
            else {
                s.pop();
                out++;
            }

        }
        f = true;
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        // if(i!=str.length())
        str = str.substring(i, str.length());
        return str.equals("") ? "0" : str;
    }

    public static void main(String[] args) {
        RemoveKNumbers o = new RemoveKNumbers();
        System.out.println(o.removeKdigits("1234567890",
                9));
    }
}
