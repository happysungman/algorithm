package kr.co.programmers.해시.위장;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	
	public static int solution(String[][] clothes) {
		int answer = 1;
        
		Map<String, Set<String>> clothesMap = new HashMap<>();
		for (int i = 0; i < clothes.length; ++i) {
			String name = clothes[i][0];
			String type = clothes[i][1];
			if (!clothesMap.containsKey(type)) {
				clothesMap.put(type, new HashSet<>());
			}
			clothesMap.get(type).add(name);
		}
		
		for (String key : clothesMap.keySet() ) {
			answer *= clothesMap.get(key).size() + 1;
		}
        
        return answer -1;
    }
}
