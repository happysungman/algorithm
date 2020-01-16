package com.leetcode.reverse_string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution {
	public void reverseString(char[] s) {
        foo(s, s.length-1);
    }
    
    public void foo(char[] s, int idx) {
        if (idx <= ((s.length-1) / 2)) return;
    	
        char c = s[idx];
        s[idx] = s[s.length -1 - idx];
        s[s.length -1 - idx] = c;
        foo(s, --idx);
    }
    
    @Test
    public void test() {
    	String s = "hello";
    	char[] input = s.toCharArray();
    	reverseString(input);
    	System.out.println(input);
    	assertEquals("olleh", String.valueOf(input));
    }
}
