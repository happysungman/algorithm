package kr.co.programmers.정렬.가장_큰_수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한 사항
 *  numbers의 길이는 1 이상 100,000 이하입니다.
 *  numbers의 원소는 0 이상 1,000 이하입니다.
 *  정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 * 
 * ex) 	[3, 30, 34, 5, 9]	|	[3, 30, 32, 5, 9]
 * 953		9530	9534	|	953		9530	9532
 * 953'34'	95303	9534'3'	|	953'32'	95303	9532'3'
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class Solution {
	
	class NumberString implements Comparable<NumberString> {
		String number;
		
		public NumberString(int number) {
			this.number = Integer.toString(number);
		}

		@Override
		public int compareTo(NumberString o) {
			int n1 = Integer.parseInt(this.number + o.number);
			int n2 = Integer.parseInt(o.number + this.number);
			return Integer.compare(n2, n1);
		}

		@Override
		public String toString() {
			return number;
		}
	}
	
	public String solution(int[] numbers) {
        String answer = "";
        
        List<NumberString> list = new ArrayList<>();
        for (int n : numbers) {
        	list.add(new NumberString(n));
        }
        
        Collections.sort(list);
        if (list.get(0).number.equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
      	for (int i = 0; i < list.size(); ++i) {
      		sb.append(list.get(i).number);
      	}
      	answer = sb.toString();
        return answer;
    }
	
//	public String solution(int[] numbers) {
//        String answer = "";
//        
//        List<NumberString> list = new ArrayList<>();
//        for (int n : numbers) {
//        	list.add(new NumberString(n));
//        }
//        
//        Collections.sort(list);
//        StringBuilder sb = new StringBuilder();
//        for (int i = list.size() - 1; i > -1; --i) {
//        	sb.append(list.get(i).number);
//        }
//        answer = sb.toString();
//        return answer;
//    }
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		int[] numbers = {121, 12, 0, 10};
		System.out.println(s.solution(numbers ));
	}
}
