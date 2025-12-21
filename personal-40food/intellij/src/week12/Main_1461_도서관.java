package week12;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1461_도서관 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] books=new int[n];
        int point=Integer.MAX_VALUE; //0에 가까운 양수값
        for(int i=0;i<n;i++){
            books[i]=sc.nextInt();
            if(books[i]<point&&books[i]>0) point=books[i];//i는 넣어봤자 sort되어서 안먹힘
        }

        /*
        * 정렬...을... 쓰는 걸까 싶음
        * 1. 책을 오름차순으로 정렬
        * 2. 가장 작은 것부터 0까지 m개씩 들고가 배치
        * 3. 가장 큰 것부터 0까지 m개씩 들고가 배치
        * 4. 총 걸린 걸음 수를 절대값으로 더한다.
        * */

        Arrays.sort(books);
        //point 값을 0에 가장 가까운 양수의 index값으로 수정
        point=Arrays.binarySearch(books,point);

        int result=0;

        //책의 위치가 마이너스
        for(int i=0;i<point;i++){
            int bring=0; //들고있는 책 수
            for(int j=0;j<m;j++){
                if(books[i+j]<0) bring++;
                else break;
            }
            result+=Math.abs(books[i]);
            i+=bring-1;//i++분량 제외
        }
        //책의 위치가 플러스
        for(int i=n-1;i>=point;i--){
            int bring=0;
            for(int j=0;j<m;j++){
                if(books[i-j]>0) bring++;
                else break;
            }
            result+=Math.abs(books[i]);
            i-=bring+1;
        }

        System.out.println(result);
    }
}
