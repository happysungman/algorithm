package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class DinnerPlates {

	/**
	 * 
	 */
	List<Stack<Integer>> stacks;
	Set<Integer> noFullIndex;
	int capacity;
	
    public DinnerPlates(int capacity) {
    	stacks = new ArrayList<>();
    	this.capacity = capacity;
    	noFullIndex = new TreeSet<>();
    }
    
    public void push(int val) {
    	int index = -1;
    	for (int idx : noFullIndex) {
    		index = idx;
    		break;
    	}
    	
    	Stack<Integer> stack = index == -1 ? null : stacks.get(index);
    	
        if (stack == null) {
        	stack = new Stack<>();
        	stacks.add(stack);
        	noFullIndex.add(stacks.size() - 1);
        	index = stacks.size() - 1;
        }
        stack.push(val);
        if (capacity == stack.size()) noFullIndex.remove(index);
    }
    
    public int pop() {
        if (stacks.isEmpty()) return -1;
        
        int index = stacks.size() - 1;
        
        int result = -1;

        Stack<Integer> stack = stacks.get(index);
        result = stack.pop();

        if (!noFullIndex.contains(index)) noFullIndex.add(index);
    	//isEmptyThenRemove(index);
        int tmp = index;
        if (stacks.get(tmp).isEmpty()) {
        	while (0 <= tmp && stacks.get(tmp).isEmpty()) {
        		noFullIndex.remove(tmp--);
        		stacks.remove(stack);
        	}
        } else {
        	noFullIndex.add(index);
        }

        return result;
    }
    
    public int popAtStack(int index) {
    	if (stacks.size() <= index) return -1;
    	if (index == stacks.size() - 1) return pop();
    	
    	Stack<Integer> stack = stacks.get(index);
    	int result = stack.isEmpty() ? -1 : stack.pop();
    	
    	if (!noFullIndex.contains(index)) noFullIndex.add(index);
    	
    	return result;
    }
    
    public void isEmptyThenRemove(int index) {
    	Stack<Integer> stack = stacks.get(index);
    	if (stack.isEmpty()) {
    		stacks.remove(stack);
    		noFullIndex.remove(index);
    	}
    	//if (stack.isEmpty() && noFullIndex.contains(index)) noFullIndex.remove(index);
    }
    
    public static void main(String[] args) {
    	DinnerPlates dp = new DinnerPlates(1);
    	dp.push(1);
    	dp.push(2);
    	dp.push(3);
    	
    	assertEquals(2, dp.popAtStack(1));
    	assertEquals(3, dp.pop());
    	assertEquals(1, dp.pop());
    	
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
