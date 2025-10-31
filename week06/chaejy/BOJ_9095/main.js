// 9336 KB	92 ms

const fs = require('fs');
const tokens = fs.readFileSync(0, 'utf8').trim().split(/\s+/).map(Number);

let p = 0;
const T = tokens[p++] || 0; // 테스트 케이스 개수

//   dp[n] = n을 1,2,3의 합으로 나타내는 방법 수
//   dp[n] = dp[n-1] + dp[n-2] + dp[n-3]

// 최대 n이 10
const MAX_N = 10;
const dp = new Array(MAX_N + 1).fill(0);
dp[0] = 1;
dp[1] = 1;
dp[2] = 2;
for (let i = 3; i <= MAX_N; i++) {
  dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
}

const out = [];
for (let t = 0; t < T; t++) {
  const n = tokens[p++] || 0;
  out.push(String(dp[n] || 0));
}

console.log(out.join('\n'));