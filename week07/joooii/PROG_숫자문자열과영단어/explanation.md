### 프로그래머스 - 숫자 문자열과 영단어

### 코드

```js
// 1. switch문 사용
function solution(s) {
  let number = [
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
  ];

  let temp = "";
  let answer = "";

  for (let ch of s) {
    if (ch >= "0" && ch <= "9") {
      answer += ch;
    } else {
      temp += ch;
      switch (temp) {
        case "zero":
          answer += 0;
          temp = "";
          break;
        case "one":
          answer += 1;
          temp = "";
          break;
        case "two":
          answer += 2;
          temp = "";
          break;
        case "three":
          answer += 3;
          temp = "";
          break;
        case "four":
          answer += 4;
          temp = "";
          break;
        case "five":
          answer += 5;
          temp = "";
          break;
        case "six":
          answer += 6;
          temp = "";
          break;
        case "seven":
          answer += 7;
          temp = "";
          break;
        case "eight":
          answer += 8;
          temp = "";
          break;
        case "nine":
          answer += 9;
          temp = "";
          break;
      }
    }
  }

  return Number(answer);
}

// 2. for문 사용
function solution(s) {
  const number = [
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
  ];

  let temp = "";
  let answer = "";

  for (let ch of s) {
    if (ch >= "0" && ch <= "9") {
      answer += ch;
    } else {
      temp += ch;

      for (let i = 0; i <= number.length; i++) {
        if (temp === number[i]) {
          answer += i;
          temp = "";
          break;
        }
      }
    }
  }
  return Number(answer);
}
```

### switch와 for문 시간 비교

#### 1. switch문

    execution: 0.108ms
    1478

    execution: 0.007ms
    234567

    execution: 0.004ms
    234567

    execution: 0.001ms
    123

#### 2. for문

    execution: 0.234ms
    1478

    execution: 0.006ms
    234567

    execution: 0.004ms
    234567

    execution: 0.001ms
    123

#### 결론

    - switch : case로 분기처리를 하기 때문에 해당하는 문자열의 case가 바로 실행됨.

    - for + if : 매일 배열을 처음부터 끝까지 돌면서 하나씩 비교하기 때문에 최대 10번의 비교가 반복됨.

    🚀 switch문이 연산속도가 더 빠르다
