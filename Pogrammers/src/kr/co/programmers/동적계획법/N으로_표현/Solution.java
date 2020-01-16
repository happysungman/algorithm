package kr.co.programmers.������ȹ��.N����_ǥ��;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �Ʒ��� ���� 5�� ��Ģ���길���� 12�� ǥ���� �� �ֽ��ϴ�.
 * 
 * 12 = 5 + 5 + (5 / 5) + (5 / 5)
 * 12 = 55 / 5 + 5 / 5
 * 12 = (55 + 5) / 5
 * 
 * 5�� ����� Ƚ���� ���� 6,5,4 �Դϴ�. �׸��� ���� ���� ���� ���� 4�Դϴ�.
 * ��ó�� ���� N�� number�� �־��� ��, 
 * N�� ��Ģ���길 ����ؼ� ǥ�� �� �� �ִ� ��� �� N ���Ƚ���� �ּڰ��� return �ϵ��� solution �Լ��� �ۼ��ϼ���.
 * 
 * ���ѻ���
 * N�� 1 �̻� 9 �����Դϴ�.
 * number�� 1 �̻� 32,000 �����Դϴ�.
 * ���Ŀ��� ��ȣ�� ��Ģ���길 �����ϸ� ������ ���꿡�� �������� �����մϴ�.
 * �ּڰ��� 8���� ũ�� -1�� return �մϴ�.
 *
 * https://programmers.co.kr/learn/courses/30/lessons/42895
 */

public class Solution {
	enum Type {
		N, ADD, SUB, MUL, DIV
	}
	
	class Node {
		int totalValue;
		Type type;
		int depth;
		
		public Node(int totalValue, Type type, int depth) {
			this.totalValue = totalValue;
			this.type = type;
			this.depth = depth;
		}

		public boolean possibleNext(Type type) {
			//���� ��尡 ���ڸ�, �������� ��� Ÿ�� ����
			if (Type.N.equals(this.type)) return true;
			//���� ��尡 ��Ģ�����̸�, �������� ������ ����
			else if (Type.N.equals(type)) return true;
			return false;
		}
	}
	
	public int solution(int N, int number) {
        int answer = 0;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, Type.N, 1));
        
        Type[] types = {Type.N, Type.ADD, Type.SUB, Type.MUL, Type.DIV};
        
        while (!queue.isEmpty()) {
        	Node current = queue.poll();
        	
        	if (current.totalValue == number) return current.depth;
        	
        	for (int i = 0; i < types.length; ++i) {
        		if (!current.possibleNext(types[i])) continue;
        		
        	}
        }
        return answer;
    }
}
