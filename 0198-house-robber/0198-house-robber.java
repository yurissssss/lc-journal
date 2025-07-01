class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        // 집이 1채만 잇는 경우 -> 첫 번째 집만 가능
        dp[0] = nums[0];

        // 집이 2채 이상인 경우
        if (nums.length > 1) {
            // 1, 2번 집 중 더 많이 가진 집 하나만 가능
            dp[1] = Math.max(nums[0], nums[1]);

            // 'i-1' vs '(i-2) + i'
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
        }
        return dp[nums.length-1];
    }
}