package kr.co.programmers.������ȹ��.Ÿ��_��Ĺ�;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �뱸 �޼������� � �� ������ �ֱٿ� ���� ���� Ÿ�� ��Ĺ��� ���� �Ǿ���. 
 * Ÿ�� ��Ĺ��� ���簢�� Ÿ���� �ٿ� ���� ���¿��µ�, 
 * �� ���� 1�� ���簢�� Ÿ�Ϻ��� �����Ͽ� ��ġ �޹������� ���� ���ó�� ���� ū Ÿ���� ���� ���¿���. 
 * Ÿ�� ��Ĺ��� �Ϻθ� �׸��� ������ ����.
 * 
 * �׸����� Ÿ�Ͽ� ���� ���� �� Ÿ���� �� ���� ���̸� ��Ÿ����. 
 * Ÿ�� ��Ĺ��� �����ϴ� ���簢�� Ÿ�� �� ���� ���̸� ���� Ÿ�Ϻ��� �����Ͽ� ���ʷ� ������ ������ ����.
 * [1, 1, 2, 3, 5, 8, .]
 * ������ ���� �̷��� Ÿ�ϵ�� �����Ǵ� ū ���簢���� �ѷ��� �ñ�������. 
 * ���� ���, ó�� �ټ� ���� Ÿ���� �����ϴ� ���簢��(������ ���������� ǥ���� ���簢��)�� �ѷ��� 26�̴�.
 * 
 * Ÿ���� ���� N�� �־��� ��, N���� Ÿ�Ϸ� ������ ���簢���� �ѷ��� return �ϵ��� solution �Լ��� �ۼ��Ͻÿ�.
 * 
 * ���� ����
 * N�� 1 �̻� 80 ������ �ڿ����̴�.
 * 
 * ����� ��
 * N	return
 * 5	26
 * 6	42
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/43104
 */

public class Solution {
	class Quadrangle {
		long slength;
		long llength;
		
		public Quadrangle(long slength, long llength) {
			this.slength = slength;
			this.llength = llength;
		}

		public long get() {
			return (slength + llength) * 2;
		}
	}
	
	//�Ǻ���ġ �����̷���..
//	public long solution(int N) {
//        return fibonacci(N);
//    }
//	
//	public int fibonacci(int N) {
//		if (N < 2) return N;
//        return fibonacci(N-1) + fibonacci(N-2);
//	}
	
	//������ ����..
	public long solution(int N) {
        long answer = 0;
        
        //���� ���� ���� �� ���� �𼭸��� ���̷� ���� ���簢���� ��
        //ª�� ���� + ���� ���� ������
        Quadrangle q = new Quadrangle(1, 1);
        if ( N == 1) return q.get(); 
        for (int i = 1; i < N; ++i) {
        	q = new Quadrangle(q.llength, q.llength + q.slength);
        }
        return q.get();
    }
	
	public long solution2(int N) {
        
        long[] lengths = new long[80];
        lengths[0] = 1;
        lengths[1] = 1;
        
        for (int i = 2; i < N; ++i) {
        	lengths[i] = lengths[i-1] + lengths[i-2];
        }
        return N < 2 ? lengths[N-1] * 4 : lengths[N-1] * 4 + lengths[N-2] * 2;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(1));
		System.out.println(s.solution(2));
		System.out.println(s.solution(5));
		System.out.println(s.solution(6));
		System.out.println(s.solution(80));
		
		System.out.println(s.solution2(1));
		System.out.println(s.solution2(2));
		System.out.println(s.solution2(5));
		System.out.println(s.solution2(6));
		System.out.println(s.solution2(80));
	}
}
