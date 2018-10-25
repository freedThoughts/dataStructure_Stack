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


    /*
         K = k1 + k2 + k3 + ... + kn = n
         Average of K is 1. Average(ki) = 1
         Time complexity = O(n * ki) => O(n)
         Space complexity = O(n) for stack
     */
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


	/*
	    Time complexity - O(2n) ~ O(n)
	    Space complexity - O(n) -- for stack
	*/
	@Override
	public int maxHistogramArea(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int area = -1;

		for (int i = 0; i < arr.length; i++) {
			if (stack.isEmpty() || arr[i] >= arr[stack.peek()]) {
			    stack.push(i);
			    continue;
            }

            while(!stack.isEmpty() && arr[stack.peek()] > arr[i])
			    area = calculateAreaByPopingFromStack(stack, area, i,arr);

            stack.push(i);
		}

		int index = -1;
		if (!stack.isEmpty())
		    index = stack.peek() +1;
		while (!stack.isEmpty())
            area = calculateAreaByPopingFromStack(stack, area, index,arr);

		return area;
	}

	private int calculateAreaByPopingFromStack(Stack<Integer> stack, int area, int index, int[] arr) {
        int lastIndexPoped = stack.pop();
        if (stack.isEmpty())
            return Math.max(area, arr[lastIndexPoped] * index);

        return Math.max(area, (index - lastIndexPoped) * arr[lastIndexPoped]);
    }

    // Time Complexity ~~ O(n^2)
	// Space Complexity ~~ O(n)
	@Override
    public Stack<Integer> sortStack(Stack<Integer> stack){
		Stack<Integer> resultStack = new Stack<Integer>();
		while (!stack.isEmpty()) {
			Integer currentElement = stack.pop();
			while (!resultStack.isEmpty() && resultStack.peek() < currentElement) {
				stack.push(resultStack.pop());
			}
			resultStack.push(currentElement);
		}
		return resultStack;
	}

	public static void main(String[] args) {
		StackOperation obj = new StackOperation();
		//int[] result = obj.findSpans2(new int[]{6,3,4,5,2});
/*		int[] result = obj.findSpans2(new int[]{100, 80, 60, 70, 60, 75, 85, 110, 60});
		for(int i = 0; i < result.length; i++)
			System.out.println(result[i]);*/
        int[] inputArr = {2, 1, 2, 3, 1};//{1, 2, 4};
		System.out.println(obj.maxHistogramArea(inputArr));

	}

}





