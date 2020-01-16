package kr.co.programmers.����_�ʺ�켱Ž��.�ܾȯ;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * �� ���� �ܾ� begin, target�� �ܾ��� ���� words�� �ֽ��ϴ�. 
 * �Ʒ��� ���� ��Ģ�� �̿��Ͽ� begin���� target���� ��ȯ�ϴ� ���� ª�� ��ȯ ������ ã������ �մϴ�.
 *   1. �� ���� �� ���� ���ĺ��� �ٲ� �� �ֽ��ϴ�.
 *	 2. words�� �ִ� �ܾ�θ� ��ȯ�� �� �ֽ��ϴ�.
 *
 * ���� ��� begin�� hit, target�� cog, words�� 
 * [hot,dot,dog,lot,log,cog]��� hit -> hot -> dot -> dog -> cog�� ���� 4�ܰ踦 ���� ��ȯ�� �� �ֽ��ϴ�.
 * �� ���� �ܾ� begin, target�� �ܾ��� ���� words�� �Ű������� �־��� ��, 
 * �ּ� �� �ܰ��� ������ ���� begin�� target���� ��ȯ�� �� �ִ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * ���ѻ���
 *	�� �ܾ�� ���ĺ� �ҹ��ڷθ� �̷���� �ֽ��ϴ�.
 *	�� �ܾ��� ���̴� 3 �̻� 10 �����̸� ��� �ܾ��� ���̴� �����ϴ�.
 *	words���� 3�� �̻� 50�� ������ �ܾ ������ �ߺ��Ǵ� �ܾ�� �����ϴ�.
 *	begin�� target�� ���� �ʽ��ϴ�.
 *	��ȯ�� �� ���� ��쿡�� 0�� return �մϴ�.
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
		
		//1. ť ����, root ����
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(begin, 0));
		
		while (!queue.isEmpty()) {
			//2. ť���� ���� Ȯ�� 
			Node node = queue.poll();
			
			if (node.word.equals(target)) return node.edge;
			
			//3. Ÿ���� �ƴ϶��, ���� ������ ��� Ȯ��
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

        //1. ť ����, root ����
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        
        int depth = 0;
        Map<Integer, Integer> depthMap = new LinkedHashMap<>();
        depthMap.put(depth, 1);

        while (!queue.isEmpty()) {
        	
        	//2.1 ť���� ���� ���������� Ȯ���� ��ü�� ���� 0�̸�, ť���� ���� ������ ��ü���� �ִ� ��
        	int depthCount = depthMap.get(depth);
            if(depthCount == 0) ++depth;
            
        	//2.2 ť���� ���� 
            String word = queue.poll();
            depthMap.replace(depth, depthMap.get(depth) - 1);
            
            //2.3 ���� �ܾ target���� Ȯ��
            if (target.equals(word)) return depth;
            
            
            
            //3. ���� ���� word�� ã��
            for (int i = 0; i < words.length; ++i) {
            	if (isChecked[i]) continue;
            	int diff = 0;
            	for (int c = 0; c < word.length(); ++c) {
            		if (word.charAt(c) != words[i].charAt(c)) ++diff;
            	}
            	if (diff != 1) continue;
                
                //3.2 ť�� ����
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
