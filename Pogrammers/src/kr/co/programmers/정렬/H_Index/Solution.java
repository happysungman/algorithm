package kr.co.programmers.����.H_Index;

import java.util.Arrays;

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
	
	public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        //int pivot = citations.length / 2;
        
        int maxH = 0;
        for (int h = 1; h < citations.length + 1; ++h) {
        	int paperCount = 0;
        	
        	for (int j = 0; j < citations.length; ++j) {
        		if (h <= citations[j]) ++paperCount;
        	}
        	
        	if (h <= paperCount && citations.length - paperCount <= h) {
        		maxH = maxH < h ? h : maxH;
        	} else {
        		break;
        	}
        }
        answer = maxH;
        return answer;
    }
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		int[] numbers = {1000, 1000, 1000, 1000, 4};
		System.out.println(s.solution(numbers ));
	}
}
