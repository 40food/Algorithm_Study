package week9.level3_디스크_컨트롤러;

import java.util.*;

/*
* 뭐지? 전에 풀어본 적 있음
* 근데 다 틀림;;; 일단 백업만
* */
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        /**[요청 시각, 소요시간]
         작업 우선순위
         1. 소요시간이 짧음!!
         2. 요청시각이 빠름!! <이거 먼저로 했어서 틀림
         3. 작업의 번호가 작음
         */
        PriorityQueue<int[]> q=new PriorityQueue<>(
                new Comparator<int[]>(){
                    @Override
                    public int compare(int[] a, int[] b){
                        return Integer.compare(a[1],b[1])==0?
                                Integer.compare(a[0],b[0]):
                                Integer.compare(a[1],b[1]);
                    }
                }
        );
        for(int[] j:jobs){
            q.add(j);
        }

        int size=q.size();
        int now=0;
        while(!q.isEmpty()){
            int[] task=q.poll();
            now+=task[1];
            answer+=now-task[0];
        }
        answer=answer/size;

        //모든 요청 작업의 반환 시간의 평균의 정수 return

        return answer;
    }
}