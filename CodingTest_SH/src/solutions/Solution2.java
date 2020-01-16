package solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {

	//����ڿ��� �ڽŰ� �Բ� �ƴ� ģ���� ���� ������� ģ�� ��õ
	
	//�׽�Ʈ ������� ������ ������� ģ�����谡 �־���.
	//�� ��, ���� ģ���� �ƴϰ� AND �Բ� �ƴ� ģ���� ���� ���� �� ����� ã�°� ����
	//
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1.1 ����
		String input = br.readLine();
		
		//������ ��ǲ
		//System.out.println("Hello Goorm! Your input is " + input);
		
		String[] splitInput = input.split("\\s");
		//2�̻� 100������ �ڿ���
		final int N = Integer.parseInt(splitInput[0]);
		//���� N���� ����� ���� ������ ģ�� ������ �� 1�̻� 5000 ����
		final int M = Integer.parseInt(splitInput[1]);
		
		//1.2 ����
		input = br.readLine();
		String[] names = input.split("\\s");
		
		//1.3 M��ŭ ����
		//����� ģ�����
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
			//ģ����Ͽ� �߰�
			friends.get(people[0]).add(people[1]);
			friends.get(people[1]).add(people[0]);
		}
		
		solution(friends);
	}
	
	public static void solution(final Map<String, Set<String>> friends) {
		//A-B ���� ��, B-A���� �� ���ϵ���
		Set<String> checked = new HashSet<>(); 
		
		Set<String> keySet = friends.keySet();
		
		String[] names = new String[2];
		int max = 0;
		for (String name : keySet) {
			for (String other : keySet) {
				//�ڽ��� ����, ģ���̸� ����
				if (name.equals(other)) continue;
				if (friends.get(name).contains(other)) continue;
				
				//�̹� ���غ� ���̸� ����
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
