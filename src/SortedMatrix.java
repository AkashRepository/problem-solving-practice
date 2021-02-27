public class SortedMatrix {

    public static void main(String[] args) {
        SortedMatrix o = new SortedMatrix();

        System.out.println(o.searchMatrix(new int[][]{{-8,-6,-6,-4,-2,-1,-1,-1,0,1,2,4,6,7,7},
                        {10,10,12,13,13,14,14,16,17,17,17,17,17,18,19},
                        {22,24,26,28,29,31,32,34,34,34,34,36,38,39,39},
                        {40,40,41,43,43,44,46,47,49,49,50,52,53,55,55},
                        {56,57,59,61,62,64,65,65,66,67,68,68,69,70,71},
                        {74,75,77,77,79,79,79,80,81,83,85,87,88,89,89},
                        {91,93,94,96,97,98,99,99,100,100,102,104,105,107,107},
                        {110,112,114,114,115,117,117,118,118,120,120,121,123,124,124},
                        {127,127,129,131,133,134,134,135,137,139,139,140,142,143,144},
                        {145,146,147,149,151,151,153,155,156,156,158,160,162,162,163}}
        ,107));

        System.out.println(o.searchMatrix(new int[][]{{-10,-8},{-6,-5},{-2,-2},{-1,0},{3,4},{7,7},{8,9},{10,10},{11,11},{12,14},{15,16},{17,19},{20,21},{22,22},{25,27},{28,30},{32,32},{35,36}}
        ,16));
        System.out.println(o.searchMatrix(new int[][]
                {{1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}}
        ,3));
        System.out.println(o.searchMatrix(new int[][]{{1, 3, 5}}
                , 1
        ));
        System.out.println(o.searchMatrix(new int[][]{{1, 3}}
                , 1
        ));
        System.out.println(o.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}},
        20));
        int[] arr = new int[]{-1,10,22,40,56,74,91,110,127,145};
//        int[] arr = new int[] {-10  ,
//                -6   ,
//                -2   ,
//                -1   ,
//                3    ,
//                7    ,
//                8    ,
//                10   ,
//                11   ,
//                12   ,
//                15   ,
//                17   ,
//                20   ,
//                22   ,
//                25   ,
//                28   ,
//                32   ,
//                35   };
        System.out.println(o.binarySearch(0,arr.length-1,107 , arr));



    }

    private int binarySearch(int i, int j, int t, int[] matrix){
        int mid = (i+j)/2;
        while (i <= j) {
            mid = (i + j) / 2;

            if(mid<0)
                break;
            if(mid>=matrix.length)
                break;
            if (matrix[mid] == t) {
                f = true;
                return mid;
            } else if (matrix[mid] < t) {
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        return mid;
    }


    private int binarySearch1(int[][] matrix, int i, int j, int target, int t) {
        int mid = 0;
        while (i <= j) {
            mid = (i + j) / 2;
            if(mid<0)
                break;
            if(mid>=matrix.length)
                break;
            if (matrix[mid][t] == target) {
                f = true;
                return mid;
            } else if (matrix[mid][t] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return matrix[mid][t]<=target?i:mid;
    }

    boolean f = false;

    private int binarySearch2(int[][] matrix, int i, int j, int target, int t) {
        int mid = 0;
        while (i <= j) {
            mid = (i + j) / 2;
            if(mid<0)
                break;
            if(mid>=matrix[0].length)
                break;
            if (matrix[t][mid] == target) {
                f = true;
                return mid;
            } else if (matrix[t][mid] < target) {
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        return mid;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        f = false;
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        int i = 0, j = m-1 ;
        int mid1 = 0;
        if(m==1){
            i=0; j=n;
            mid1 = binarySearch2(matrix, i, j, target, 0);
            return f;
        } else if (n==1){
            i=0; j=m-1;
            mid1 = binarySearch1(matrix, i, j, target, 0);
            return f;
        }
        if(target >=matrix[m-1][0]){
            mid1 = m-1;
        } else {
            mid1 = binarySearch1(matrix, i, j, target, 0) - 1;
        }
        if (f)
            return true;
        int k = 0, l = n - 1;
        mid1 = Math.max(mid1, 0);
        int mid2 = binarySearch2(matrix, k, l, target, mid1);

        return f;

    }

}
