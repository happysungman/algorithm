package kr.co.programmers.����.K��°��;

import java.util.Arrays;
import java.util.List;

/**
 * �迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, k��°�� �ִ� ���� ���Ϸ� �մϴ�.
 * 
 * ���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��
 *  1. array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�.
 *  2. 1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�.
 *  3. 2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�.
 *  
 * �迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��, 
 * commands�� ��� ���ҿ� ���� �ռ� ������ ������ �������� �� ���� ����� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class Solution {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; ++i) {
        	int sp = commands[i][0] - 1;
        	int ep = commands[i][1];
        	int point = commands[i][2] - 1;
        	
        	int[] sub = Arrays.copyOfRange(array, sp, ep);
        	Arrays.sort(sub);
        	answer[i] = sub[point];
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		s.solution(array , commands );
	}
}
