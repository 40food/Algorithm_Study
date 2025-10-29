// 백준 9095번 1, 2, 3 더하기
// 분류 : 다이나믹 프로그래밍
/*입력예제
3
4
7
10
*/
/*유도코드
- 1,2,3이 더해져서 n이 만들어질 때, 순서가 다른 경우, 다른 경우로 취급
- n은 이전의 세가지 수를 만드는 경우의 수를 더한 것과 같음
- 각각의 경우에 3, 2, 1을 더해주면 되기 때문
- 점화식 : dp[n] = dp[n-1] + dp[n-2] +dp[n-3]
*/
/* 알게된 점

*/
const fs = require("fs");
const file = process.platform === "linux" ? "/dev/stdin" : "../exam.txt";
const input = fs.readFileSync(file).toString().trim().split("\n");

const T = Number(input.shift());
const nums = input.map(Number);

const dp = Array(12).fill(0);
dp[1] = 1;
dp[2] = 2;
dp[3] = 4;
for (let i = 4; i <= 11; i++) {
  dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
}

for (let n of nums) {
  console.log(dp[n]);
}
