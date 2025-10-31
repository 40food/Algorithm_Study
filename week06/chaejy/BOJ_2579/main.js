// 	9348 KB	88 ms

const fs = require('fs');
const tokens = fs.readFileSync(0, 'utf8').trim().split(/\s+/).map(Number);

let p = 0;
const n = tokens[p++] || 0; // 계단 수

// scores: i번째 계단의 점수
const scores = new Array(n + 1).fill(0);
for (let i = 1; i <= n; i++) scores[i] = tokens[p++] || 0;

//   dp[i] = i번째 계단까지 왔을 때 얻을 수 있는 최대 점수 
//   1. i-1을 밟지 않고 i를 밟는 경우
//   2. i-2를 밟지 않고 i-1과 i를 연속으로 밟는 경우
//   dp[i] = max(dp[i-2] + scores[i], dp[i-3] + scores[i-1] + scores[i])

if (n === 0) {
  console.log('0');
} else if (n === 1) {
  console.log(String(scores[1]));
} else if (n === 2) {
  console.log(String(scores[1] + scores[2]));
} else {
  const dp = new Array(n + 1).fill(0);

  dp[1] = scores[1];
  dp[2] = scores[1] + scores[2];

  for (let i = 3; i <= n; i++) {
    const caseSkipIminus1 = dp[i - 2] + scores[i];
    const caseTakeIminus1AndI = dp[i - 3] + scores[i - 1] + scores[i];
    dp[i] = Math.max(caseSkipIminus1, caseTakeIminus1AndI);
  }

  // 마지막 계단을 반드시 밟아야 하므로 dp[n]
  console.log(String(dp[n]));
}