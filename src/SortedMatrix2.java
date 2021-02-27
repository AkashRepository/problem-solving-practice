public class SortedMatrix2 {

    public static void main(String[] args) {
        SortedMatrix2 o = new SortedMatrix2();
        System.out.println(o.searchMatrix(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}
                , 6));
    }


    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        if (m == 1 && n == 1)
            return matrix[0][0] == target;

        int i = 0, j = n - 1;

        while (i < m && j >= 0) {
            if(matrix[i][j]==target)
                return true;
            if(matrix[i][j]>target){
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

}
