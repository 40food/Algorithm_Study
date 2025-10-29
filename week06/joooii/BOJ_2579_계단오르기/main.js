const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n").map(Number);

let floors = input[0];
let floorScore = [0, ...input.slice(1)];

let memo = [];

memo[1] = floorScore[1];

if (floors >= 2) {
  memo[2] = floorScore[1] + floorScore[2];
}

if (floors >= 3) {
  memo[3] = Math.max(
    floorScore[1] + floorScore[3],
    floorScore[2] + floorScore[3]
  );
}

for (let i = 4; i <= floors; i++) {
  memo[i] = Math.max(
    memo[i - 2] + floorScore[i],
    memo[i - 3] + floorScore[i - 1] + floorScore[i]
  );
}
console.log(memo[floors]);
