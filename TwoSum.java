/** 1. Two Sum (Easy)
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

(Example)
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class TwoSum {
	public int target;
	public int[] nums;

	public TwoSum(int[] n, int t) {
		target = t;
		nums = n;
	}

	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return new int[]{0,0};
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] {map.get(complement), i};
			}
			map.put(nums[i], i);
		}
		return new int[]{ 0,0 };
	}

	public static void main(String[] args) {
		int[] nums = new int[]{ 2,7,11,15 };
		int target = 9;

		TwoSum solution = new TwoSum(nums, target);
		int[] res = solution.twoSum(nums, target);
		System.out.println(Arrays.toString(res));
	}
}

// One-pass Hash Table
    // while we iterate & insert elements into the table,
    // we also look back to check if current element's complement 
    // already exists in the table. 
    // If so, we have found a solution and return it immediately. 
// Time: O(n)
// Space: O(n)