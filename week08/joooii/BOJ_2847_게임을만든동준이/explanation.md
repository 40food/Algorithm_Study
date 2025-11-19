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

for문에서 i를 감소시켜서 처리하는 방법에서 너무너무 어려웟다

### 풀이과정

1. levels 배열에 levelScore을 두고 앞숫자, 뒷숫자를 비교

- 만약 `앞 > 뒤` 이면, `앞 < 뒤` 가 되도록 앞숫자를 감소시킴
- `앞 < 뒤` 이면, 통과

2. 감소시킨만큼 `count`에 저장 후 출력
