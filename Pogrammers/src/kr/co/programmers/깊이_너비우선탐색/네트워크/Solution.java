package kr.co.programmers.깊이_너비우선탐색.네트워크;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	// int[][] computers 의 첫 배열은 컴퓨터, 두 번째 배열은 컴퓨터의 연결 정보
	List<Set<Integer>> networks = new ArrayList<>();

	// 깊이우선탐색이 쉬울듯
	public int solution_dfs(int n, int[][] computers) {

		for (int id = 0; id < n; ++id) {
			// 네트워크에 등록이 되어있나 확인
			Set<Integer> network = getNetwork(id);

			// 깊이우선탐색에서 등록이 되어있다면, 이미 그 망은 완성된 망이다.
			if (network != null) continue;

			Set<Integer> created = new HashSet<>();
			created.add(id);
			networks.add(created);

			for (int computer = 0; computer < n; ++computer) {
				if (id == computer) continue;
				//나와 연결된 id라면, 
				if (computers[id][computer] == 1) {
					addThenSearch(computers, created, computer);
				}
			}

		}

		return networks.size();
	}

	/**
	 * @param computers
	 * @param searchedId
	 */
	public void addThenSearch(int[][] computers, Set<Integer> network, int searchedId) {
		network.add(searchedId);
		int[] networdOfSearchedId = computers[searchedId];
		for (int i = 0; i < networdOfSearchedId.length; ++i) {
			if (i == searchedId || network.contains(i) || computers[searchedId][i] == 0) continue;
			
			// 나와 연결된 컴퓨터들을 추가하고,
			network.add(i);
			
			// 다시 서치
			addThenSearch(computers, network, i);
		}
	}

	public Set<Integer> getNetwork(int id) {
		for (Set<Integer> network : networks) {
			if (network.contains(id)) return network;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(s.solution_dfs(3, computers ));
	}
}
