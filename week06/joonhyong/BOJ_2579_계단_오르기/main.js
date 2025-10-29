// 백준 2579번 계단 오르기
// 분류 : 다이나믹 프로그래밍
/*입력예제
6
10
20
15
25
10
20
*/
/*유도코드
- stair 배열에는 계단 마다 점수가 기입되어 있음
- dp 배열에는 각 계단에 도착했을때, 최대 점수를 기록함 
  - 다음 계단에서 참고할 때 사용
  - 각 계단을 밟았을 때의 최댓값은 정해져 있음

- dp[i]에서 1,2,3은 한가지 경우의 수 밖에 없음 -> 반복문은 i=4 부터 시작
- i번째 계단에 도달하는 경우의 수는 2가지임
  1. i-1을 밟고 도달한 경우       -> dp[i] = dp[i-1] + stair[i]
  2. i-1을 밟지 않고 도달한 경우  -> dp[i] = dp[i-2] + stair[i]
- dp배열을 최갯값들로 채워 나가므로, dp[i]는 i미만의 인덱스 요소들만 참고하면됨 
- 점화식: dp[i] = Math.max( (dp[i-1] + dp[i-3] + stair[i]), (dp[i-2] + stair[i]) )
*/
/* 알게된 점
- 메모이제이션 방식으로 배열의 반복문을 사용할 때는 for문으로 함
- 점화식은 추상적인 부분에서 최대한 규칙을 찾고, 형태가 고정된 부분을 구현
- 반복문 진입 전, dp[상수] 부분을 작성할 때도 경우에 따라 나누는 상황이 발생할 수 있음
*/
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
