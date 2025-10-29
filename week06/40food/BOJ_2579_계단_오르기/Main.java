package algo_study;

import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); //계단 수
		int[] stairs=new int[n+1];
		stairs[0]=0;
		for(int i=1;i<=n;i++){
			stairs[i]=sc.nextInt();
		}

		// 테이블 정의, 초기값
		int[] dp=new int[n+1];

		if(n>=1) dp[1]=stairs[1];
		if(n>=2) dp[2]=stairs[1]+stairs[2];
		if(n>=3) dp[3]=Math.max(stairs[1],stairs[2])+stairs[3];

		// 점화식 기반의 반복문
		// n이 3 이하면 처음부터 조건 안 맞아서 동작 안 함
		for(int i=4;i<=n;i++){
			dp[i]=Math.max(dp[i-2],dp[i-3]+stairs[i-1])+stairs[i];
		}
		System.out.println(dp[n]);
	}
}
