### [2847 - 게임을 만든 동준이](https://www.acmicpc.net/problem/2847)

- 메모리: `9608KB`
- 시간: `92ms`

#### 코드

```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const N = +input.shift();
// 뒤에서부터 탐색하기 위해 reverse
const levels = input.reverse();

// 감소 시켜야하는 횟수
let cnt = 0;
// 현재 레벨을 갖고 있는 변수
let prevLevel = +levels[0];

for (let i = 1; i < N; i++) {
  const level = +levels[i];

  // 이전 레벨의 점수가 현재 레벨 점수보다 작거나 같다면
  // 횟수 감소시키는 로직 진행
  if (prevLevel <= level) {
    // 이전 레벨보다 최소 1이 낮아야함
    const target = prevLevel - 1;
    cnt += level - target;
    prevLevel = target;
  } else {
    prevLevel = level;
  }
}

console.log(cnt);
```
