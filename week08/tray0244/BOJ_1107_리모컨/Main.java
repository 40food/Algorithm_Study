import java.util.*;
import java.io.*;

class Main {
    static boolean[] remote;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());

        // 리모컨 버튼 초기화
        remote = new boolean[10];

        // M이 0일때의 예외처리
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int k = Integer.parseInt(st.nextToken());
                remote[k] = true;
            }
        }

        // 리모컨의 +, -를 최소한 안쓰고 빠르게 결과를 얻을 수 있는 경우
        // ex) 채널 = 100,
        int ans = Math.abs(N - 100);

        // 채널의 모든 경우를 구해야하기 때문에 채널이 50만이라면
        // 60만까지의 경우를 탐색해서 최선의 i를 구해야 한다.
        for (int i = 0; i <= 600000; i++) {
            // 현재 부러진 버튼의 영향을 받지 않는 채널
            int len = broken_remote(i);

            // broken_remote에서 부러진 버튼의 영향을 받은 i는 0으로 리턴을 한다. 그것의 예외처리
            if (len > 0) {
                // len이라는 수는 N의 근처까지 도달한 것이므로
                // len의 값인 i와 도달한 채널인 N을 빼줘야 한다.
                // 빼준 값과 len을 더하면 채널까지 도달한 총 숫자다.
                int press = len + Math.abs(N - i);

                // 최소 값에 만족을 하면 갱신
                if (press < ans) {
                    ans = press;
                }
            }
        }
        System.out.println(ans);
    }

    static int broken_remote(int n) {
        // n이 0이면 한자리 수 이기에 1을 리턴한다.
        // 만약 0이 고장난 버튼이면 0을 리턴한다.
        if (n == 0) {
            if (remote[0]) return 0;
            else return 1;
        }

        // 현재 채널을 하나씩 뜯어야 하기 때문에 String으로 변환
        // 하나씩 보면서 고장난 버튼인지 검사
        // 고장나면 0, 아니면 문자열의 길이만큼 정수로 리턴
        String str = String.valueOf(n);
        int len = str.length();

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            int num = c - '0';

            if (remote[num]) {
                return 0;
            }
        }
        return len;
    }
}