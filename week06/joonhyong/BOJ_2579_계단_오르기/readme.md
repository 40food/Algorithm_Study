### 백준 2579번 계단 오르기

#### - 유형 : 다이나믹 프로그래밍

#### - 입력예제

```
6
10
20
15
25
10
20
```

#### - 유도코드

- stair 배열에는 계단 마다 점수가 기입되어 있음
- dp 배열에는 각 계단에 도착했을때, 최대 점수를 기록함

  - 다음 계단에서 참고할 때 사용
  - 각 계단을 밟았을 때의 최댓값은 정해져 있음

- dp[i]에서 1,2는 한가지의 경우의 수 밖에 없음
  - dp[1]은 점수가 처음으로 기입되므로 이전에 고려할 사항이 없음
  - dp[2]는 계단 1을 밟은 경우가 밟지 않은 경우 보다 항상 더 큼
- dp[3]은 dp[1]에서 오는 경우와, dp[1]을 밟지 않고 dp[2]에서 오는 경우 중 큰 것을 선택 (Math.max())

- i번째 계단에 도달하는 경우는 아래의 두가지 상황에서 점수가 더 높을 때임

  1. i-1을 밟고 도달한 경우 -> dp[i] = dp[i-1] + stair[i]
  2. i-1을 밟지 않고 도달한 경우 -> dp[i] = dp[i-3] + stair[i-1] + stair[i]

- dp배열은 최댓값들로 채워져 나가므로, dp[i]는 i미만의 인덱스에 해당하는 요소들만 참고하면됨

#### - 알게된 점

- 메모이제이션 방식으로 배열의 반복문을 사용할 때는 for문으로 함
- 반복문 진입 전, dp[상수] 부분을 작성할 때도 경우에 따라 나누는 상황이 발생할 수 있음
- 점화식은 추상적인 부분에서 최대한 규칙을 찾고, 형태가 고정된 부분을 구현

### 코드 구현

#### - 언어 : JavaScript

#### - 메모리 : 9348 KB

#### - 시간 : 92 ms

```js
const fs = require("fs");
const file = process.platform === "linux" ? "/dev/stdin" : "../exam.txt";
const input = fs.readFileSync(file).toString().trim().split("\n");

const n = parseInt(input[0]);
const stair = input.map((x) => Number(x));
stair[0] = 0;
const dp = Array(n + 1).fill(0);

// 1,2 번째 계단들의 최댓값은 정해져 있음
dp[0] = 0;
dp[1] = stair[1];
dp[2] = stair[2] + dp[1];
// 3번째 계단은 아래 두가지 경우 중 점수가 더 큰 경우
// 1. 시작점 + stair[2] + stair[3]
// 2. 시작점 + stair[1] + stair[3]
dp[3] = Math.max(dp[1] + stair[3], dp[0] + stair[2] + stair[3]);

// 따라서, 점화식은 아래와 같음
// dp[i] = Math.max( dp[i-2] + stair[i], dp[i-3] + stair[i-1] + stair[i] )
for (let i = 4; i <= n; i++) {
  dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
}

console.log(dp[n]);
```
