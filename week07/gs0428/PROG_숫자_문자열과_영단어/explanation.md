### [81301 - 숫자 문자열과 영단어](https://school.programmers.co.kr/learn/courses/30/lessons/81301)

#### 코드

```js
const strToNum = {
  zero: 0,
  one: 1,
  two: 2,
  three: 3,
  four: 4,
  five: 5,
  six: 6,
  seven: 7,
  eight: 8,
  nine: 9,
};

function solution(s) {
  // 모두 숫자로 이루어진 경우 숫자로 변환하여 반환
  if (!isNaN(+s)) return BigInt(s);

  let ans = "";
  let str = "";

  for (const item of s) {
    // 숫자인 경우 정답 문자열에 추가
    if (!isNaN(+item)) {
      ans += item;
    } else {
      // 임시 str 변수에 글자 붙이기
      str += item;
      // strToNum 객체에 값이 있다면
      // 해당 값 정답 문자열에 붙이고
      // 임시 str 변수 초기화
      if (strToNum[str] !== undefined) {
        ans += strToNum[str];
        str = "";
      }
    }
  }

  // 정답 문자열 return
  return BigInt(ans);
}
```

#### 어려웠던 점

```js
// 기존 코드
if (!strToNum[str]) {
  ans += strToNum[str];
  str = "";
}
```

기존 코드와 같이 했을 때 `strToNum[str]`의 값이 0일때 if 문이 실행되지 않음
따라서 현재 코드와 같이 로직 변경

```js
// 현재 코드
if (strToNum[str] !== undefined) {
  ans += strToNum[str];
  str = "";
}
```
