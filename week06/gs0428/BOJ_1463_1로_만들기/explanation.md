### [1463 - 1로 만들기](https://www.acmicpc.net/problem/1463)

- 메모리: `17508KB`
- 시간: `224ms`

#### 코드

```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const X = +input[0];

// 숫자가 이미 1이라면 수행할 연산이 없으므로 0 반환
if (X === 1) return console.log(0);

// X + 1개만큼 dp 배열 생성
const dp = Array.from({ length: X + 1 }, () => 0);

// 2부터 시작
let num = 2;
while (num <= X) {
  // 1을 더했을 때
  dp[num] = dp[num - 1] + 1;

  // 만약 3으로 나눠진다면
  // 현재 값과 이전에 3으로 나눴던 값에 1을 더한 값 중
  // 더 작은 값을 현재 값으로 설정
  if (num % 3 === 0) {
    dp[num] = Math.min(dp[num], dp[num / 3] + 1);
  }

  // 만약 2로 나눠진다면
  // 현재 값과 이전에 2로 나눴던 값에 1을 더한 값 중
  // 더 작은 값을 현재 값으로 설정
  if (num % 2 === 0) {
    dp[num] = Math.min(dp[num], dp[num / 2] + 1);
  }

  // 다음 숫자
  num++;
}

// dp 배열에서 X 위치에 있는 값
console.log(dp[X]);
```

#### 어려웠던 점

BFS -> 메모리 초과 발생

```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const X = +input[0];

let min = Number.MAX_VALUE;

let head = 0;
const queue = [[X, 0]];
while (head < queue.length) {
  const [num, cnt] = queue[head++];

  if (num < 1) continue;

  if (num === 1) {
    min = Math.min(cnt, min);
    continue;
  }

  if (num % 3 === 0) {
    queue.push([num / 3, cnt + 1]);
  }
  if (num % 2 === 0) {
    queue.push([num / 2, cnt + 1]);
  }
  queue.push([num - 3, cnt + 1]);
}

console.log(min);
```

DFS -> 시간 초과

```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const X = +input[0];

const dp = Array.from({ length: X + 1 }, () => Number.MAX_VALUE);

function dfs(num, cnt) {
  if (num % 3 === 0) {
    dp[num / 3] = Math.min(dp[num / 3], cnt + 1);
    dfs(num / 3, cnt + 1);
  }
  if (num % 2 === 0) {
    dp[num / 2] = Math.min(dp[num / 2], cnt + 1);
    dfs(num / 2, cnt + 1);
  }
  if (num > 1) {
    dp[num - 1] = Math.min(dp[num - 1], cnt + 1);
    dfs(num - 1, cnt + 1);
  }
}

dfs(X, 0);

console.log(dp[1]);
```

Bottom-Up + DFS -> StackSizeExceeded(MaximumCall) 발생

```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const X = +input[0];

if (X === 1) return console.log(0);

const dp = Array.from({ length: X + 1 }, () => 0);

function dfs(num) {
  if (num === X + 1) return;

  dp[num] = dp[num - 1] + 1;
  if (num % 3 === 0) {
    dp[num] = Math.min(dp[num], dp[num / 3] + 1);
  }
  if (num % 2 === 0) {
    dp[num] = Math.min(dp[num], dp[num / 2] + 1);
  }

  dfs(num + 1);
}

dfs(2);

console.log(dp[X]);
```
