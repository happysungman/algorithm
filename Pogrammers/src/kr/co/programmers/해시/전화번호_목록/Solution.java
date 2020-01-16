package kr.co.programmers.해시.전화번호_목록;

import java.util.Arrays;

public class Solution {
	// phone_book의 길이는 1 이상 1,000,000 이하입니다.
	// 각 전화번호의 길이는 1 이상 20 이하입니다.
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; ++i) {
        	String pos = phone_book[i];
        	String next = phone_book[i+1];
        	
        	if (next.startsWith(pos)) answer= false;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[] phone_book = {"1", "2", "11", "21"};
		System.out.println(solution(phone_book ));
	}
}
