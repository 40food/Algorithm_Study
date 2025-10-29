let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

input = input.map((n) => Number(n));

for (let i = 1; i <= input.length - 1; ++i) {
    let target = input[i];

    let dp = new Array(target + 1).fill(0);
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (let j = 4; j <= target; ++j) {
        dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
    }

    console.log(dp[target]);
}