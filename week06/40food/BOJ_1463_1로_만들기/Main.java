package algo_study;

import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] dp=new int[n+1];
		dp[1]=0;

		//1은 필요 없기 때문에 2부터 시작
		for(int i=2;i<=n;i++){
			//1을 빼는 경우(최대값)
			dp[i]=dp[i-1]+1;
			//2로 나누는 경우
			//1을 빼는 경우와 비교하여 더 작은 걸 선택
			if(i%2==0) dp[i]=Math.min(dp[i],dp[i/2]+1);
			//3으로 나누는 경우
			//1빼는 경우와 비교하여 더 작은 걸 선택
			if(i%3==0) dp[i]=Math.min(dp[i],dp[i/3]+1);
		}
		System.out.println(dp[n]);
	}
}
