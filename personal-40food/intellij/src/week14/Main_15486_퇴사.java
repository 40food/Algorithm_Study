package week14;

import java.util.Scanner;

public class Main_15486_퇴사 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] coun=new int[n+1][2];
        for(int i=0;i<n;i++){
            coun[i+1][0]=sc.nextInt();
            coun[i+1][1]=sc.nextInt();
        }

        int[] dp=new int[n+1];
        if(coun[n][0]==1) dp[n]=coun[n][1];
        else dp[n]=0;

        for(int i=n-1;i>0;i--){
            if(i+coun[i][0]-1>n) {
                dp[i]=dp[i+1];
                continue;
            }else if(i+coun[i][0]-1==n){
                dp[i]=Math.max(coun[i][1],dp[i+1]);
                continue;
            }
            dp[i]=Math.max(coun[i][1]+dp[i+coun[i][0]],dp[i+1]);
        }
        System.out.println(dp[1]);
    }
}
