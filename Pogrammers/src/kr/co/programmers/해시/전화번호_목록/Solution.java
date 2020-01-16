package kr.co.programmers.�ؽ�.��ȭ��ȣ_���;

import java.util.Arrays;

public class Solution {
	// phone_book�� ���̴� 1 �̻� 1,000,000 �����Դϴ�.
	// �� ��ȭ��ȣ�� ���̴� 1 �̻� 20 �����Դϴ�.
	
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
