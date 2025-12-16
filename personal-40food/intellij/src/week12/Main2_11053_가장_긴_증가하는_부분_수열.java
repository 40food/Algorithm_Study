package week12;

import java.util.Scanner;

public class Main2_11053_가장_긴_증가하는_부분_수열 {
    /*
     * 수열은 그대로 냅둬야 함
     * 그럼 그냥 수열을 돌면서 카운트 증가하면?
     * 될리가 없겟구나 가장 개수가 커지는 걸 골라야하니까
     * 결국 DP 문제임
     *
     * DP를 푸는 방법은?
     * 1. DP 정의
     * 2. DP 초기값
     * 3. 점화식
     *
     * 1. dp[i]=i에서 끝나는 가장 긴 증가하는 부분 수열의 길이
     * 2. dp[i]=1
     * 3. j<i일 때 dp[i]=max(dp[i], dp[j]+1)
     * */

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        int[] dp=new int[n];
        for(int i=0;i<n;i++){ //모든 요소에서 시작해보도록 설정
            dp[i]=1; //초기값
            for(int j=0;j<n;j++){
                if(nums[j]<nums[i]){ //같거나 작을 땐 실행할 필요가 없음
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
