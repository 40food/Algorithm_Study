package week12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11725_트리의_부모_찾기 {

    /*
    * 부모 찾기
    * 유니온 파인드인가(집합 관리에서 푸는 문제라곤 하지만)
    * 했는데 구현 과정을 보니 집합의 대표 노드(임의의 기준점)을 찾는거지
    * 위에 연결된 단 하나의 노드(부모 노드)를 찾는 게 아님
    *
    * 부모 노드 출력은 DFS/BFS
    * n이 최대 100,000이라 오버플로우 위험 있음(depth가 10,000만 되어도 위험)
    * 웬만하면 BFS로 푸는 게 좋을듯
    * */

    static int n; //노드 수
    static int[] parent; //부모 배열
    static boolean[] visited; //방문 체크

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        //인접 리스트 생성
        // 0 생략하고 1부터 시작해서 n+1
        ArrayList<Integer>[] graph=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        parent=new int[n+1];
        visited=new boolean[n+1];

        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        visited[1]=true;

        while(!q.isEmpty()){
            int cur=q.poll();
            for(int next:graph[cur]){
                if(!visited[next]){
                    visited[next]=true;
                    parent[next]=cur;
                    q.add(next);
                }
            }
        }

        for(int i=2;i<=n;i++){
            System.out.println(parent[i]);
        }

    }
}
