// 프로그래머스 오픈채팅방
// 분류 : 2019 KAKAO BLIND RECRUITMENT
/*입력예제
- 백준 버전: Enter uid1234 Muzi,Enter uid4567 Prodo,Leave uid1234,Enter uid1234 Prodo,Change uid4567 Ryan
- 프그 버전: ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
*/
/*유도코드
- 입력예제: 문자열을 요소로 갖는 input 배열
- 배열을 요소로 갖는 record 배열로 변환
  - record배열 요소의 구성: ["행위", "아이디", "닉네임"]

- screen 배열 생성
- nickname 맵 생성
- result 배열 생성

- rocord 배열을 순회하며 아래의 과정을 수행
  - Enter이면 map 추가(수정) 후 screen배열에 추가 (["행위", "아이디", map.get("아이디")]의 형태)
  - Leave이면 screen배열에 추가 (["행위", "아이디", map.get("아이디")]의 형태)
  - Change이면 map 수정
- record 배열 순호 종료 후 screen 배열 순회을 순회하며 아래의 과정을 수행
  - screen[i][2]이 nickname.get(screen[i][1])와 다르다면, map의 값으로 수정

- screen 배열 순회하며 아래의 행위를 수행
  -  "행위"가 "Enter"이면 "'닉네임'님이 들어왔습니다."로 변환하여 result 배열에 추가
  -  "행위"가 "Leave"이면 "'닉네임'님이 나갔습니다."로 변환하여 result 배열에 추가

- result 반환
  */
/* 알게된 점
- forEach문 사용 시 알아야하는 점
    - forEach문의 콜백함수의 행위 반환 형태를 확인(return 값이 있는지 여부)
    - 원본배열의 요소들에 변경사항 적용 희망 시: forEach문의 두,세번째 인자도 할당해야함 
*/
const fs = require("fs");
const file = process.platform === "linux" ? "/dev/stdin" : "../exam.txt";
const input = fs.readFileSync(file).toString().trim().split("\n");

const record = input.toString().split(",");
record.forEach((x, i, record) => {
  record[i] = x.split(" ");
});

const screen = [];
const map = new Map();

// screen 배열 요소 생성
for (let i = 0; i < record.length; i++) {
  // Enter
  if (record[i][0] === "Enter") {
    // map 추가 혹은 갱신
    map.set(record[i][1], record[i][2]);
    // screen배열에 추가
    screen.push([record[i][0], record[i][1], map.get(record[i][1])]);
  } else if (record[i][0] === "Leave") {
    // screen배열에 추가
    screen.push([record[i][0], record[i][1], map.get(record[i][1])]);
  } else if (record[i][0] === "Change") {
    // map 갱신
    map.set(record[i][1], record[i][2]);
  }
}

// screen 배열을 map 정보에 맞게 갱신
for (let i = 0; i < screen.length; i++) {
  if (screen[i][2] !== map.get(screen[i][1])) {
    screen[i][2] = map.get(screen[i][1]);
  }
}

console.log(screen);

// screen 배열을 result 형태로 변환
screen.forEach((x, i) => {
  if (screen[i][0] === "Enter") {
    result.push(`${screen[i][2]}님이 들어왔습니다.`);
  } else if (screen[i][0] === "Leave") {
    result.push(`${screen[i][2]}님이 나갔습니다.`);
  }
});
