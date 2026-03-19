class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
/*
map 里存的是 数值 -> 下标。
一定是“先查再放”，这样不会把同一个元素用两次。
这题最优复杂度是 O(n)，暴力解是 O(n^2)。

*/
