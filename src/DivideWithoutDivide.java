public class DivideWithoutDivide {

    private int sub(int x, int y){

        while(y!=0){
            int b = ~x & y;
            x = x ^ y;
            y = b << 1;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(new DivideWithoutDivide().divide(10,3));
    }

    public int divide(int dividend, int divisor) {
        int i = 0;
        while(dividend > divisor){
            dividend = sub(dividend, divisor);
            i++;
        }
        return i;
    }
}
