package week9;

import java.util.*;

public class Main2_과제_진행하기 {

	public static void main(String args[]) {
		String[][] sample=new String[][]
				{{"korean", "11:40", "30"},
				{"english", "12:10", "20"},
				{"math", "12:30", "40"}};
		String[][] sample2=new String[][]{
				{"science", "12:40", "50"},
				{"music", "12:20", "40"},
				{"history", "14:00", "30"},
				{"computer", "12:30", "100"}
		};
		String[] result=solution(sample);
		for(String s:result){
			System.out.println(s);
		}
	}

	static public String[] solution(String[][] plans) {
		/*
			1. 배열에서 시작. 꺼내서 배열 다음 것과 비교하여 처리
			2. 다 못 끝내면 stack에 넣음
			3. 다 끝내면 남은 시간동안 stack에 있는 거 처리
			4. 마지막 과제는 무조건 처리
			5. 배열에 있는 거 다 돈 후 남은 stack 다 처리
		* */

		Assignment[] a=new Assignment[plans.length];
		int count=0;
		for(String[] p:plans){
			String name=p[0];
			String[] sTemp=p[1].split(":");
			int start=Integer.parseInt(sTemp[0])*60+Integer.parseInt(sTemp[1]);
			int playtime=Integer.parseInt(p[2]);
			a[count]=new Assignment(name,start,playtime);
			count++;
		}

		Arrays.sort(a, Comparator.comparing(i->i.start));
		Stack<Assignment> delayed=new Stack<Assignment>();
		ArrayList<String> answer = new ArrayList<>();
		
		for(int i=0;i<a.length-1;i++) {
			Assignment now=a[i];
			Assignment next=a[i+1];
			
			// now.start+now.playtime과 next.start 비교
			int gap=now.start+now.playtime-next.start;
			if(gap>0) { //다음 시작시간을 넘어감, stack에 넣어야함
				now.playtime=Math.abs(gap);
				delayed.add(now);
			} else { //다음 과제 전까지 끝남
				answer.add(now.name);
				int leftTime=Math.abs(gap); //남은 시간
				while(leftTime>0&&!delayed.isEmpty()) {
					Assignment temp=delayed.pop();
					int gap2=leftTime-temp.playtime;
					if(gap2>0) {//남은 시간 안에 delayed 과제 끝낸 경우
						answer.add(temp.name);
					}else {//남은 시간 안에 delayed 과제 못 끝낸 경우
						temp.playtime=Math.abs(gap2);
						delayed.add(temp);
						break; //left time 갱신 필요 없음
					}
					leftTime=gap2;
				}
			}
		}
		
		answer.add(a[a.length-1].name);
		
		while(!delayed.isEmpty()) {
			answer.add(delayed.pop().name);
		}

		return answer.toArray(new String[0]);
	}

	static class Assignment {
		String name;
		int start;
		int playtime;
		public Assignment(String n, int s, int p){
			name=n;
			start=s;
			playtime=p;
		}
	}
}
