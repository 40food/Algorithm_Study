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