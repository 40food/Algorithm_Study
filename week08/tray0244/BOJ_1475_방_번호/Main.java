import java.util.*;
import java.io.*;

class Main {
    static int[] number;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        number = new int[10];

        for(int i = 0; i < N.length(); i++){
            int n = N.charAt(i) - '0';
            number[n]++;
        }
        int sum69 = number[6] + number[9];

        int count69 = (sum69 + 1) / 2;

        number[6] = count69;
        number[9] = count69;

        int max = 0;
        for(int i = 0; i < 10; i++){
            if(number[i] > max){
                max = number[i];
            }
        }
        System.out.println(max);
    }
}