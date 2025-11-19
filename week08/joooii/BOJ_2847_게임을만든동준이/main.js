const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n").map(Number);

let n = input[0];
let levelScore = input.slice(1);
let count = 0;

// 시행착오: for문에서 i를 감소시켜서 처리하는 방법에서 너무너무 어려웟다

for (let i = n - 1; i > 0; i--) {
  if (levelScore[i - 1] >= levelScore[i]) {
    count += levelScore[i - 1] - levelScore[i] + 1;
    levelScore[i - 1] = levelScore[i] - 1;
  }
}
console.log(count);
