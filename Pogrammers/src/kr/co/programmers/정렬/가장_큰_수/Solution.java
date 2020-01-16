package kr.co.programmers.����.����_ū_��;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 0 �Ǵ� ���� ������ �־����� ��, ������ �̾� �ٿ� ���� �� �ִ� ���� ū ���� �˾Ƴ� �ּ���.
 * ���� ���, �־��� ������ [6, 10, 2]��� [6102, 6210, 1062, 1026, 2610, 2106]�� ���� �� �ְ�, ���� ���� ū ���� 6210�Դϴ�.
 * 0 �Ǵ� ���� ������ ��� �迭 numbers�� �Ű������� �־��� ��, ������ ���ġ�Ͽ� ���� �� �ִ� ���� ū ���� ���ڿ��� �ٲپ� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * ���� ����
 *  numbers�� ���̴� 1 �̻� 100,000 �����Դϴ�.
 *  numbers�� ���Ҵ� 0 �̻� 1,000 �����Դϴ�.
 *  ������ �ʹ� Ŭ �� ������ ���ڿ��� �ٲپ� return �մϴ�.
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
