// 11372 KB	148 ms

const fs = require('fs');
const tokens = fs.readFileSync(0, 'utf8').trim().split(/\s+/).map(Number);

let p = 0;
const n = tokens[p++] || 0; // 포도주 잔 개수

// amounts: i번째 잔의 포도주 양 
const amounts = new Array(n + 1).fill(0);
for (let i = 1; i <= n; i++) amounts[i] = tokens[p++] || 0;

//   dp[i] = i번째 잔까지 고려했을 때의 최대 마신 양
//   i번째 잔에 대한 선택 경우의 수
//   1. i번째 잔을 마시지 않는다
//   2. i번째 잔만 마신다 (i-1은 건너뜀)
//   3. i-1, i번째 잔을 연속으로 마신다 (i-2는 건너뜀)
//     dp[i] = max(
//       dp[i-1],
//       dp[i-2] + amounts[i],
//       dp[i-3] + amounts[i-1] + amounts[i]
//     )

if (n === 0) {
  console.log('0');
} else if (n === 1) {
  console.log(String(amounts[1]));
} else {
  const dp = new Array(n + 1).fill(0);

  dp[1] = amounts[1];
  dp[2] = amounts[1] + amounts[2];

  for (let i = 3; i <= n; i++) {
    const caseSkip = dp[i - 1];
    const caseTakeOnlyI = dp[i - 2] + amounts[i];
    const caseTakeIminus1AndI = dp[i - 3] + amounts[i - 1] + amounts[i];
    dp[i] = Math.max(caseSkip, caseTakeOnlyI, caseTakeIminus1AndI);
  }

  console.log(String(dp[n]));
}
