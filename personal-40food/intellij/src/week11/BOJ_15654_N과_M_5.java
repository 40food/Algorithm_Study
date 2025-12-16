package week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// deleteChatAt을 빼니 500KB 줄고 30ms 빨라짐

public class BOJ_15654_N과_M_5 {
    static int n;
    static int m;
    static int[] nums;
    static int[] temp;
    static boolean[] visited;
    static ArrayList<String> result;

    public static void main(String[] args) {
        /**
         * 순조부 중에서~~
         * 순열!!
         * 1,2와 2,1을 다른 것으로 본다!
         * 중복은 없음을 감안하고 start
         * */

        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        nums=new int[n];
        temp=new int[m];
        visited=new boolean[n];
        result=new ArrayList<>();
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        /*
        분명 로직은 맞는데 왜 틀렸는가?
        result를 정렬하는 게 아니라 들어온 nums를 정렬해야 한다
        10과 2가 들어왔을 때 전자는 사전 규칙에 따라 10 2를 2 10보다 먼저 놓고
        후자는 그냥 요소의 순서대로 결과에 넣어 2 10을 10 2보다 먼저 놓기 때문

        요점은 문자열이 아니라 숫자를 정렬할 것!
        */
        Arrays.sort(nums);

        permu(0);
        for(String s:result){
            System.out.println(s);
        }
    }

    public static void permu(int depth){
        if(depth==m){
            StringBuilder sb=new StringBuilder();
            for(int t:temp){
                sb.append(t).append(" ");
            }
            result.add(sb.toString());
            return;
        }
        for(int i=0;i<n;i++){
            //방문하지 않았다면 선택하고 depth+1
            //방문했다면 선택하거나 깊이 들어가지 않고 continue해서 넘어감
            if(!visited[i]){
                temp[depth]=nums[i];
                //선택했다면 방문 표시
                visited[i]=true;
                permu(depth+1);
                //배열을 만들고 나왔을 때 방문 초기화
                visited[i]=false;
            }
        }
    }
}
