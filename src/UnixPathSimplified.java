import java.util.Stack;

public class UnixPathSimplified {

    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        boolean dot = false;

        String[] words = path.split("/");
        for (String w : words){
            if(w.isEmpty() || w.equals(".")){
//                continue;
            } else if(w.equals("..")){
                s.pop();
            } else {
                s.push(w);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.insert(0, s.pop());
            sb.insert(0, "/");
        }
        return sb.toString().equals("")?"/":sb.toString();
    }

    public static void main(String[] args) {
        UnixPathSimplified o = new UnixPathSimplified();

        System.out.println(o.simplifyPath("///"));
        System.out.println(o.simplifyPath("/hero/"));
        System.out.println(o.simplifyPath("/home//foo/"));
        System.out.println(o.simplifyPath("/a/./b/../../c/"));
        System.out.println(o.simplifyPath("/..."));
    }
}
