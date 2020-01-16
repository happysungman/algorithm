package kr.co.programmers.동적계획법.타일_장식물;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 대구 달성공원에 놀러 온 지수는 최근에 새로 만든 타일 장식물을 보게 되었다. 
 * 타일 장식물은 정사각형 타일을 붙여 만든 형태였는데, 
 * 한 변이 1인 정사각형 타일부터 시작하여 마치 앵무조개의 나선 모양처럼 점점 큰 타일을 붙인 형태였다. 
 * 타일 장식물의 일부를 그리면 다음과 같다.
 * 
 * 그림에서 타일에 적힌 수는 각 타일의 한 변의 길이를 나타낸다. 
 * 타일 장식물을 구성하는 정사각형 타일 한 변의 길이를 안쪽 타일부터 시작하여 차례로 적으면 다음과 같다.
 * [1, 1, 2, 3, 5, 8, .]
 * 지수는 문득 이러한 타일들로 구성되는 큰 직사각형의 둘레가 궁금해졌다. 
 * 예를 들어, 처음 다섯 개의 타일이 구성하는 직사각형(위에서 빨간색으로 표시한 직사각형)의 둘레는 26이다.
 * 
 * 타일의 개수 N이 주어질 때, N개의 타일로 구성된 직사각형의 둘레를 return 하도록 solution 함수를 작성하시오.
 * 
 * 제한 사항
 * N은 1 이상 80 이하인 자연수이다.
 * 
 * 입출력 예
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
	
	//피보나치 수열이랜다..
//	public long solution(int N) {
//        return fibonacci(N);
//    }
//	
//	public int fibonacci(int N) {
//		if (N < 2) return N;
//        return fibonacci(N-1) + fibonacci(N-2);
//	}
	
	//성능이 낮음..
	public long solution(int N) {
        long answer = 0;
        
        //이전 것의 가장 긴 변을 모서리의 길이로 갖는 정사각형이 옴
        //짧은 변과 + 현재 변이 합쳐짐
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
