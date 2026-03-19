import java.util.*;

class Solution {
    /*
     * 49. 字母异位词分组
     * 难度: 中等
     *
     * 题意概括:
     * 给你一个字符串数组 strs，请把由相同字母重新排列得到的字符串放到同一组中。
     * 返回所有分组，结果的顺序不要求固定。
     *
     * 示例 1:
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
     *
     * 示例 2:
     * 输入: [""]
     * 输出: [[""]]
     *
     * 示例 3:
     * 输入: ["a"]
     * 输出: [["a"]]
     *
     * 提示:
     * 1 <= strs.length <= 10^4
     * 0 <= strs[i].length <= 100
     * strs[i] 仅由小写英文字母组成
     *
     * 思考方向:
     * 1. 两个字符串怎样判断属于同一组
     * 2. 怎样为每一组设计一个统一的 key
     * 3. HashMap 的 value 为什么适合用 List<String>
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // TODO: 先自己写一版，写完后我帮你对照优化
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        for (List<String> group : map.values()) {
            res.add(group);
        }
        return res;

        //最后一步可以：
        // return new ArrayList<>(map.values());
        /*
有两个小优化点你可以顺手记一下：

res 其实可以省掉，最后直接 return new ArrayList<>(map.values());
if (!map.containsKey(key)) ... 以后可以慢慢熟悉成 map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);，写法会更紧凑
        */
    }
    
}
