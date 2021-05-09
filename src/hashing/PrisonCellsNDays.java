package hashing;

import java.util.Arrays;
import java.util.HashSet;

public class PrisonCellsNDays {

    //https://leetcode.com/problems/prison-cells-after-n-days/

    public int[] prisonAfterNDays(int[] cells, int N) {
        HashSet<String> hs = new HashSet<>();
        int c = 1;
        boolean f = false;
        while (c <= N) {
            int[] temp = new int[cells.length];
            // System.arraycopy(cells, 0, temp, 0, cells.length);
            for (int i = 1; i < 7; i++) {
                temp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            // System.arraycopy(temp, 0, cells, 0, cells.length);
            // cells[0] = cells[7] = 0;
            String str = Arrays.toString(temp);
            if (hs.contains(str)) {
                f = true;
                break;
            } else {
                hs.add(str);
            }
            c++;
            cells = temp;
        }
        if (c <= N) {
            int rem = N % (c - 1);
            while (rem-- > 0) {
                int[] temp = new int[cells.length];
                for (int i = 1; i < 7; i++) {
                    temp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
                }
                cells = temp;
            }
        }

//        cells[0] = cells[7] = 0;
        return cells;
    }

    public static void main(String[] args) {
        PrisonCellsNDays o = new PrisonCellsNDays();
        System.out.println(Arrays.toString(o.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1},
                7)));
    }
}
