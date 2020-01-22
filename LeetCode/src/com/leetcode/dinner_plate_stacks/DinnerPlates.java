package com.leetcode.dinner_plate_stacks;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

public class DinnerPlates {

	/**
	 * 
	 */
	List<Stack<Integer>> stacks;
	Queue<Integer> noFullIndex;
	int capacity;
	
    public DinnerPlates(int capacity) {
    	stacks = new ArrayList<>();
    	noFullIndex = new PriorityQueue<>();
    	this.capacity = capacity;
    }
    
    public void push(int val) {
    	Integer index = noFullIndex.poll();
    	
    	Stack<Integer> stack = index == null ? null : stacks.get(index);
    	
        if (stack == null) {
        	stack = new Stack<>();
        	stacks.add(stack);
        	
        	//어짜피 스택에 값을 넣을 것이기 때문에, capacity - 1 만큼 넣음
        	for (int i = 0; i < capacity - 1; ++i) {
        		noFullIndex.offer(stacks.size() - 1);
        	}
        }
        stack.push(val);
    }
    
    public int pop() {
        int index = stacks.size() - 1;
        
        while (0 <= index && stacks.get(index).isEmpty()) {
        	for (int i = 0; i < capacity; ++i) {
        		noFullIndex.remove(index);
        	}
    		stacks.remove(index--);
    	}
        if (stacks.isEmpty()) return -1;

        Stack<Integer> stack = stacks.get(index);
        int result = stack.pop();

        noFullIndex.offer(index);
        return result;
    }
    
    public int popAtStack(int index) {
    	if (stacks.size() <= index) return -1;
    	
    	Stack<Integer> stack = stacks.get(index);
    	int result = stack.isEmpty() ? -1 : stack.pop();
    	
    	noFullIndex.offer(index);
    	
    	return result;
    }
    
    public static void main(String[] args) {
    	DinnerPlates dp = new DinnerPlates(1);
//    	dp.push(1);
//    	dp.push(2);
//    	dp.push(3);
//    	
//    	assertEquals(2, dp.popAtStack(1));
//    	assertEquals(3, dp.pop());
//    	assertEquals(1, dp.pop());
    	
    	dp = new DinnerPlates(2);
    	dp.push(1);
    	dp.push(2);
    	dp.push(3);
    	dp.push(4);
    	dp.push(5);
    	
    	dp.popAtStack(0);
    	dp.push(20);
    	dp.push(21);
    	
    	dp.popAtStack(0);
    	dp.popAtStack(2);
    	dp.pop();
    	dp.pop();
    	dp.pop();
    	dp.pop();
    	dp.pop();
	}
}
