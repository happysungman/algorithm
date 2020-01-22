package kr.co.programmers.skill_checks.level2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 1�� 0�� ä���� ǥ(board)�� �ֽ��ϴ�. ǥ 1ĭ�� 1 x 1 �� ���簢������ �̷���� �ֽ��ϴ�. 
 * ǥ���� 1�� �̷���� ���� ū ���簢���� ã�� ���̸� return �ϴ� solution �Լ��� �ϼ��� �ּ���. 
 * (��, ���簢���̶� �࿡ ������ ���簢���� ���մϴ�.)
 * 
 * @see https://programmers.co.kr/skill_checks/89131?challenge_id=285
 */
public class Problem2 {
	
	public int solution(int [][]board)
    {

        //x = test �޼ҵ忡�� �¿�� ������
        //y = test �޼ҵ忡�� ���Ϸ� ������
        //board[y][x]���� ���
        int max = 0;
        for (int y = 1; y < board.length; ++y) {
        	for (int x = 1; x < board[y].length; ++x) {
        		if (board[y][x] == 0) continue;
        		int min = Math.min(board[y][x-1], board[y-1][x]);
        		min = Math.min(min, board[y-1][x-1]);
        		board[y][x] = min + 1;
        		//System.out.println(y + "," + x + ":" + board[y][x]);
        		max = Math.max(max, board[y][x]);
            }
        }

        return (int) Math.pow(max, 2);
    }
	
	@Test
	public void test() {
		int[][] board = {{1, 1, 1, 1}, //[0][0] ~ [0][3]
				         {1, 1, 1, 1}, //[1][0] ~ [1][3]
				         {1, 1, 1, 1}, 
				         {0, 0, 1, 0}};
		assertEquals(9, solution(board));
	}
}
