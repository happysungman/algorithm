package kr.co.programmers.깊이_너비우선탐색.여행경로;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 ICN 공항에서 출발합니다. 항공권 정보가 담긴 2차원 배열 tickets가
 * 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한사항 모든 공항은 알파벳 대문자 3글자로 이루어집니다. 주어진 공항 수는 3개 이상 10,000개 이하입니다. tickets의 각 행
 * [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다. 주어진 항공권은 모두 사용해야 합니다. 만일 가능한 경로가 2개
 * 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다. 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
 *
 * 입출력 예 [[ICN, JFK], [HND, IAD], [JFK, HND]] [ICN, JFK, HND, IAD] [[ICN, SFO],
 * [ICN, ATL], [SFO, ATL], [ATL, ICN], [ATL,SFO]] [ICN, ATL, ICN, SFO, ATL, SFO]
 *
 *
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 */
public class Solution {

	static final String BEGIN = "ICN";
	List<String> routeList = new ArrayList<>();
	
	public String[] solution_dfs(String[][] tickets) {
		String[] answer = {};

		boolean[] used = new boolean[tickets.length];
		
		check(tickets, used, BEGIN, BEGIN);
		
		Collections.sort(routeList);
		answer = routeList.get(0).split(",");
		return answer;
	}
	
	public void check(String[][] tickets, boolean[] used, String from, String route) {
		boolean end = true;
		for (boolean e : used) {
			if (!e) {
				end = false;
				break;
			}
		}
		if (end) {
			this.routeList.add(route);
			return;
		}
		
		for (int i = 0; i < tickets.length; ++i) {
			if (!tickets[i][0].equals(from) || used[i]) continue;	
			String to = tickets[i][1];
			used[i] = true;
			check(tickets, used, to, route + "," + to);
			used[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		System.out.println(s.solution_dfs(tickets ));
	}
}
