package kr.co.programmers.skill_checks.level1;

import java.util.Scanner;

public class Solution88908_challenge_id1988 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a; ++i) {
        	sb.append("*"); 
        } 
        for(int i = 0; i < b; ++i) {
        	System.out.println(sb.toString()); 
        }
    }
}
