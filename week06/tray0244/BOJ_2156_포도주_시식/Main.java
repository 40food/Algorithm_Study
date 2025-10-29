import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(n == 1){
            System.out.println(arr[1]);
            return;
        }else if(n == 2){
            System.out.println(arr[1] + arr[2]);
            return;
        }
        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for(int i = 3; i <= n; i++){
            // 현재 포도주를 마시지 않는 경우, 한 칸 전 포도주를 마시는 경우, 두 칸 전 포도주를 마시는 경우 중 최댓값
            dp[i] = Math.max(dp[i - 1], Math.max(
                    dp[i - 2] + arr[i], dp[i - 3] + arr[i] + arr[i - 1]
            ));
        }
        System.out.println(dp[n]);
    }
}