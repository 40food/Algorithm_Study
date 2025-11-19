
### 푼 문제: 로봇 청소기

- [https://www.acmicpc.net/problem/1450](https://www.acmicpc.net/problem/14503)

---

### 해설

- 로봇 청소기와 방의 상태가 주어졌을 때, 청소하는 영역의 개수를 구해야한다.
- 로봇 청소기의 동작
1. 현재 칸 청소 X → 청소
2. 현재 칸 주변 4칸중에 청소 O
    1. 바라보는 방향 한칸 후진, 못하면 1번으로 돌아간다.
    2. 만약 벽이라서 후진못할땐 작동 멈춤
3. 현재 칸 주변 4칸에 청소 X
    1. 반시계 방향으로 90도 회전
    2. 현재 방향이 청소 X → 한칸 전진
    3. 1번으로 돌아간다.

### 코드

```java
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int N, M;
    static int r, c, d;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        while(true){
            if(arr[r][c] == 0){
                arr[r][c] = 2;
                count++;
            }

            boolean move = false;

            for(int i = 0; i < 4; i++){
                d = (d + 3) % 4;

                int nx = r + dx[d];
                int ny = c + dy[d];

                if(arr[nx][ny] == 0){
                    r = nx;
                    c = ny;
                    move = true;
                    break;
                }
            }

            if(!move){
                int bx = r - dx[d];
                int by = c - dy[d];

                if(arr[bx][by] == 1){
                    break;
                }else{
                    r = bx;
                    c = by;
                }
            }
        }
        System.out.println(count);
    }
}
```

---

### 풀이

- 맵 상태를 저장과 로봇 청소기의 시작점을 저장한다.
- 중요한 점은 반시계 방향으로 바뀌는 순서를 정해야한다.
- 문제에서 0 → 북, 1 → 동, 2 → 남, 3 → 서 로 되어있다.
- 따라서 `dx = {-1, 0, 1, 0}`, `dy = {0, 1, 0, -1}`로 정해야 한다.
- 문제 지문에서 `뒤로 갈때 벽이 있어 가지 못하면 동작을 중지` 이 부분으로 인해 `whil(true)`로 동작을 할 수 있다는걸 알게 되었다.
- 4방향을 `visited`로 탐색을 할 줄 알았는데 한 부분만 참만 되면 작동할 수 있었다.
    - 왜냐하면 청소가 다 되어있어 움직이지 않는 경우만 로직이 있어야 하는데 그 경우는 전부 다 방문한 딱 한번의 경우라서 `boolean move = false` 로 시작한 다음 움직일 때, 참으로 만들어주면 된다.
- 방향을 바꿀때는 `d = (d + 3) % 4` 를 쓰면 쉽게 바꿀 수 있다.
- 뒤로 갈때는 정해둔 `dx` `dy` 를 빼면 그 방향에 뒤로 갈 수 있다.
- 그렇게 해서 이동 후 최신화를 해주고 탐색을 하며 카운트를 세다보면 정답이 된다.

---