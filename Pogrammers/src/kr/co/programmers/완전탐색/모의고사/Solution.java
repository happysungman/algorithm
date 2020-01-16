package kr.co.programmers.완전탐색.모의고사;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	int[] first = {1,2,3,4,5};
	int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
	int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	
	public int[] solution(int[] answers) {
        int[] answer = {};
        
        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;
        for (int i = 0; i < answers.length; ++i) {
        	if (answers[i] == first[i % first.length]) ++firstCount;
        	if (answers[i] == second[i % second.length]) ++secondCount;
        	if (answers[i] == third[i % third.length]) ++thirdCount;
        }
        
        int subMax = Math.max(firstCount, secondCount);
        int max = Math.max(subMax, thirdCount);
        
        List<Integer> maxer = new ArrayList<>();
        if (firstCount == max) maxer.add(1);
        if (secondCount == max) maxer.add(2);
        if (thirdCount == max) maxer.add(3);
		
        answer = new int[maxer.size()];
        for (int i = 0; i < maxer.size(); ++i) {
        	answer[i] = maxer.get(i);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(0 % 5);
		System.out.println(2 % 5);
		System.out.println(6 % 5);
	}
}
