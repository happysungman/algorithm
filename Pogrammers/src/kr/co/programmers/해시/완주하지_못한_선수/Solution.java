package kr.co.programmers.해시.완주하지_못한_선수;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
	
	public String solution1(String[] participant, String[] completion) {
        String word = null;
        
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; ++i) {
        	if (participant[i].equals(completion[i])) continue;
        	word = participant[i];
        	break;
        }
        return word == null ? participant[participant.length-1] : word;
    }
	
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		Solution s = new Solution();
		System.out.println(s.solution(participant, completion));
	}
}
