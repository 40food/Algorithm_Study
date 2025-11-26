package week9.level3_디스크_컨트롤러;

import java.util.PriorityQueue;

public class Main2_디스크_컨트롤러 {
    /* 우선순위
        1. 소요시간이 가장 짧은 작업
        2. 요청 시각이 빠른 작업(먼저 들어온 거)
        3. 작업 번호가 작은 작업

        작업은 시작하면 반드시 끝까지 수행

        데이터가 많으면!
        데이터를 정렬하고 필요한 만큼 꺼내쓰는게 효율적일 수도 있음

        하지만 이건 500개 이하라 적음!
        그래서 정렬이 없고 반복문 돌리면서 필요한 거 꺼냄
    * */

    class Solution{
        public int solution(int[][] jobs){
            int answer=0;
            int now=0; //현 시간
            int count=0; //수행한 프로세스 수
            int end=-1; //마지막 작업이 끝난 시각

            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

            while(count< jobs.length){
                for(int[] job:jobs){
                    if(end<job[0]&&job[0]<=now)
                        pq.offer(new int[]{job[0],job[1]});
                }
                if(!pq.isEmpty()){
                    int[] current=pq.poll();
                    end=now;
                    now+=current[1];
                    answer+=now-current[0]; //현재시간-시작시간
                    count++;
                }
                else now++;
            }

            return answer/jobs.length;
        }
    }
}
