### [9095 - 1,2,3 더하기](https://www.acmicpc.net/problem/9095)

- 메모리: `9336KB`
- 시간: `92ms`

#### 코드

```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const ans = [];

function factorial(n) {
  if (n === 0 || n === 1) return 1;
  let result = 1;
  for (let i = n; i >= 2; i--) result *= i;
  return result;
}

// 첫 줄(테스트 케이스 수)을 제외하고 반복
input.slice(1).forEach((value) => {
  const target = +value; // 구할 목표 숫자 n
  let totalCount = 0; // 가능한 경우의 수 누적

  // 사용할 수 있는 3의 개수는 최대 target / 3
  const maxThreeCount = Math.floor(target / 3);

  // 3의 개수(i)별로 경우의 수 탐색
  for (let i = maxThreeCount; i >= 0; i--) {
    // 3을 i개 사용한 뒤 남은 합
    const remainingAfterThree = target - 3 * i;

    // 사용할 수 있는 2의 개수(j)는 최대 남은 합 / 2
    const maxTwoCount = Math.floor(remainingAfterThree / 2);

    // 2의 개수별로 반복
    for (let j = maxTwoCount; j >= 0; j--) {
      // 2와 3을 사용하고 남은 합은 모두 1로 채움
      const oneCount = remainingAfterThree - 2 * j;

      /**
       * 조합 계산
       * 전체 수열 길이 = oneCount + j + i
       * 서로 다른 숫자(1, 2, 3)의 개수가 있으므로
       * 중복 순열의 개수 = (전체길이)! / (1! × 2! × 3!)
       */
      const totalLength = oneCount + j + i;
      const combination =
        factorial(totalLength) /
        (factorial(oneCount) * factorial(j) * factorial(i));

      // 가능한 조합 수 누적
      totalCount += combination;
    }
  }

  // 결과 배열에 추가
  ans.push(totalCount);
});

console.log(ans.join("\n"));
```
