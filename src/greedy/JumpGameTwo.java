package greedy;

public class JumpGameTwo {
    public static void main(String[] args) {
        JumpGameTwo o = new JumpGameTwo();
        System.out.println(o.jump(new int[]{6,2,3,4,3,4,5,2,4}));
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int i = 0;
        int out = 0;
        while (i < n) {
            out++;
            int maxJumpTill = i;
            int nextJump = i + nums[i];//0+6
            if (nextJump >= n - 1) {
                break;
            }
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j >= n - 1) {
                    out++;
                    return out;
                }
                int nextJumpTill = j + nums[j];//1+3
                if (nextJumpTill > maxJumpTill) {
                    nextJump = j;
                    maxJumpTill = nextJumpTill;
                }
            }
            i = nextJump; // 1
        }
        return out;
    }
}
