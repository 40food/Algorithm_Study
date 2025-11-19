const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

let n = String(input);
let sets = 0;
let count = Array(10).fill(0);

for (let ch of n) {
  count[ch]++;
}

for (let i = 0; i <= 9; i++) {
  let cnt;

  if (i === 6 || i === 9) continue;
  else {
    cnt = count[i];
    sets = Math.max(sets, cnt);
  }
  let total = count[6] + count[9];
  let sixNineSets = Math.ceil(total / 2);

  sets = Math.max(sets, sixNineSets);
}
console.log(sets);
