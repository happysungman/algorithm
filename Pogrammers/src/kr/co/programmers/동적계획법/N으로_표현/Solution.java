package kr.co.programmers.동적계획법.N으로_표현;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
 * 
 * 12 = 5 + 5 + (5 / 5) + (5 / 5)
 * 12 = 55 / 5 + 5 / 5
 * 12 = (55 + 5) / 5
 * 
 * 5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
 * 이처럼 숫자 N과 number가 주어질 때, 
 * N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.
 * 
 * 제한사항
 * N은 1 이상 9 이하입니다.
 * number는 1 이상 32,000 이하입니다.
 * 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
 * 최솟값이 8보다 크면 -1을 return 합니다.
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
			//현재 노드가 숫자면, 다음에는 모든 타입 가능
			if (Type.N.equals(this.type)) return true;
			//현재 노드가 사칙연산이면, 다음에는 무조건 숫자
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
