### [1475 - 방 번호](https://www.acmicpc.net/problem/1475)

- 메모리: `9356KB`
- 시간: `100ms`

#### 코드

```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

// 0부터 9가 있는 배열 선언
const nums = Array(10).fill(0);

input[0].split("").forEach((n) => {
  // 6과 9를 같은 취급하기 때문에 6인 경우 9에 +1
  if (+n === 6) {
    nums[9]++;
  } else {
    nums[+n]++;
  }
});

// 최대 개수
const maxNum = Math.max(...nums);
// 최대 개수의 index
const maxIdx = nums.indexOf(maxNum);

// 최대 개수의 index가 9라면 최대 개수 / 2를 올림한 값이 정답
if (maxIdx === 9) {
  console.log(Math.ceil(nums[maxIdx] / 2));
} else {
  // 아니라면 해당 값을 출력
  console.log(nums[maxIdx]);
}
```
