### 2579 - 계단오르기

- 메모리: `9372KB`
- 시간: `92ms`

### 코드

```js
const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n").map(Number);

let floors = input[0];
let floorScore = [0, ...input.slice(1)]; // 각 계단의 스코어

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
```

### 풀이과정

메모이제이션 할 배열 생성

조건 정리

- 연속 3칸 x
  i번째 계단을 밟는 경우의 수:

  (i-2) → i

  i-1을 밟지 않고 넘어옴 → 연속 3칸 방지됨
  → memo[i-2] + floorNums[i]

  (i-3) → (i-1) → i

  i-1을 밟고 싶다면 i-2는 건너뛰어야 함
  → memo[i-3] + floorNums[i-1] + floorNums[i]

두 경우의 점수 중 더 큰 것을 출력
