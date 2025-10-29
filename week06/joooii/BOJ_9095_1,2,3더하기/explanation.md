### 9095 - 1,2,3 더하기

- 메모리: `9364KB`
- 시간: `88ms`

### 코드

```js
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
```

### 풀이과정

메모이제이션 할 배열을 생성한다.
1을 만들기 위해 필요한 경우의 수: 1 = 1,
2를 만들기 위해 필요한 경우의 수: 1+1, 2 = 2,
3을 만들기 위해 필요한 경우의 수: 1+1+1, 1+2, 2+1, 3 = 4
피보나치 배열처럼 1,2,3을 더해서 만들 수 있는 경우의 수를 memo[i]로 둔다.
