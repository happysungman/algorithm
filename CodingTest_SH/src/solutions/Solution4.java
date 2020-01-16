package solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution4 {

	//책은 사전순으로 수평으로 
	//사전순으로 정렬되 책들의 제목의 첫글자가 모두 주어질 때 바라본 구간에서 제목의 첫 글자로 가장 많이 등장한 알파벳 계산
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] splitedInput = input.split("\\s");
		final int N = Integer.parseInt(splitedInput[0]);
		final int Q = Integer.parseInt(splitedInput[1]);
		
		final String firsts = br.readLine();
		
		List<Integer[]> testCase = new ArrayList<>();
		for (int i = 0; i < Q; ++i) {
			input = br.readLine();
			splitedInput = input.split("\\s");
			final int L = Integer.parseInt(splitedInput[0]);
			final int R = Integer.parseInt(splitedInput[1]);
			Integer[] tmp = {L, R};
			testCase.add(tmp);
		}
		
		for (int i = 0; i < Q; ++i) {
			solution(firsts, testCase.get(i));
		}
	}
	
	public static void solution(String firsts, Integer[] view) {
		String hisView = firsts.substring(view[0] - 1, view[1]);

		Map<String, Integer> result = new HashMap<>();
		
		int count = 0;
		for (int i = 0; i < hisView.length(); ++i) {
			String ch = String.valueOf(hisView.charAt(i));
			int nowCount = 1;
			if (!result.containsKey(ch)) {
				result.put(ch, nowCount);
			}
			else {
				nowCount = result.get(ch) + 1;
				result.replace(ch, nowCount);
				
				if (result.get(ch) > hisView.length() + 1) {
					System.out.println(ch);
					return;
				}
			}
			
			if (count < nowCount) {
				count = nowCount;
			}
		}

		List<String> list = new ArrayList<>();
		for (Entry<String, Integer> e : result.entrySet()) {
			if (count == e.getValue()) {
				list.add(e.getKey());
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}
}
