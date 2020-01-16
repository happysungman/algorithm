package solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {

	//사용자에게 자신과 함께 아는 친구가 많은 순서대로 친구 추천
	
	//테스트 대상으로 선정된 사람들의 친구관계가 주어짐.
	//이 때, 서로 친구가 아니고 AND 함께 아는 친구가 가장 많은 두 사람을 찾는게 문제
	//
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1.1 라인
		String input = br.readLine();
		
		//디버깅용 인풋
		//System.out.println("Hello Goorm! Your input is " + input);
		
		String[] splitInput = input.split("\\s");
		//2이상 100이하의 자연수
		final int N = Integer.parseInt(splitInput[0]);
		//현재 N명의 사람들 간에 성립된 친구 관계의 수 1이상 5000 이하
		final int M = Integer.parseInt(splitInput[1]);
		
		//1.2 라인
		input = br.readLine();
		String[] names = input.split("\\s");
		
		//1.3 M만큼 관계
		//사람의 친구목록
		Map<String, Set<String>> friends = new HashMap<>();
		for (int i = 0; i < M; ++i) {
			input = br.readLine();
			String[] people = input.split("\\s");
			if (!friends.containsKey(people[0])) {
				Set<String> set = new HashSet<>();
				friends.put(people[0], set);
			}
			if (!friends.containsKey(people[1])) {
				Set<String> set = new HashSet<>();
				friends.put(people[1], set);
			}
			//친구목록에 추가
			friends.get(people[0]).add(people[1]);
			friends.get(people[1]).add(people[0]);
		}
		
		solution(friends);
	}
	
	public static void solution(final Map<String, Set<String>> friends) {
		//A-B 관계 비교, B-A관계 비교 안하도록
		Set<String> checked = new HashSet<>(); 
		
		Set<String> keySet = friends.keySet();
		
		String[] names = new String[2];
		int max = 0;
		for (String name : keySet) {
			for (String other : keySet) {
				//자신은 제외, 친구이면 제외
				if (name.equals(other)) continue;
				if (friends.get(name).contains(other)) continue;
				
				//이미 비교해본 것이면 제외
				if (checked.contains(name + "\t" + other) || checked.contains(other + "\t" + name))
					continue;
				
				checked.add(name + "\t" + other);
				Set<String> nameFriends = friends.get(name);
				Set<String> otherFriends = friends.get(other);
				
				int count = 0;
				for (String otherFriend : otherFriends) {
					if (nameFriends.contains(otherFriend)) ++count;
				}
				
				if (max < count) {
					if (name.compareTo(other) < 0) {
						names[0] = name;
						names[1] = other;
					} else {
						names[1] = name;
						names[0] = other;
					}
					max = count;
				}
			}
		}
		System.out.println(names[0] + " " + names[1]);
		System.out.println(max);
	}
}
