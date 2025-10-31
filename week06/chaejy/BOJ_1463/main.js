// 17436 KB	160	ms

const fs = require('fs');
const input = fs.readFileSync(0, 'utf8').trim();

// 사용 가능한 연산: 3으로 나누기 / 2으로 나누기 / 1 빼기
//   dp[i] = i를 1로 만드는 최소 연산 횟수
//   dp[i] = min(
//     dp[i-1] + 1,
//     i%2==0 ? dp[i/2] + 1 : INF,
//     i%3==0 ? dp[i/3] + 1 : INF
//   )

const N = Number(input);

if (Number.isNaN(N) || input.length === 0) {
  console.log('0');
} else {
  // dp[1] = 0 (이미 1이므로 연산 0회)
  const dp = new Array(N + 1).fill(0);
  for (let i = 2; i <= N; i++) {
    // 1 빼기 연산
    dp[i] = dp[i - 1] + 1;

    // 2로 나누어 떨어지면: 나누기 2 연산 고려
    if (i % 2 === 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);

    // 3으로 나누어 떨어지면: 나누기 3 연산 고려
    if (i % 3 === 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
  }
  console.log(String(dp[N]));
}