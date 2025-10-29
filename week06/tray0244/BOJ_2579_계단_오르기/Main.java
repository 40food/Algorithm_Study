import java.util.*;

public class Main
{
    static int[] dp;
    static int[] stair;
    static int N;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        stair = new int[N + 1];
        dp = new int[N + 1];

        for(int i = 1; i <= N; i++)
        {
            stair[i] = in.nextInt();
        }
        if(N == 1)
        {
            System.out.println(stair[1]);
            return;
        }
        dp[1] = stair[1];
        if(N >= 2)
        {
            dp[2] = stair[1] + stair[2];
        }

        for(int i = 3; i <= N; i++)
        {
            dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
        }
        System.out.println(dp[N]);
    }
}