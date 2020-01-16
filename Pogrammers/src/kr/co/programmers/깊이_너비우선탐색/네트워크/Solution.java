package kr.co.programmers.����_�ʺ�켱Ž��.��Ʈ��ũ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	// int[][] computers �� ù �迭�� ��ǻ��, �� ��° �迭�� ��ǻ���� ���� ����
	List<Set<Integer>> networks = new ArrayList<>();

	// ���̿켱Ž���� �����
	public int solution_dfs(int n, int[][] computers) {

		for (int id = 0; id < n; ++id) {
			// ��Ʈ��ũ�� ����� �Ǿ��ֳ� Ȯ��
			Set<Integer> network = getNetwork(id);

			// ���̿켱Ž������ ����� �Ǿ��ִٸ�, �̹� �� ���� �ϼ��� ���̴�.
			if (network != null) continue;

			Set<Integer> created = new HashSet<>();
			created.add(id);
			networks.add(created);

			for (int computer = 0; computer < n; ++computer) {
				if (id == computer) continue;
				//���� ����� id���, 
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
			
			// ���� ����� ��ǻ�͵��� �߰��ϰ�,
			network.add(i);
			
			// �ٽ� ��ġ
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
