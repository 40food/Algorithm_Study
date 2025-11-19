### 2847 - 게임을 만든 동준이

- 메모리: `9596KB`
- 시간: `88ms`

### 코드

```js
const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n").map(Number);

let n = input[0];
let levelScore = input.slice(1);
let count = 0;

for (let i = n - 1; i > 0; i--) {
  if (levelScore[i - 1] >= levelScore[i]) {
    count += levelScore[i - 1] - levelScore[i] + 1;
    levelScore[i - 1] = levelScore[i] - 1;
  }
}
console.log(count);
```

### 시행착오

뒤에 있는 레벨 점수를 기준으로 앞의 점수를 조정해야 해서 `뒤 -> 앞`으로 이동하는 구조이기에 i-- 시켜서 처리하는 방법을 생각해내는게 좀 어려웠다.
i--를 하는게 익숙하지 않아서 좀 헤맸는데 앞으로 이런 문제를 여러 번 풀어서 익숙해지도록 해야겠다고 생각했다.

### 풀이과정

1. levels 배열에 levelScore을 두고 앞숫자, 뒷숫자를 비교

- 만약 `앞 > 뒤` 이면, `앞 < 뒤` 가 되도록 앞숫자를 감소시킴
- `앞 < 뒤` 이면, 통과

2. 감소시킨만큼 `count`에 저장

3. for문을 돌면서 앞 < 뒤 `(levelScore[0] < levelScore[1] < ... levelScore[n-1])` 조건을 만족시키면 종료

4. `count` 출력
