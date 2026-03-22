import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        // 输入格式：
        // 第一行输入 n，表示字符串数量。
        // 接下来输入 n 个字符串，按空白分隔即可。
        FastScanner fs = new FastScanner(System.in);
        Integer nObj = fs.nextInt();
        if (nObj == null) {
            return;
        }
        int n = nObj;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = fs.next();
        }

        // 按字母异位词分组后输出。
        List<List<String>> groups = groupAnagrams(strs);
        StringBuilder out = new StringBuilder();
        out.append(groups.size()).append('\n');
        for (List<String> group : groups) {
            out.append(group.size());
            for (String s : group) {
                out.append(' ').append(s);
            }
            out.append('\n');
        }
        System.out.print(out.toString());
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        // 用排序后的字符串作为分组 key。
        // 例如 eat 和 tea 排序后都变成 aet。
        Map<String, List<String>> map = new TreeMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        // 为了让输出更稳定，组内再做一次字典序排序。
        List<List<String>> res = new ArrayList<>();
        for (List<String> group : map.values()) {
            Collections.sort(group);
            res.add(group);
        }
        return res;
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

        String next() throws IOException {
            int c;
            do {
                c = read();
                if (c == -1) {
                    return null;
                }
            } while (c <= ' ');

            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }
    }
}
