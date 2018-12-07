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
		if (nums==null || nums.length<2) {
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