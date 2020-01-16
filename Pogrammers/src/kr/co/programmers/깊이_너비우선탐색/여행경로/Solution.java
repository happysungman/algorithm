package kr.co.programmers.����_�ʺ�켱Ž��.������;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * �־��� �װ����� ��� �̿��Ͽ� �����θ� ¥���� �մϴ�. �׻� ICN ���׿��� ����մϴ�. �װ��� ������ ��� 2���� �迭 tickets��
 * �Ű������� �־��� ��, �湮�ϴ� ���� ��θ� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * ���ѻ��� ��� ������ ���ĺ� �빮�� 3���ڷ� �̷�����ϴ�. �־��� ���� ���� 3�� �̻� 10,000�� �����Դϴ�. tickets�� �� ��
 * [a, b]�� a ���׿��� b �������� ���� �װ����� �ִٴ� �ǹ��Դϴ�. �־��� �װ����� ��� ����ؾ� �մϴ�. ���� ������ ��ΰ� 2��
 * �̻��� ��� ���ĺ� ������ �ռ��� ��θ� return �մϴ�. ��� ���ø� �湮�� �� ���� ���� �־����� �ʽ��ϴ�.
 *
 * ����� �� [[ICN, JFK], [HND, IAD], [JFK, HND]] [ICN, JFK, HND, IAD] [[ICN, SFO],
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
