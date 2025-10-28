package algo_study;

import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); //포도주 잔 수
		int[] drink=new int[n+1];
		drink[0]=0;
		for(int i=1;i<=n;i++){
			drink[i]=sc.nextInt();
		}

		//테이블 정의, 초기화
		int[] dp=new int[n+1];
		if(n>=1) dp[1]=drink[1];
		if(n>=2) dp[2]=drink[1]+drink[2];
		if(n>=3) dp[3]=Math.max(drink[1]+drink[2],Math.max(drink[1],drink[2])+drink[3]);

		//점화식 기반의 반복문
		for(int i=4;i<=n;i++){
			dp[i]=Math.max(dp[i-1],Math.max(dp[i-2],dp[i-3]+drink[i-1])+drink[i]);
		}
		System.out.println(dp[n]);
	}
}
