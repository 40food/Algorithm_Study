package algo_study;

import java.util.*;

public class Main {

	static int count=0;
	static int[][] arrays;
	static int[] dr={-1,0,1,0};
	static int[] dc={0,1,0,-1};
	// 0북 1동 2남 3서

	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); //행 수
		int m=sc.nextInt(); //열 수
		int r=sc.nextInt(); //행 위치
		int c=sc.nextInt(); //열 위치
		int d=sc.nextInt(); //보는 방향
		arrays=new int[n][m];

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				arrays[i][j]=sc.nextInt();
			}
		}
		dfs(r,c,d);
		System.out.println(count);
	}

	public static void dfs(int r, int c, int d){
		if(arrays[r][c]==0){
			arrays[r][c]=2; //벽과의 구분을 위해 2
			count++;
		}
		for(int i=0;i<4;i++){
			d=(d+3)%4; //nd 만들어서 기존 d 갱신 못해가지고 틀림
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(arrays[nr][nc]==0) {
				dfs(nr,nc,d);
				return; //중요, 후진 로직이 있으므로 하나 가면 끝내버림
			}
		}
		//다 1이면 종료...가 아님! 후진
		int backDir = (d + 2) % 4;
		int br = r + dr[backDir];
		int bc = c + dc[backDir];
		if(arrays[br][bc] != 1) {
			dfs(br, bc, d);
		}
	}
}
