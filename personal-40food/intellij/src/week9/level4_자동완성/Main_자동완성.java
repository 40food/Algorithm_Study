package week9.level4_자동완성;

import java.util.*;

public class Main_자동완성 {
    class Solution {

        public int solution(String[] words) {

            /*
            바로 옆에 있는 단어들과 얼마나 겹치는 부분이 많은지 확인하고
            그 접두사의 길이만 알면 된다.
            * */

            int answer = 0;
            // 1. 들어온 words를 정렬해 인접한 단어와 접두사가 겹치는 순서대로 정리
            Arrays.sort(words);

            // 2. 각 자동완성에 필요한 최소 타이핑 수를 저장하는 counts 배열 생성
            int[] counts = new int[words.length];

            // 3. 인접한 단어끼리 비교
            for(int i=0 ; i <words.length-1; i++){
                String pre = words[i];
                String next = words[i+1];
                int len = Math.min(pre.length(), next.length());
                // 더 작은 수를 기준으로 어디까지 글자가 똑같나 count
                int sameCount = getSameCount(pre, next, len);
                if (sameCount == len)
                    // 공통 접두사가 둘 중 짧은 단어와 완전히 겹치는 경우
                    // 다 쳐야 파악이 가능하므로 sameCount 입력
                    counts[i] = Math.max(counts[i], sameCount);
                else
                    // 그게 아니면 pre 단어도 same count보다 한 글자만 더 치면 구분 가능
                    counts[i] = Math.max(counts[i], sameCount+1);
                // next 단어도 한 글자만 더 치면 구분 가능
                counts[i+1] = Math.max(counts[i+1], sameCount+1);
                /** 왜 pre는 same count 혹은 same count+1인데
                 *  next는 항상 same count+1인가?
                 *   ==> 정렬을 해버렸기 때문에 same count가 단어와
                 *       완전히 일치하는 경우는 pre에서밖에 안 나온다.
                 *       (go가 gone보다 뒤로 갈 수 없음)
                 * */
                /** next일 때 필요한 count와 pre일 때 필요한 count 중
                 *  더 많은 글자수가 필요한 걸 골라야하기 때문에 Math.max()
                 * */
            }

            for(int c : counts)
                answer+=c;
            return answer;
        }

        static int getSameCount(String pre, String next, int len) {
            int cnt = 0;
            for(int i = 0 ; i < len ; i++){
                if( pre.charAt(i) != next.charAt(i))
                    return cnt;
                cnt++;
            }
            return cnt;
        }
    }
}
