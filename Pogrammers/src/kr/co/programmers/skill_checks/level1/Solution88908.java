package kr.co.programmers.skill_checks.level1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Solution88908 {
	public int[] solution(int[] arr) {
		int[] answer = {};

		if(arr.length <= 1) {
			answer = new int[] {-1};
		} else {
			//���� ���� ���� ã��
			int min = Arrays.stream(arr).reduce((a, b) -> Math.min(a, b)).getAsInt();
			
			//������ ������ �迭�� ��ȯ
			answer = new int[arr.length - 1];
			int pos =0;
			for (int i = 0; i < arr.length; ++i) {
				if (arr[i] == min) continue;
				answer[pos++] = arr[i];
			}
		}
		
		return answer;
	}
	
	@Test
	public void test() {
		int[] arr = {};
		assertEquals(-1, solution(arr)[0]);
		
		arr = new int[] {4, 3, 2, 1};
		assertEquals(4, solution(arr)[0]);
		assertEquals(3, solution(arr)[1]);
		assertEquals(2, solution(arr)[2]);
	}
}
