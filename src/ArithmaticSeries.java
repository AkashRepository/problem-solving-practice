public class ArithmaticSeries {

    public static void main(String[] args) {
        ArithmaticSeries o = new ArithmaticSeries();
        System.out.println(o.numberOfArithmeticSlices(new int[]{1, 2, 3, 8, 9, 10}));
    }

    public int numberOfArithmeticSlices(int[] A) {
        int[] diff = new int[A.length];

        for (int i = 1; i < A.length; i++) {
            diff[i] = A[i] - A[i - 1];
        }
        int c = 0, out = 0;
        for (int i = 2; i < A.length; i++) {
            if (diff[i] == diff[i - 1]) {
                c++;
            } else {
                out = out + (c * (c + 1) / 2);
                c = 0;
            }
        }
        if (c != 0) {
            out = out + (c * (c + 1) / 2);
        }
        return out;
    }
}
