import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        // 第一行读取数组长度 n。
        Integer nObj = fs.nextInt();
        if (nObj == null) {
            return;
        }
        int n = nObj;

        // 第二行读取数组元素。
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = fs.nextInt();
        }

        moveZeroes(nums);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                out.append(' ');
            }
            out.append(nums[i]);
        }
        System.out.print(out.toString());
    }

    private static void moveZeroes(int[] nums) {
        // slow 指向下一个应该放非零元素的位置。
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                // 当 fast 指向非零元素时，把它交换到 slow 的位置。
                if (slow != fast) {
                    int tmp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = tmp;
                }
                slow++;
            }
        }
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        Integer nextInt() throws IOException {
            int c;
            do {
                c = read();
                if (c == -1) {
                    return null;
                }
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
