### 1463 - 1로 만들기

- 메모리: `42132KB`
- 시간: `200ms`

### 코드

```js
const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

let n = Number(input);

let memo = [];

memo[1] = 0; // 1일때는 최소 연산이니까 0

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

조건)

1. x % 3 === 0이면 3으로 나눈다.
2. x % 2 === 0이면 2로 나눈다.
3. 1을 뺀다.

이렇게 조건이 있을 때, i를 1로 만드는 방법 중 연산 횟수가 가장 적은 것을 골라야 하므로
Math.min을 사용해서 현재 메모이제이션되어 있는 값과 2 or 3을 나누고 +1 했을 때의 값을 비교한 뒤,
둘 중 더 적은 연산 횟수를 메모이제이션 해야 한다.
