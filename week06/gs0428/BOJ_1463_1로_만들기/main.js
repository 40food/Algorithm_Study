const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const X = +input[0];

if (X === 1) return console.log(0);

const dp = Array.from({ length: X + 1 }, () => 0);

let num = 2;
while (num <= X) {
  dp[num] = dp[num - 1] + 1;
  if (num % 3 === 0) {
    dp[num] = Math.min(dp[num], dp[num / 3] + 1);
  }
  if (num % 2 === 0) {
    dp[num] = Math.min(dp[num], dp[num / 2] + 1);
  }

  num++;
}

console.log(dp[X]);
