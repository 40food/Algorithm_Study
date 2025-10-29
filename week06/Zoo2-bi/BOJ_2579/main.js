const fs = require('fs');
let [n, ...input] = fs.readFileSync('dev/stdin').toString().trim().split('\n');
input = input.map(Number);

const dp = [];

dp[0] = input[0];
dp[1] = Math.max(input[0] + input[1], input[1]);
dp[2] = Math.max(input[0] + input[2], input[1] + input[2]);

for (let i = 3; i < input.length; i++) {
  dp[i] = Math.max(input[i] + input[i - 1] + dp[i - 3], input[i] + dp[i - 2]);
}

console.log(dp[+n - 1]);