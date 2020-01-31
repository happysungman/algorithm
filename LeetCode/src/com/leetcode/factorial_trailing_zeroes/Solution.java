package com.leetcode.factorial_trailing_zeroes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 *
 */
public class Solution {

	//zero = 10 = 2 * 5 ÇÑ ½Ö
	public int trailingZeroes(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}
	
	@Test
	public void test() {
		assertEquals(0, trailingZeroes(3));
		assertEquals(1, trailingZeroes(5));
		assertEquals(2, trailingZeroes(11));
		assertEquals(4, trailingZeroes(20));
		assertEquals(6, trailingZeroes(25));
		assertEquals(452137076, trailingZeroes(1808548329));
	}
}
