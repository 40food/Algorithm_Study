### 백준 1475번 방 번호

#### - 유형 : 구현

#### - 입력예제

```
9999
```

#### - 유도코드

- 0~9까지 숫자별로 몇개가 필요한지 카운트 -> 배열로 하면 될 듯
- 6과 9는 뒤집어서 대체 가능 -> 6과 9중 하나만 있을 경우, 1세트로 2개 사용 가능 (6번째 또는 9번째 인덱스의 요소를 2로 나눔)
- 6과 9는 짝을 이루도록 셈 -> 6과 9의 개수는 같이 셈 + 둘 중 더 큰 수가 있다면 2로 나눔
- 만약 짝을 이루지 않는다면 2개를 1세트로 셀 수 있음

- 과정1: 배열을 채움. (인덱스 자체가 방번호에 쓰일 숫자)
- 과정2: 요소의 값이 가장 큰 인덱스가 6 OR 9가 아닌 경우, answer = 해당 인덱스의 요소
- 과정3: 요소의 값이 가장 큰 인덱스가 6 OR 9인 경우 아래의 과정 수행
  - 과정3-1: r = 해당 인덱스(예: 6)의 요소 - 반대쪽 인덱스(예: 9)의 요소
  - 과정3-2: r%2 === 0, arr[6] = arr[9] + r/2
  - 과정3-3: r%2 !== 0, arr[6] = arr[9] + r/2 + 1
- 과정4: answer 출력

#### - 알게된 점

### 코드 구현

#### - 언어 : JavaScript

#### - 메모리 : 9344 KB

#### - 시간 : 100 ms

```js
const fs = require("fs");
const file = process.platform === "linux" ? "/dev/stdin" : "../exam.txt";
const input = fs.readFileSync(file).toString().trim().split("\n");

const roomNum = input.shift();
const arr = Array.from({ length: 10 }).fill(0);
let answer = 0;

for (let i = 0; i < roomNum.length; i++) {
  arr[Number(roomNum[i])]++;
}

// Math.max(...arr)가 6,9가 아닌 경우
if (Math.max(...arr) !== arr[6] && Math.max(...arr) !== arr[9]) {
  answer = Math.max(...arr);
}
// Math.max(...arr)가 6인 경우
else if (Math.max(...arr) === arr[6]) {
  r = arr[6] - arr[9];
  if (r % 2 === 0) arr[6] = arr[9] + r / 2;
  else if (r % 2 !== 0) arr[6] = arr[9] + Math.ceil(r / 2);
  answer = Math.max(...arr);
}
// Math.max(...arr)가 9인 경우
else if (Math.max(...arr) === arr[9]) {
  r = arr[9] - arr[6];
  if (r % 2 === 0) arr[9] = arr[6] + r / 2;
  else if (r % 2 !== 0) arr[9] = arr[6] + Math.ceil(r / 2);
  answer = Math.max(...arr);
}
console.log(answer);
```
