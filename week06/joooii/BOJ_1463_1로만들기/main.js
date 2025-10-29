const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

let n = Number(input);

let memo = [];
memo[1] = 0;
for (let i = 2; i <= n; i++) {
  memo[i] = memo[i - 1] + 1;

  if (i % 2 === 0) {
    memo[i] = Math.min(memo[i], memo[i / 2] + 1);
  }
  if (i % 3 === 0) {
    memo[i] = Math.min(memo[i], memo[i / 3] + 1);
  }
}

console.log(memo[n]);
