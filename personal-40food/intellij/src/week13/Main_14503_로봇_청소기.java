package week13;
import java.util.Scanner;
public class Main_14503_로봇_청소기 {
    static int n;
    static int m;
    static int[] start;
    static int dir;
    static int[] dr={-1,0,1,0};
    static int[] dc={0,1,0,-1};
    static int[][] arrays;
    static int count;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m= sc.nextInt();
        start=new int[2];
        start[0]=sc.nextInt();
        start[1]=sc.nextInt();
        dir=sc.nextInt();
        arrays=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arrays[i][j]=sc.nextInt();
            }
        }

        clean(start[0],start[1],dir);
        System.out.println(count);
    }
    public static void clean(int startX, int startY, int direction){
        if(arrays[startX][startY]==0){
            // 1. 방문하지 않았으면 청소 처리
            arrays[startX][startY]=2;
            count++;
        }
        //3. 주변 네 칸 중 청소할 칸이 있는 경우
        for(int i=0;i<4;i++){
            direction=(direction+3)%4; //반!!시계 방향, 있던 방향 갱신 필요
            int nr=startX+dr[direction];
            int nc=startY+dc[direction];
            if(arrays[nr][nc]==0){
                clean(nr,nc,direction);
                return; //break가 아니라 return-그래야 끝남 => 하나 하고 종료
            }
        }
        //2. 주변 네 칸을 다 청소했거나 청소할 칸이 없는 경우
        int bd=(direction+2)%4;
        int br=startX+dr[bd];
        int bc=startY+dc[bd];
        if(arrays[br][bc]!=1) clean(br,bc,direction);
        //벽에 막히는 게 아니라면! 추가
        //후진이라 방향은 똑같음! 추가
    }
}