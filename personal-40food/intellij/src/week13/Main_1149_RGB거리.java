package week13;

import java.util.Scanner;

public class Main_1149_RGB거리 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] houses=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                houses[i][j]=sc.nextInt();
            }
        }
        int[][] dp=new int[n][3];
        dp[0][0]=houses[0][0];
        dp[0][1]=houses[0][1];
        dp[0][2]=houses[0][2];

        for(int i=1;i<n;i++){
            dp[i][0]=houses[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=houses[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=houses[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }

        System.out.println(Math.min(dp[n-1][2],Math.min(dp[n-1][0],dp[n-1][1])));
    }
}
