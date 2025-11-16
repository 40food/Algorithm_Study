import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> uniqueReports = new HashSet<>(Arrays.asList(report));
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, Set<String>> reportMap = new HashMap<>();

        for(String id : id_list){
            reportMap.put(id, new HashSet<>());
        }

        for(String rep : uniqueReports){
            String[] parts = rep.split(" ");
            String reporter = parts[0];
            String reported = parts[1];

            reportMap.get(reporter).add(reported);
            reportCount.put(reported, reportCount.getOrDefault(reported, 0) + 1);
        }

        Set<String> suspended = new HashSet<>();
        for(Map.Entry<String, Integer> entry : reportCount.entrySet()){
            if(entry.getValue() >= k){
                suspended.add(entry.getKey());
            }
        }
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++){
            String user = id_list[i];
            for(String r : reportMap.get(user)){
                if(suspended.contains(r)){
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}