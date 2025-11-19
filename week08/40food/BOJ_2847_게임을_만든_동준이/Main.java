package algo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int answer=0;
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] scores=new int[n];
		for(int i=0;i<n;i++) {
			scores[i]=sc.nextInt();
		}
		
		for(int i=n-1;i>0;i--) {
			if(scores[i]<=scores[i-1]) {
				answer+=(scores[i-1]-scores[i])+1;
				scores[i-1]=scores[i]-1;
			}
		}
		System.out.println(answer);
	}
}
