### [2579 - 계단 오르기](https://www.acmicpc.net/problem/2579)

- 메모리: `9356KB`
- 시간: `84ms`

#### 코드

```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

// 입력받은 첫 번째 줄은 계단의 개수
const N = +input[0];

// 계단이 1개뿐인 경우 첫 계단 점수 그대로 출력
if (N === 1) return console.log(input[1]);

// 계단이 2개뿐인 경우 두 계단 모두 밟는 것이 최대 점수
if (N === 2) return console.log(Number(input[1]) + Number(input[2]));

// 계단이 3개인 경우 (1+3) 또는 (2+3) 중 더 큰 점수를 선택
// 세 계단 연속(1+2+3)은 불가능하므로 제외됨
if (N === 3)
  return console.log(
    Math.max(Number(input[1]), Number(input[2])) + Number(input[3])
  );

// dp 배열 초기화
const dp = Array.from({ length: N }, () => 0);

// 초기값 설정
dp[1] = Number(input[1]); // 첫 번째 계단 점수
dp[2] = Number(input[1]) + Number(input[2]); // 1, 2번 계단 밟기 (두 계단 모두 밟는 게 최댓값)
dp[3] = Math.max(Number(input[1]), Number(input[2])) + Number(input[3]);
// (1+3) 또는 (2+3) 중 큰 값 선택 (세 계단 연속 방지)

// 점화식 적용
for (let i = 4; i <= N; i++) {
  // i번째 계단을 밟을 때 가능한 두 가지 경우
  // 1. (i-2) -> i  : 바로 전 계단을 건너뛰고 오는 경우
  // 2. (i-3) -> (i-1) -> i : 두 계단 연속 밟는 경우 (단, i-2는 밟지 않음)
  dp[i] =
    Math.max(
      dp[i - 2], // (i-2)번째에서 한 칸 건너뛰고 i로 오는 경우
      dp[i - 3] + Number(input[i - 1]) // (i-3) -> (i-1) -> i 형태로 오는 경우
    ) + Number(input[i]); // 마지막으로 i번째 계단 점수 더하기
}

// 마지막 계단을 밟은 상태의 점수 출력
console.log(dp[N]);
```
