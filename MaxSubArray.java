public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] test1 = {1, -2, 3, 5, -1};
        int[] test2 = {1, -2, 3, -8, 5, 1};
        int[] test3 = {1, -2, 3, -2, 5, 1};
        
        System.out.println("数组1最大子数组和: " + maxSubArray(test1)); // 8
        System.out.println("数组2最大子数组和: " + maxSubArray(test2)); // 6
        System.out.println("数组3最大子数组和: " + maxSubArray(test3)); // 7
    }
}