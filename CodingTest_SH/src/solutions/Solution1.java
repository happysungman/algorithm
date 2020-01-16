package solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1 {

	//첫 줄에는 다섯개의 자연수 N L R B T
	//L < R
	//B < T
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String[] arg = input.split("\\s");
		int N = Integer.parseInt(arg[0]);
		
		//첫 줄을 읽고 N개 라인 더 읽는다.
		int[][] btns = new int[N][2];
		for (int i = 0; i < N; ++i) {
			String in = br.readLine();
			String[] ins = in.split("\\s");
			btns[i][0] = Integer.parseInt(ins[0]);
			btns[i][1] = Integer.parseInt(ins[1]);
		}
		
		
		int total = 0;
		for (int i = 0; i < N; ++i) {
			total += solution(Integer.parseInt(arg[1]), 
					Integer.parseInt(arg[2]), 
					Integer.parseInt(arg[3]), 
					Integer.parseInt(arg[4]),
					btns[i]);
		}
		System.out.println(total);
	}
	
	public static int solution(final int l, final int r, final int b, final int t, final int[] btn) {
		final int x = btn[0];
		final int y = btn[1];
		if (l <= x && x <= r && b <= y && y <= t) return 1;
		return 0;
	}
}
