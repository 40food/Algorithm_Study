package week10;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2_15659_N과_M_2 {
    static int n;
    static int m;
    static int[] array;
    static int[] temp;
    static ArrayList<String> result;

    public static void main(String[] args) {
        /*
        * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
            1. 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
            2. 고른 수열은 오름차순이어야 한다.

          * 조합으로 푸는 문제임
          *
          * combination 함수
          * 1. depth와 start를 받는다
          * 2. depth가 뽑을 개수와 같으면 종료
          * 2-1. result에 뽑은 임시 배열값을 넣는다
          * 3. for문을 start부터 원소 개수까지 돌린다
          * 3-1. 임시 배열[depth]에 원소[i]를 넣는다
          * 3-2. depth 증가, i 다음부터 시작
        * */

        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();//원소 수
        m=sc.nextInt();//고를 개수
        array=new int[n];
        for(int i=1;i<=n;i++){
            array[i-1]=i;
        }
        temp=new int[m];
        result=new ArrayList<>();
        combi(0,0);
        for(String s:result){
            System.out.println(s);
        }
    }
    static void combi(int depth, int start){
        if(depth==m){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<m;i++){
                sb.append(temp[i]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        for(int i=start;i<n;i++){
            temp[depth]=array[i];
            combi(depth+1, i+1);
        }
    }
}
