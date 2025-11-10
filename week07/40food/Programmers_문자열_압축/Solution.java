public class Solution {

    public int solution(String s){
    	//Integer.MAX_VALUE를 할 필요는 없음. 최대는 s의 길이임.
    	//또한, 길이가 1이면 for문이 동작하지 않아서 s 길이 그대로 return해야함.
    	int answer=s.length();
    	
    	//*길이의 절반도 의미 있는 단위임(8이면 4로 비교 가능하듯)
    	for(int i=1;i<=s.length()/2;i++) {
    		StringBuilder sb=new StringBuilder();
    		String prev=s.substring(0,i); //반복 확인 문자열 초기값
    		int count=1; //반복되는 수
    		
    		for(int j=i;j<=s.length();j+=i) {
    			String cur; //지금 비교할 문자열
    			if(j+i<=s.length()) cur=s.substring(j, j+i);
    			else cur=s.substring(j); //*자르는 단위에 안 맞으면 나머지 전부 확인
    			
    			if(cur.equals(prev)) count++; //반복 문자면 카운트 증가하고 *다음 체크로 넘어감
    			else {
    				if(count>1) sb.append(count); //반복 수 추가
    				sb.append(prev); //반복 문자열 추가
    				prev=cur; //새로운 문자열을 반복 문자열로 설정
    				count=1; //count 초기화
    			}
    		}
    		
    		//마지막 문자열 처리 후엔 cur이 같은지 아닌지 비교도 못 하고 반복문 빠져나옴
    		//	prev와 다른 cur을 만나야 sb 갱신하는데 cur도 없이 종료
    		//	따로 기록해줌
    		if(count>1)sb.append(count);
    		sb.append(prev);
    		answer=Math.min(answer, sb.length());
    	}
    	
        return answer;
    }
}
