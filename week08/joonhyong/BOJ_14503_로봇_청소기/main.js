// 백준 14503번 로봇 청소기
// 분류 : 구현, 시뮬레이션
/*입력예제
3 3
1 1 0
1 1 1
1 0 1
1 1 1
*/
/*유도코드
- while문을 통해 조건에 맞는 상황에서 break로 탈출
1. 현재 칸 청소 (if문으로 확인 + true일 경우 answer++)
2. 왼쪽으로 회전하면서 4방향 탐색
    - 회전 후에 탐색
    - 청소되지 않은 칸 발견 → 전진 후 다시 1번
3. 4방향 모두 청소됨
    - 뒤가 벽이 아니면 후진 → 다시 1번
    - 뒤가 벽이면 종료 (break)
 */
/* 알게된 점
- 반시계 방향으로 회전하는 방법: d = (d + 3) % 4
- 문제에서 요구하는 부분을 간략하게 만드는(표현하는) 것이 필요함

- 회전과 탐색의 순서의 중요성: 회전 후에 탐색하더라도 4방향 탐색 가능 -> 동작의 과정을 맞추기 위해 해당 방법으로 수행
*/
const fs = require("fs");
const file = process.platform === "linux" ? "/dev/stdin" : "../exam.txt";
const input = fs.readFileSync(file).toString().trim().split("\n");

const [N, M] = input[0].split(" ").map(Number);
let [r, c, d] = input[1].split(" ").map(Number);
let answer = 0;

const area = Array.from({ length: N }, () => Array.from({ length: M }, () => 0));

// area 채우기
for (let i = 0; i < N; i++) {
  const line = input[i + 2].split(" ").map(Number);
  for (let j = 0; j < M; j++) {
    area[i][j] = line[j];
  }
}

// 북 동 남 서
const dr = [-1, 0, 1, 0];
const dc = [0, 1, 0, -1];
// 후진 (북→남, 동→서, 남→북, 서→동)
const br = [1, 0, -1, 0];
const bc = [0, -1, 0, 1];

while (1) {
  // 1. 현재 칸 청소
  if (area[r][c] === 0) {
    area[r][c] = 2;
    answer++;
  }

  // 2. 주변 4칸 중 청소되지 않은 칸 탐색
  let found = false;

  for (let i = 0; i < 4; i++) {
    d = (d + 3) % 4; // 왼쪽 회전
    const nr = r + dr[d];
    const nc = c + dc[d];

    if (area[nr][nc] === 0) {
      // 전진
      r = nr;
      c = nc;
      found = true;
      break;
    }
  }

  // 3. 청소되지 않은 칸이 있었으면 계속 진행
  if (found) continue;

  // 4. 없으면 후진
  const nr = r + br[d];
  const nc = c + bc[d];

  // 후진 불가(벽) → 종료
  if (area[nr][nc] === 1) break;

  // 후진 가능 → 이동
  r = nr;
  c = nc;
}

console.log(answer);
