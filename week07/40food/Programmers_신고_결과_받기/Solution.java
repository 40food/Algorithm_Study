import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
    	int n=id_list.length;
        int[] answer = new int[n];
        
        HashSet<String> reports=new HashSet<>();
        for(int i=0;i<report.length;i++) {
        	reports.add(report[i]);
        }
        
        HashMap<String,Integer> reported=new HashMap<>();
        for(String s:reports) {
        	String[] temp=s.split(" ");
        	reported.put(temp[1],reported.getOrDefault(temp[1],0)+1);
        }
        
        HashMap<String,Integer> result=new HashMap<>();
        for(String s:reports) {
        	String[] temp=s.split(" ");
        	if(reported.get(temp[1])>=k) {
        		result.put(temp[0],result.getOrDefault(temp[0], 0)+1);
        	}
        }
        
        for(int i=0;i<id_list.length;i++) {
        	answer[i]=result.getOrDefault(id_list[i],0);
        }
        
        return answer;
    }
}