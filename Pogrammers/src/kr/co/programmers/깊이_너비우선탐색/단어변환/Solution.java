package kr.co.programmers.깊이_너비우선탐색.단어변환;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 
 * 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 *   1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
 *	 2. words에 있는 단어로만 변환할 수 있습니다.
 *
 * 예를 들어 begin이 hit, target가 cog, words가 
 * [hot,dot,dog,lot,log,cog]라면 hit -> hot -> dot -> dog -> cog와 같이 4단계를 거쳐 변환할 수 있습니다.
 * 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 
 * 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한사항
 *	각 단어는 알파벳 소문자로만 이루어져 있습니다.
 *	각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
 *	words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
 *	begin과 target은 같지 않습니다.
 *	변환할 수 없는 경우에는 0를 return 합니다.
 *
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 */
public class Solution {

	class Node {
		String word;
		int edge;
		
		public Node(String word, int edge) {
			this.word = word;
			this.edge = edge;
		}
	}
	
	public int solution_node(String begin, String target, String[] words) {
		int answer = 0;
		
		boolean[] visit = new boolean[words.length];
		
		//1. 큐 생성, root 삽입
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(begin, 0));
		
		while (!queue.isEmpty()) {
			//2. 큐에서 빼서 확인 
			Node node = queue.poll();
			
			if (node.word.equals(target)) return node.edge;
			
			//3. 타겟이 아니라면, 다음 뎁스의 노드 확인
			for (int i = 0; i < words.length; ++i) {
				if (visit[i]) continue;
				int diff = 0;
            	for (int c = 0; c < node.word.length(); ++c) {
            		if (node.word.charAt(c) != words[i].charAt(c)) ++diff;
            	}
            	
            	if (diff != 1) continue;
            	queue.add(new Node(words[i], node.edge + 1));
            	visit[i] = true;
			}
		}
		
		return answer;
	}
	
	//bfs
	public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean isChecked[] = new boolean[words.length];

        //1. 큐 생성, root 삽입
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        
        int depth = 0;
        Map<Integer, Integer> depthMap = new LinkedHashMap<>();
        depthMap.put(depth, 1);

        while (!queue.isEmpty()) {
        	
        	//2.1 큐에서 현재 뎁스에서의 확인할 객체의 수가 0이면, 큐에는 다음 뎁스의 객체들이 있는 것
        	int depthCount = depthMap.get(depth);
            if(depthCount == 0) ++depth;
            
        	//2.2 큐에서 빼서 
            String word = queue.poll();
            depthMap.replace(depth, depthMap.get(depth) - 1);
            
            //2.3 현재 단어가 target인지 확인
            if (target.equals(word)) return depth;
            
            
            
            //3. 다음 뎁스 word를 찾음
            for (int i = 0; i < words.length; ++i) {
            	if (isChecked[i]) continue;
            	int diff = 0;
            	for (int c = 0; c < word.length(); ++c) {
            		if (word.charAt(c) != words[i].charAt(c)) ++diff;
            	}
            	if (diff != 1) continue;
                
                //3.2 큐에 담음
                queue.offer(words[i]);
            	isChecked[i] = true;
            	
            	if (depthMap.containsKey(depth+1)) depthMap.replace(depth+1, depthMap.get(depth+1) + 1);
            	else depthMap.put(depth+1, 1);
            }
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
		System.out.println(s.solution_node("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
	}
	
	//public static findNextString(String word, String[] words)
}
