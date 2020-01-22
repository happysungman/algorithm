package kr.co.programmers.skill_checks.level2;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * OO �����Ҵ� �� ���� K ĭ�� ������ �����ϰų�, (������� �� �Ÿ�) x 2 �� �ش��ϴ� ��ġ�� �����̵��� �� �� �ִ� 
 * Ư���� ����� ���� ���̾� ��Ʈ�� �����Ͽ� �Ǹ��ϰ� �ֽ��ϴ�. 
 * �� ���̾� ��Ʈ�� �������� �۵��Ǵµ�, �����̵��� �ϸ� ������ ��뷮�� ���� ������, ������ K ĭ�� �����ϸ� K ��ŭ�� ������ ��뷮�� ��ϴ�. 
 * �׷��Ƿ� ���̾� ��Ʈ�� �����ϰ� �̵��� ���� ���� �̵��� �ϴ� ���� �� ȿ�����Դϴ�. 
 * ���̾� ��Ʈ �����ڴ� ���̾� ��Ʈ�� �����ϰ� �Ÿ��� N ��ŭ ������ �ִ� ��ҷ� ������ �մϴ�. 
 * ��, ������ ��뷮�� ���̱� ���� ������ �̵��ϴ� ���� �ּҷ� �Ϸ��� �մϴ�. 
 * ���̾� ��Ʈ �����ڰ� �̵��Ϸ��� �Ÿ� N�� �־����� ��, ����ؾ� �ϴ� ������ ��뷮�� �ּڰ��� return�ϴ� solution �Լ��� ����� �ּ���.
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
			
			//1.1 ���������� ����������
			if (man.point == n) {
				answer = man.battery;
				break;
			}
			//1.2 �Ѿ� ������
			if (n < man.point) continue;
			
			//2.1 �� ��ŭ 2�� ����
			if (man.point != 0) 
			  queue.offer(new Ironman(man.point*2, man.battery));
			//2.2 Kĭ ������ ���ų�,
			//    Kĭ ������ ���� ���� 1ĭ ������ ���� ������ �ɰ� �� ����
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
