const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

let tc = Number(input[0]);

let line = 1;

const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

for (let t = 0; t < tc; t++) {
  let [m, n, k] = input[line++].split(" ").map(Number);
  // m: 가로, n: 세로, k: 심어놓은 배추 수

  const map = [];
  const visited = [];

  for (let i = 0; i < n; i++) {
    const row = [];
    const visitRow = [];
    for (let j = 0; j < m; j++) {
      row.push(0);
      visitRow.push(false);
    }
    map.push(row);
    visited.push(visitRow);
  }

  for (let i = 0; i < k; i++) {
    let [x, y] = input[line++].split(" ").map(Number);
    map[y][x] = 1;
  }

  function dfs(x, y) {
    visited[y][x] = true;
    for (let d = 0; d < 4; d++) {
      let ny = y + dy[d];
      let nx = x + dx[d];
      if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
        if (map[ny][nx] === 1 && !visited[ny][nx]) {
          dfs(nx, ny);
        }
      }
    }
  }

  let count = 0;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (map[i][j] === 1 && !visited[i][j]) {
        dfs(j, i);
        count++;
      }
    }
  }
  console.log(count);
}
