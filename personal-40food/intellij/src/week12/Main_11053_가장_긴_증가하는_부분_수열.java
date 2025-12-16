package week12;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11053_가장_긴_증가하는_부분_수열 {
    /*
    * 1. 배열 정렬
    * 2. 돌면서 같은 수면 스킵
    * 3. 더 큰 수면 count 증가
     * */

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Arrays.sort(nums);
        int prev=0;
        int count=0;
        for(int num:nums){
            if(num>prev) count++;
            prev=num;
        }
        System.out.println(count);
    }
}
