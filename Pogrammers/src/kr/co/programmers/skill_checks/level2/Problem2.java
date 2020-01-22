package kr.co.programmers.skill_checks.level2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 
 * 표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. 
 * (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)
 * 
 * @see https://programmers.co.kr/skill_checks/89131?challenge_id=285
 */
public class Problem2 {
	
	public int solution(int [][]board)
    {

        //x = test 메소드에서 좌우로 움직임
        //y = test 메소드에서 상하로 움직임
        //board[y][x]임을 명시
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
