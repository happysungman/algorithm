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
			//가장 작은 수를 찾음
			int min = Arrays.stream(arr).reduce((a, b) -> Math.min(a, b)).getAsInt();
			
			//제외한 나머지 배열을 반환
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
