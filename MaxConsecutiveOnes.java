public class MaxConsecutiveOnes {

	public static int findMaxConsecutiveOnes(int[] nums) {
		int count = 0, max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1)
				count++;
			else {
				if (count > max)
					max = count;
				count = 0;
			}
		}
		return (count > max) ? count : max;
	}

	public static void main(String[] args) {
		int arr[] = { 1,1, 0, 0,1,1,1,1 };
		System.out.println(findMaxConsecutiveOnes(arr));
	}
}
