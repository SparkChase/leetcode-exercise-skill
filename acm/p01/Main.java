import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        // 第一行读取 n 和 target。
        Integer nObj = fs.nextInt();
        if (nObj == null) {
            return;
        }
        int n = nObj;
        int target = fs.nextInt();

        // 第二行读取数组。
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = fs.nextInt();
        }

        int[] ans = twoSum(nums, target);
        System.out.print(ans[0] + " " + ans[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        // key 存数组值，value 存下标。
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];

            // 如果前面已经出现过 need，说明找到答案。
            if (map.containsKey(need)) {
                return new int[] {map.get(need), i};
            }

            // 把当前值和它的下标记下来，供后续位置使用。
            map.put(nums[i], i);
        }

        // 题目保证有解，这里只是兜底。
        return new int[] {-1, -1};
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
