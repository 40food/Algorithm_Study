package week12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main2_1461_도서관 {
    /*
     * 정렬...을... 쓰는 걸까 싶음
     * 1. 책을 오름차순으로 정렬
     * 2. 가장 작은 것부터 0까지 m개씩 들고가 배치
     * 3. 가장 큰 것부터 0까지 m개씩 들고가 배치
     * 4. 총 걸린 걸음 수를 절대값으로 더한다.
     * */
    /**
     * 거의 잘 했다만은
     * 1. 왕복거리를 계산해야 함
     * 2. 마지막 책은 왕복하지 않아도 좋음
     * 이걸 고려해서 수정
     *
     * 1. 처음부터 왼쪽과 오른쪽을 나눠서 저장
     * 2. 거리 순으로 내림차순 정렬
     * 3. 큰 거리부터 m개씩 묶는다
     *      왜 내림차순을 하고 m개씩 묶는가?
     *      39+37(2포함)보다 39(37포함)+2가 더 작으니까
     * 4. 묶음을 모두 2배해서 더함
     * 5. 가장 큰 묶음을 뺌
     * */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<Integer> plus_books=new ArrayList<>();
        ArrayList<Integer> minus_books=new ArrayList<>();
        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            if(temp>0) plus_books.add(Math.abs(temp));
            else minus_books.add(Math.abs(temp));
        }

        plus_books.sort(Comparator.reverseOrder());
        minus_books.sort(Comparator.reverseOrder());
        resultSet=new ArrayList<>();

        union(m, plus_books);
        union(m, minus_books);

        int result=0;
        int max=0;
        for(int r:resultSet){
            result+=r*2;
            if(r>max) max=r;
        }

        System.out.println(result-max);
    }

    static ArrayList<Integer> resultSet;

    private static void union(int m, ArrayList<Integer> books) {
        for(int i=0;i<books.size();i++){
            int bring=0;
            for (int j=0;j<m;j++){
                if(i+j<books.size())bring++;
                else break;
            }
            resultSet.add(books.get(i));
            i+=bring-1;
        }
    }
}
