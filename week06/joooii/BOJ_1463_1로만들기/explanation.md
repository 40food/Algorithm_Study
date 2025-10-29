### 1463 - 1로 만들기

- 메모리: `42132KB`
- 시간: `200ms`

### 코드

```js
const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

let n = Number(input);

let memo = [];
// 1일때는 최소 연산이니까 0
memo[1] = 0;
for (let i = 2; i <= n; i++) {
  // 1을 빼는 경우
  memo[i] = memo[i - 1] + 1;
  // 2로 나누어떨어지는 경우, 두 값 중 최소값
  if (i % 2 === 0) {
    memo[i] = Math.min(memo[i], memo[i / 2] + 1);
  }
  // 3으로 나누어떨어지는 경우, 두 값 중 최소값
  if (i % 3 === 0) {
    memo[i] = Math.min(memo[i], memo[i / 3] + 1);
  }
}

console.log(memo[n]);
```

### 풀이과정
