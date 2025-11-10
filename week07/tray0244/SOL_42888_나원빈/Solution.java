import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> userMap = new HashMap<>();
        List<String> actions = new ArrayList<>();

        for(String rec : record){
            String[] parts = rec.split(" ");
            String action = parts[0];
            String userId = parts[1];

            if(action.equals("Enter")){
                String nickname = parts[2];
                userMap.put(userId, nickname);
                actions.add(userId + "님이 들어왔습니다.");
            }else if(action.equals("Leave")){
                actions.add(userId + "님이 나갔습니다.");
            }else if(action.equals("Change")){
                String nickname = parts[2];
                userMap.put(userId, nickname);
            }
        }
        answer = new String[actions.size()];
        for(int i = 0; i < actions.size(); i++){
            String action = actions.get(i);
            String userId = action.split("님")[0];
            answer[i] = userMap.get(userId) + action.substring(action.indexOf("님"));
        }
        return answer;
    }
}
