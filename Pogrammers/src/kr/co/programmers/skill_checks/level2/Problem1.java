package kr.co.programmers.skill_checks.level2;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * OO 연구소는 한 번에 K 칸을 앞으로 점프하거나, (현재까지 온 거리) x 2 에 해당하는 위치로 순간이동을 할 수 있는 
 * 특수한 기능을 가진 아이언 슈트를 개발하여 판매하고 있습니다. 
 * 이 아이언 슈트는 건전지로 작동되는데, 순간이동을 하면 건전지 사용량이 줄지 않지만, 앞으로 K 칸을 점프하면 K 만큼의 건전지 사용량이 듭니다. 
 * 그러므로 아이언 슈트를 착용하고 이동할 때는 순간 이동을 하는 것이 더 효율적입니다. 
 * 아이언 슈트 구매자는 아이언 슈트를 착용하고 거리가 N 만큼 떨어져 있는 장소로 가려고 합니다. 
 * 단, 건전지 사용량을 줄이기 위해 점프로 이동하는 것은 최소로 하려고 합니다. 
 * 아이언 슈트 구매자가 이동하려는 거리 N이 주어졌을 때, 사용해야 하는 건전지 사용량의 최솟값을 return하는 solution 함수를 만들어 주세요.
 * 
 * @see https://programmers.co.kr/skill_checks/89131
 */
public class Problem1 {
	
	class Ironman {
		int point;
		int battery;
		
		public Ironman(int point, int battery) {
			this.point = point;
			this.battery = battery;
		}
		
	}
	
	public int solution(int n) {
		int answer = -1;

		Queue<Ironman> queue = new LinkedList<>();
		queue.offer(new Ironman(0, 0));
		
		while (!queue.isEmpty()) {
			Ironman man = queue.poll();
			
			//1.1 도착지점에 도달했으면
			if (man.point == n) {
				answer = man.battery;
				break;
			}
			//1.2 넘어 섰으면
			if (n < man.point) continue;
			
			//2.1 온 만큼 2개 점프
			if (man.point != 0) 
			  queue.offer(new Ironman(man.point*2, man.battery));
			//2.2 K칸 앞으로 가거나,
			//    K칸 앞으로 가는 것은 1칸 앞으로 가는 것으로 쪼갤 수 있음
			queue.offer(new Ironman(man.point + 1, man.battery + 1));
		}

		return answer;
	}
	
	@Test
	public void test() {
		assertEquals(0, solution(0));
		assertEquals(2, solution(5));
		assertEquals(2, solution(6));
		assertEquals(5, solution(5000));
	}
}
