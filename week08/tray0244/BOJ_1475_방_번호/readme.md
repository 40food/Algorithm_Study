### 푼 문제: 방 번호

- https://www.acmicpc.net/problem/1475

---

### 해설

- 한 세트에 0번에서 9번까지 숫자가 하나씩 들어있다.
- 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오
- 6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용 가능

### 코드

```java
import java.util.*;
import java.io.*;

class Main {
    static int[] number;
    // static boolean[] num; // 이건 이제 안 쓰니 지웁시다!
    
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
```

---