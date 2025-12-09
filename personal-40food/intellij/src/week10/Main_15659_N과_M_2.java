package week10;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_15659_N과_M_2 {
    static int n;
    static int m;
    static int[] array;
    static ArrayList<String> result;

    public static void main(String[] args) {
        /*
        * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
            1. 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
            2. 고른 수열은 오름차순이어야 한다.

          * 순열 문제임. Permutation 참고 < 아니! 이건 중복이 됨 이거 아님
          * 조합으로 푸는 문제임
          * 10P10도 안전한 swap 방식으로 구현
          * visited boolean 배열 대신 2진 코드 사용
          *
          * permutation 함수
          * 1. depth를 받는다
          * 2. depth가 뽑을 원소 수-1일 때=모든 원소를 swap한 상황(0부터 시작하니 -1)
          * 2-1. result 배열에 입력
          * 3. 개수가 안 되면 for문을 돌려 depth부터 원소 수보다 작을 때까지 반복
          * 3-1. for문의 현재 위치와 depth 위치를 swap해서 새로운 수를 만든다
          * 3-2. permutation 재귀를 돌린다
          * 3-3. swap해서 다시 원래대로 돌리고 다음으로 넘어간다
          * 4. swap은 그냥 입력된 배열 내에서 위치를 교환하면 된다
        * */

        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();//원소 수
        m=sc.nextInt();//고를 개수
        array=new int[n];
        for(int i=1;i<=n;i++){
            array[i-1]=i;
        }
        result=new ArrayList<>();
        permutation(0);
        for(String s:result){
            System.out.println(s);
        }
    }
    static void permutation(int depth){
        if(depth>=m){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<m;i++){
                sb.append(array[i]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        for(int i=depth;i<n;i++){
            swap(i,depth);
            permutation(depth+1);
            swap(i,depth);
        }
    }

    static void swap(int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
