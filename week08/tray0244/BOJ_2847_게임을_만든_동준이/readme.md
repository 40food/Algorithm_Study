## 양식

---

### 푼 문제: 게임을 만든 동준이

- https://www.acmicpc.net/problem/2847

---

### 해설

- 게임에는 총 N개의 레벨이 있고, 각 레벨을 클리어하면 점수를 준다.
- 플레이어 점수는 총 점수의 합, 점수를 통해서 순위를 매긴다.
- 레벨을 난이도 순으로 배치, 하지만 실수로 쉬운 레벨이 어려운 레벨보다 점수가 높음
- 특정 레벨의 점수를 감소해야한다. 각 레벨을 클리어 할 때 주는 점수가 증가하게 만든다.
- 각 레벨을 클리어 할 때 얻는 점수가 주어졌을 때, 몇 번 감소시키면 될까
- 점수는 항상 양수, 1 감소가 한번.
- 정답이 여러가지면 점수를 내리는것을 최소한으로 하는 방법을 찾아야 한다.

### 코드

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] arr;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        count = 0;
        for(int i = N - 1; i > 0; i--){
            if(arr[i] <= arr[i - 1]){
                int diff = arr[i - 1] - (arr[i] - 1);
                count += diff;
                arr[i - 1] = arr[i] - 1;
            }
        }
        
        System.out.println(count);
    }
}
```

---

### 풀이

- 이 문제는 해당 레벨의 난이도를 낮추는 것밖에 못한다.
- 앞에서부터 시작을 했을 때, 한번 낮춘 값을 또 낮춰야 하는 상황이 오게된다.
- 5 → 4 → 5 (1레벨의 5는 2레벨의 4보다 낮아야 한다. 하지만 현재 진행 레벨은 2이므로 레벨 1에 도달할 수가 없다.)
- 따라서 뒤에서 진행하는 방법이 정답이라 볼 수 있다.
- 3레벨 → 2레벨 → 1레벨로 진행하는 방향이 옳은 방향이다.
- 그래서 `arr[i]`와 `arr[i - 1]`이 존재하는데 레벨의 난이도는 그 후의 레벨보다 난이도가 한 단계 낮아야 하기 때문에 `-1` 이 필요
- 결국에는 레벨은 아래 레벨보다 1 높기에 `arr[i - 1] = arr[i] - 1` 로 할당을 해주면 된다.

---