// 프로그래머스 신고 결과 받기
// 분류 : 2022 KAKAO BLIND RECRUITMENT
/*입력예제
muzi, frodo, apeach, neo
muzi frodo, apeach frodo, frodo neo, muzi neo, apeach muzi
2
*/
/*유도코드
- id_list: ["이용자1, 이용자2, 이용자3, ..."]
- record: ["신고자 , 피신고자", "신고자 , 피신고자", ...]
- 정지 기준 횟수: k
- id_list 배열의 길이와 같고 각 요소가 0인 answer 배열 생성: 받은 메일 개수

- 과정1) id_list 배열을 순회
- 신고자가 신고한 대상 목록을 값으로 갖는 map1 생성
- 피신고자를 신고한 대상 목록을 키로 갖는 map2 생성
- 키: id_list의 요소
- 값: 빈배열 []

- 과정2) record 배열을 순회
- map1과 map2의 값들을 채움

- 과정3) Map을 순회
- map1을 순회
  - 각 키의 값은 배열(요소: 신고자가 신고한 이용자들)
  - 해당 배열의 각 요소(피신고자의 신고받은 횟수)를 result 배열을 참고
  - k이상인지 확인 후 참이면 answer배열의 요소를 +1, 거짓이면 pass  

- answer 배열 반환
*/
/* 알게된 점

*/
const fs = require("fs");
const file = process.platform === "linux" ? "/dev/stdin" : "../exam.txt";
const input = fs.readFileSync(file).toString().trim().split("\n");

// 프로그래머스 입력값으로 세팅
const id_list = input.shift().trim().split(", ");
const record = input.shift().trim().split(", ");
const k = Number(input.shift());
const answer = Array.from({ length: id_list.length }).fill(0);

// 과정1: 신고자, 피신고자 관련 map 생성
const map1 = new Map();
const map2 = new Map();
for (const user of id_list) {
  map1.set(user, []);
  map2.set(user, []);
}

// //과정2: map 값 채우기
for (let line of record) {
  line = line.split(" ");
  // map1 채우기: 신고자가 신고한 유저 추가
  if (!map1.get(line[0]).includes(line[1])) {
    map1.get(line[0]).push(line[1]);
  }
  // map2 채우기: 피신고자를 신고한 유저 추가
  if (!map2.get(line[1]).includes(line[0])) {
    map2.get(line[1]).push(line[0]);
  }
}

// 과정3: answer 채우기
for (let i = 0; i < answer.length; i++) {
  const singo = map1.get(id_list[i]);
  for (let j = 0; j < singo.length; j++) {
    if (map2.get(singo[j]).length >= k) answer[i] += 1;
  }
}

console.log(answer);
