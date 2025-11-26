package week9.level3_등굣길;

public class Main_등굣길 {
    /* BFS의 depth로 하는 건가 했는데...
        DP (그러니까 이 또한 결국 점화식은 만들어야 함)
        목적지까지 가는 경우의 수를 세는 문제

        4*3 배열에 [2,2] 위치에 웅덩이가 있다고 한다면
        갈 수 있는 경우의 수는 다음과 같다.
        1 1 1 1
        1 x 1 2
        1 1 2 4
        이런 식으로 계산해가면 됨
    * */

    class Solution{
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;
            int[][] grid=new int[n+1][m+1];
            for(int[] p:puddles) grid[p[1]][p[0]]=-1;

            grid[1][1]=1;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(i==1&&j==1) continue;
                    if(grid[i][j]==-1){
                        grid[i][j]=0;
                        continue;
                    }
                    grid[i][j]=(grid[i][j-1]+grid[i-1][j])%1000000007;
                }
            }
            return grid[n][m];
        }
    }

}
