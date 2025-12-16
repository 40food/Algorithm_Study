package week11;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_15652_N과_M_4 {

    static int n; //원소 수
    static int m; //뽑을 개수
    static int[] nums;
    static ArrayList<String> result;
    static int[] temp;


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        nums=new int[n];
        temp=new int[m];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        result=new ArrayList<>();

        /**
         * 순조부 중에서~~?
         * 자신을 뽑는 게 허용된 조합
         *      순열:서로 다른 n개 중 m개를 뽑음
         *      - 순서가 있으므로 1,2랑 2,1이 다름
         *      조합:서로 다른 n개 중 m개를 순서 없이 뽑음
         *      - 순서가 없으므로 1,2랑 2,1이 같음
         *      부분집합: 집합에 포함된 원소 선택
         *      - 1,2,3 있으면 [1],[1,2],[1,2,3] 등 다 해당
         * */
        combi(0,0);

        for(String r:result){
            System.out.println(r);
        }
    }

    public static void combi(int depth, int start){
        if(depth==m){
            StringBuilder sb=new StringBuilder();
            for(int t:temp){
                sb.append(t).append(" ");
            }
            result.add(sb.toString());
            return;
        }
        for(int i=start;i<n;i++){
            temp[depth]=nums[i];
            //i+1이 아니라 i를 주어 자신을 선택할 가능성 줌
            combi(depth+1,i);
        }
        /*
        * combi를 i가 아니라 start부터하면 당연히 0부터 다시 돌리지
        * start는 하물며 변하는 부분도 없는데
        * */
    }
}
