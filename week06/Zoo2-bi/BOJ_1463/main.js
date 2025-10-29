const fs = require('fs');
const X = Number(fs.readFileSync('input.txt').toString().trim());

function solution() {
  const dp = Array(X + 1).fill(0);

  for (let i = 2; i <= X; i++) {
    dp[i] = dp[i - 1] + 1;

    if (i % 2 === 0) {
      dp[i] = Math.min(dp[i], dp[i / 2] + 1);
    }

    if (i % 3 === 0) {
      dp[i] = Math.min(dp[i], dp[i / 3] + 1);
    }
  }

  return dp[X];
}

console.log(solution());