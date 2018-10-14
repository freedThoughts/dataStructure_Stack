package problemSet_1;

import java.util.Stack;

public class StackOperation implements IStackOperation{

	@Override
	public int[] findSpans(int [] stock){
		int[] span = new int[stock.length];
		
		// Stack holds the indices of a input array
		Stack<Integer> stack = new Stack<Integer>(); // 
		for(int i = 0; i < stock.length ; i++){
			while(!stack.isEmpty() && stock[stack.peek()] <= stock[i])
				stack.pop(); // remove top whenever encounter any value greater than top
			 				 // so that we have largest value compared ever, on top of stack
			                 // we are avoiding multiple comparision by this approach.
			
			if(stack.isEmpty())
				span[i] = i +1;
			else
				span[i] = i - stack.peek();
			
			stack.push(i);
		}
		
		return span;
	}

	public static void main(String[] args) {
		StackOperation obj = new StackOperation();
		//int[] result = obj.findSpans2(new int[]{6,3,4,5,2});
		int[] result = obj.findSpans2(new int[]{100, 80, 60, 70, 60, 75, 85, 110, 60});
		for(int i = 0; i < result.length; i++)
			System.out.println(result[i]);

	}

	@Override
	public int[] findSpans2(int [] stock){
		int[] span = new int[stock.length];
		Stack<Integer> stack = new Stack();
		for(int i = 0; i < stock.length; i++){
			// Set default value 1 for all
			span[i] = 1;

			// currentStockValue is less than previous day value
			if(stack.isEmpty() || stock[stack.peek()] > stock[i]){
				stack.push(i);
				continue;
			}

			//  currentStockValue is more than or equals to previous day value
			while(!stack.isEmpty() && stock[stack.peek()] <= stock[i])
				span[i] += span[stack.pop()];

			stack.push(i);
		}
		return span;
	}

}

// K = k1 + k2 + k3 + ... + kn = n
// Average of K is 1. Average(ki) = 1
// Time complexity = O(n * ki) => O(n)
// Space complexity = O(n) for stack
