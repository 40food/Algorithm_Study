
const fs = require('fs');
const tokens = fs.readFileSync('/dev/stdin').toString().trim().split(/\s+/).map(Number);

let p = 0;
const n = tokens[p++]; // 정점(노드) 수 
const m = tokens[p++]; // 간선 수

// 인접 리스트 초기화
const graph = Array.from({ length: n + 1 }, () => []);

// 무방향 그래프이므로 간선을 양방향으로 추가
for (let i = 0; i < m; i++) {
  const u = tokens[p++];
  const v = tokens[p++];
  graph[u].push(v);
  graph[v].push(u);
}

// 방문 여부 배열
const visited = Array(n + 1).fill(false);

let count = 0; // 연결 요소 개수

// 모든 정점을 훑으면서, 아직 방문하지 않은 정점을 시작점으로 삼아 DFS 수행
for (let i = 1; i <= n; i++) {
  if (visited[i]) continue; 

  count++; // 새 발견
  const stack = [i]; // 반복형 DFS를 위한 스택
  visited[i] = true; // 시작 정점 방문 처리

  // 스택이 빌 때까지 DFS
  while (stack.length) {
    const cur = stack.pop();

    // 현재 정점과 인접한 모든 정점 탐색
    for (const next of graph[cur]) {
      if (!visited[next]) {
        visited[next] = true; // 방문 체크
        stack.push(next);     // 다음으로 확장
      }
    }
  }
}

console.log(count.toString());
