### 프로그래머스 숫자 문자열과 영단어

#### - 유형 : 2021 카카오 채용연계형 인턴십

#### - 입력예제

```
one4seveneight
```

#### - 유도코드

- 0으로 시작하지 않고 길이가 1이상 50이하인 문자열 s
- 문자열 s는 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 바뀌지않고 그대로인 문자열

- reader, answer라는 빈문자열 변수를 생성
- s의 첫번째 문자부터 순차적으로 확인하며 문자열이 아닌 경우 answer에 더하고, 문자열인 경우 reader 변수에 더한 뒤 아래의 과정 수행
  1. s[i]가 reader 변수에 추가된 후, switch문 실행
  2. reader의 상태가 zero~nine 중 하나에 해당할 경우, 그 문자열에 맞는 숫자문자를 answer에 더하고, reader를 빈문자열로 초기화
- for문이 끝난 후 answer를 숫자형태로 출력

#### - 알게된 점

- 나의 코드가 틀린 부분: for문 내부의 if문의 조건문을 !parseInt(s[i]) 로 작성
- 테스트케이스 10번에서 막힘
- s[i]가 0인 경우 false를 반환하여(!연산자와 만나 if문을 실행시킴), 0이라는 숫자임에도 reader 변수에 추가됨

### 코드 구현

#### - 언어 : JavaScript

#### - 메모리 : 33.4 MB (테스트10 기준)

#### - 시간 : 0.10 ms

```js
const fs = require("fs");
const file = process.platform === "linux" ? "/dev/stdin" : "../exam.txt";
const input = fs.readFileSync(file).toString().trim().split("\n");

const s = input.toString();

let reader = "";
let answer = "";
for (let i = 0; i < s.length; i++) {
  if (!parseInt(s[i])) {
    reader += s[i];
    switch (reader) {
      case "zero":
        answer += "0";
        reader = "";
        break;
      case "one":
        answer += "1";
        reader = "";
        break;
      case "two":
        answer += "2";
        reader = "";
        break;
      case "three":
        answer += "3";
        reader = "";
        break;
      case "four":
        answer += "4";
        reader = "";
        break;
      case "five":
        answer += "5";
        reader = "";
        break;
      case "six":
        answer += "6";
        reader = "";
        break;
      case "seven":
        answer += "7";
        reader = "";
        break;
      case "eight":
        answer += "8";
        reader = "";
        break;
      case "nine":
        answer += "9";
        reader = "";
        break;
    }
  } else answer += s[i];
}
console.log(answer);
```
