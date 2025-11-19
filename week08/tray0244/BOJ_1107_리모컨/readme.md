### 푼 문제: 리모컨

- https://www.acmicpc.net/problem/1107

---

### 해설

- 기본 채널은 100채널
- 가고싶은 채널은 `N`
- 고장난 리모컨 버튼 갯수는 `M`
- 사용할 수 있는건 고장나지 않은 버튼과 `+`, `-` 버튼이다.
- 고장난 버튼을 제외하고 가고싶은 채널로 가도록 최소 몇번을 눌러야 하는지 구해야한다.

### 코드

---

```java
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
```

### 풀이

- 이 문제의 지문에서 채널은 무한대 만큼 존재하고 최소 몇번을 눌러야 하는지를 구해야한다는 점에서
- 브루트 포스 문제라는걸 알 수가 있다.
- 채널은 최대 `50`만 채널이 주어진다. 그 채널을 완전 탐색으로 진행해야 하기 때문에 반복할 영역은 `0`에서 `60`만 정도로 해야한다.
- 이 완전탐색은 전부 리모컨의 `+`, `-` 이다.
- 문제 중에 예외가 한개 존재한다. 기본 채널이 `100`이라는 점이다. 만약 원하는 채널이 `100`과 가까이 있을 때 경우가 있기 때문에 이 경우는 완전 탐색을 하면서 최소값을 갱신하면서 구해야하는 방식이서 첫 변수로 잡아주면 된다. 최소값 변수는 `ans`로 잡아줬다.
- 올라간 채널을 `broken_remote`함수로 검사를 한다. 이 채널의 정수를 문자열로 변환을 하여 하나씩 꺼내보면서 다시 정수로 바꾸고 그것이 고장난 버튼인지 아닌지를 검사하고 고장난게 포함되면 0을 아니면 처음 들어간 정수의 길이를 출력한다.
- 이 길이는 현재 원하는 채널에 가장 가깝다고 여기는 길이다. 그래서 이 길이로 최소 버튼을 눌렀던 횟수를 구한다. 길이를 구했던 인덱스와 원하는 채널의 값을 빼고 길이와 더하면된다. 그게 바로 `press` 변수가 된다.
- `press` 변수를 구하면 `ans`와 비교를 해서 최소값 갱신을 한다. 그렇게 `60`만까지 전부 탐색을 하고나면 정답이 나온다.

---