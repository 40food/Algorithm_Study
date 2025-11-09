import java.util.HashMap;

public class Solution {

    public String[] solution(String[] record){
        HashMap<String,String> set=new HashMap<>();
        int n=record.length;
        int answerCount=0;
        
        String[][] temp=new String[n][3];
        for(int i=0;i<n;i++){
            String[] t=record[i].split(" ");
            temp[i]=t;
            
            String command=temp[i][0];

            if(command.equals("Enter")){
            	set.put(temp[i][1], temp[i][2]);
            	answerCount++;
            }else if(command.equals("Change")) {
            	set.put(temp[i][1], temp[i][2]);
            }else {
            	answerCount++;
            }
        }
        
        String[] answer=new String[answerCount];

        int count=0;
        for(int i=0;i<n;i++){
            if(temp[i][0].equals("Enter")){
                answer[count]=set.get(temp[i][1])+"님이 들어왔습니다.";
                count++;
            }else if(temp[i][0].equals("Leave")){
                answer[count]=set.get(temp[i][1])+"님이 나갔습니다.";
                count++;
            }
        }


        return answer;
    }
}
