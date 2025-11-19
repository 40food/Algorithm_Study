package algo_study;

import java.util.*;

public class Main {

	static int set=1;
	static int[] numbers=new int[9];

	public static void main(String args[]) {
		/* 접근
			1. 0~8 사이즈 배열에 1씩 놓고, 6엔 2를 넣는다.
			2. 필요한 숫자를 뽑아 -1을 한다.
			3. 0이라면 모든 판의 숫자를 1씩 늘리고 세트 숫자를 늘린다.
		* */

		addingSet();
		Scanner sc=new Scanner(System.in);
		String[] roomNum=sc.next().split("");
		for(String n:roomNum){
			int temp=Integer.parseInt(n);
			if(temp==9) temp=6;
			if(numbers[temp]<=0) {
				addingSet();
				numbers[temp]--;
				set++;
			}else{
				numbers[temp]--;
			}
		}
		System.out.println(set);
	}

	public static void addingSet(){
		for(int i=0;i<9;i++){
			numbers[i]+=1;
			if(i==6) numbers[i]+=1;
		}
	}
}
