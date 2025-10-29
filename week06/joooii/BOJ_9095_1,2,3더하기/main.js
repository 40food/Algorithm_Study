const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

let T = Number(input[0]);
let nums = input.slice(1).map(Number);

// 메모이제이션 할 배열
let memo = [];

memo[1] = 1;
memo[2] = 2;
memo[3] = 4;

let max = Math.max(...nums);

for (let i = 4; i <= max; i++) {
  memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
  // memo[4] = memo[3] + memo[2] + memo[1]
}

for (let i = 0; i < T; i++) {
  let n = nums[i];
  console.log(memo[n]);
}
