package week13;

import java.util.*;

public class Main_13335_트럭 {
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
        while(!q.isEmpty()){
            //나가는 거 먼저, 나감과 동시에 들어올 수 있도록
            //무게도 추가로 갱신
            weight-=q.poll();
            if(!trucks.isEmpty() && weight+trucks.peek()<=l){
                int next=trucks.peek();
                if(weight+next<=l) { //최대 하중보다 작거나 같아야 함
                    next=trucks.poll();
                    q.add(next);
                    weight+=next;
                }
                else q.add(0);
            }
            time++;
        }
        System.out.println(time);
    }
}
