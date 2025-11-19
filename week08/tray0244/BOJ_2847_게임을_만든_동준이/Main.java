import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] arr;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        count = 0;
        for(int i = N - 1; i > 0; i--){
            if(arr[i] <= arr[i - 1]){
                int diff = arr[i - 1] - (arr[i] - 1);
                count += diff;
                arr[i - 1] = arr[i] - 1;
            }
        }

        System.out.println(count);
    }
}