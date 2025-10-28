package algo_study;

import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();

		for(int tc=0;tc<t;tc++){
			int n=sc.nextInt(); //도달할 수

			//테이블 정의, 초기화
			int[] dp=new int[n+1];
			if(n>=1) dp[1]=1;
			if(n>=2) dp[2]=2;
			if(n>=3) dp[3]=4;

			//점화식 기반의 반복문
			for(int i=4;i<=n;i++){
				dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
			}
			System.out.println(dp[n]);
		}
	}
}
