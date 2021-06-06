public class IsValid {

    public static void main(String[] args) {
        IsValid o = new IsValid();
        System.out.println(o.isNumber("46.e3"));
    }

    public boolean isNumber(String s) {
        int i = 0;
        int n = s.length();
        if(n==0)
            return true;

        if(i<n && s.charAt(i)=='-' || s.charAt(i)=='+'){
            i++;
        }
        if(i==n)
            return false;
        while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
            i++;
        }
        if(i==n)
            return true;

        if(i<n && !(s.charAt(i)=='.' || s.charAt(i)=='e' || s.charAt(i)=='E')){
            return false;
        }
        if( s.charAt(i)=='e' || s.charAt(i)=='E'){
            if(i==0)
                return false;
            i++;
            if(i==n)
                return false;
            if(s.charAt(i)=='+' || s.charAt(i)=='-' )
                i++;
            if(i==n)
                return false;
            while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
                i++;
            }
            if(i==n)
                return true;

//            if(s.charAt(i)!='.'){
//                return false;
//            }
//
//            i++;
//            if(i==n)
//                return false;
//            while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
//                i++;
//            }
//            if(i==n)
//                return true;

            return false;
        } else if(s.charAt(i)=='.') {
            i++;
//            if(i==n)
//                return false;
            if(i<n && (s.charAt(i)=='e' || s.charAt(i)=='E'))
                return false;
            while(i<n && (s.charAt(i)!='e' && s.charAt(i)!='E') &&  s.charAt(i)>='0' && s.charAt(i)<='9'){
                i++;
            }
            if(i==n)
                return true;
            if(s.charAt(i)!='e' && s.charAt(i)!='E'){
                return false;
            }
            i++;
            if(i==n)
                return false;

            if(s.charAt(i)=='+' || s.charAt(i)=='-' )
                i++;
            if(i==n)
                return false;
            while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
                i++;
            }
            if(i==n)
                return true;

            return false;
        }

        return false;

    }
}
