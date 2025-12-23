package week13;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main2_13335_트럭 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //트럭 수
        int w=sc.nextInt(); //다리 길이
        int l=sc.nextInt(); //다리 최대 하중
        Queue<Integer> trucks=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            trucks.add(sc.nextInt());
        }

        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<w;i++){
            q.add(0);
        }
        int weight=0;
        int time=0;
        /** 조건 변경:
         * 다리가 비지 않았으면
         * -> 트럭이 비지 않았거나 무게가 0보다 크면 */
        while(!trucks.isEmpty() || weight > 0){
            //나가는 거 먼저, 나감과 동시에 들어올 수 있도록
            //무게도 추가로 갱신
            weight-=q.poll();
            /** 조건 변경:
             * 무게가 l보다 작고, 트럭이 비지 않았으면
             * ㄴ예측되는 무게가 l보다 작거나 같으면
             *   /아니면 0 더함
             * -> 예측되는 무게가 l보다 작거나 같고, 트럭이 비지 않았으면
             *    /아니면 0 더함
             * q가 빌 일이 없으므로 while문 조건 변경 필요
             * */
            if(!trucks.isEmpty() && weight+trucks.peek() <= l){
                //최대 하중보다 작거나 같아야 함
                int next=trucks.poll();
                q.add(next);
                weight+=next;
            }else q.add(0);
            time++;
        }
        System.out.println(time);
    }
}
