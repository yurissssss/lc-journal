class Solution {
    public int rob(int[] nums) {
        int[] dq = new int[nums.length];
        dq[0] = nums[0];

        if (nums.length > 1) {
            dq[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++) {
                dq[i] = Math.max(dq[i-1], dq[i-2] + nums[i]);
            }
        }
        return dq[nums.length - 1];
    }
}