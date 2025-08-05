public class DeleteandEarn {

    public int deleteAndEarn(int[] nums){
        int max = 0;

        for(int num:nums)
        {
            max = Math.max(max,num);
        }

        int[] arr = new int[max+1];

        for(int num: nums)
        {
            arr[num] += num;
        }

        int[] dp = new int[max+1];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);

        for(int i=2;i<=max;i++)
        {
            dp[i] = Math.max(dp[i-1], arr[i]+dp[i-2]);
        }
        return dp[max];
    }
}
