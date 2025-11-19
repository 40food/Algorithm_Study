// 백준 2847번 게임을 만든 동준이
// 분류 : 그리디 알고리즘
/*입력예제
4
5
3
7
5
*/
/*유도코드
- 레벨별 점수를 요소로 갖는 배열 scoreArr 생성
- 점수를 감소시키는 횟수를 세는 answer 변수 생성
- for문을 통해 배열의 가장 뒤의 요소부터 순회 시작
    - a(해당 요소)와 b(해당 요소의 바로 앞 요소)를 가져와 대소비교
        - a-b > 0인 경우, continue
        - a-b <= 0인 경우, 
            - b에서 a-1까지의 차이를 answer에 더하고
            - b의 값을 갖는 scoreArr 요소의 값을 a-1로 수정
- for문 종료 후 answer 출력
*/
/* 알게된 점
 */
const fs = require("fs");
const file = process.platform === "linux" ? "/dev/stdin" : "../exam.txt";
const input = fs.readFileSync(file).toString().trim().split("\n");

const N = Number(input[0]);
const scoreArr = [];
let answer = 0;

for (let i = 1; i <= N; i++) {
  scoreArr.push(Number(input[i]));
}

for (let i = 1; i <= N; i++) {
  let a = scoreArr[scoreArr.length - i];
  let b = scoreArr[scoreArr.length - i - 1];
  if (a - b > 0) continue;
  else if (a - b <= 0) {
    answer += b - (a - 1);
    scoreArr[scoreArr.length - i - 1] = a - 1;
  }
}

console.log(answer);
