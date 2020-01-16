package solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution3 {

	//미로 풀기
	//R행 C열, o가 적힌 칸은 이동할 수 있는 통로
	//캐릭터는 좌우, 아래로만 이동 가능
	//각 행은 오른쪽으로 한칸 밀기 가능, 행은 맘대로, 안밀수도 있음
	
	//입력 다시
	//S : 출발
	//F : 도착
	//X : 벽
	//O : 통로
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int testCaseNumber = Integer.parseInt(input);

		List<String[][]> testCase = new ArrayList<>();
		
		for (int i = 0; i < testCaseNumber; ++i) {
			input = br.readLine();
			String[] miro = input.split("\\s");
			final int R = Integer.parseInt(miro[0]);
			final int C = Integer.parseInt(miro[1]);
			
			//행 수만큼
			String[][] miroPan = new String[R][C + 1];
			for (int row = 0; row < R; ++row) {
				input = br.readLine();
				for (int col = 0; col < C; ++ col) {
					miroPan[row][col] = String.valueOf(input.charAt(col));
				}
				miroPan[row][C] = "X";
			}
			testCase.add(miroPan);
		}
		
		for (String[][] miro : testCase) {
			solution(miro);
		}
	}

	public static class Node {
		int x;
		int y;
		int depth;
		
		public Node(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
		
		
	}
	
	private static void solution(String[][] miro) {
		int min = 9999;
		boolean isEnd = false;
		
		//미로를 변경 시킨다.
		int rowLength = miro.length;
		int colLength = miro[0].length;
		for (int changed = -1; changed < rowLength; ++changed) {
			if (changed != -1) {
				for (int nowCol = colLength - 1; nowCol > 0; --nowCol) {
					miro[changed][nowCol] = miro[changed][nowCol - 1];
				}
				miro[changed][0] = "X";
			}
			
			//시작
			boolean[][] visit = new boolean[rowLength][colLength];
			Node start = null;
			for (int i = 0; i < colLength; ++i) {
				if ("S".equals(miro[0][i])) {
					start = new Node(0, i, 0);
					
				}
			}
			
			Queue<Node> queue = new LinkedList<>();
			queue.offer(start);
			
			while (!queue.isEmpty()) {
				//꺼내서 끝이면. 미로 변경 후 재시작
				Node now = queue.poll();
				visit[now.x][now.y] = true;
				if ("F".equals(miro[now.x][now.y])) {
					isEnd = true;
					if (now.depth < min) {
						min = now.depth;
						break;
					}
				}

				//우로 고
				if (0 < now.y && !visit[now.x][now.y - 1] && !"X".equals(miro[now.x][now.y-1])) 
					queue.offer(new Node(now.x, now.y - 1, now.depth + 1));
				//좌로
				if (now.y + 1 < colLength && !visit[now.x][now.y + 1] && !"X".equals(miro[now.x][now.y+1])) 
					queue.offer(new Node(now.x, now.y + 1, now.depth + 1));
				//밑
				if (now.x + 1 < rowLength && !visit[now.x + 1][now.y] && !"X".equals(miro[now.x+1][now.y])) 
					queue.offer(new Node(now.x + 1, now.y, now.depth + 1));
			}
		}
		if (isEnd) System.out.println(min);
		else System.out.println(-1);
	}
}
