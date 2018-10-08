package L15_Oct6;

import L14_Oct2.DynamicStack;
import L14_Oct2.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 06-Oct-2018
 *
 */

public class StackQs {

	public static void main(String[] args) throws Exception {

		Stack stack = new DynamicStack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);

		// displayReverse(stack);
		//
		// stack.display();
		// actualReverse(stack, new DynamicStack());
		// stack.display();

		// int[] arr = { 20, 10, 23, 15, 30, 40, 3 };
		// nextGreaterElement(arr);

		int[] arr = { 5, 10, 3, 1, 2, 7, 15, 12, 9, 14 };

		int[] ans = stockSpan(arr);
		for (int val : ans) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static void displayReverse(Stack s) throws Exception {

		if (s.isEmpty()) {
			return;
		}

		int temp = s.pop();
		displayReverse(s);

		System.out.println(temp);

		s.push(temp);

	}

	public static void actualReverse(Stack s, Stack h) throws Exception {

		if (s.isEmpty()) {
			actualReverseHelper(s, h);
			return;
		}

		int temp = s.pop();
		h.push(temp);

		actualReverse(s, h);

	}

	public static void actualReverseHelper(Stack s, Stack h) throws Exception {

		if (h.isEmpty()) {
			return;
		}

		int temp = h.pop();
		actualReverseHelper(s, h);
		s.push(temp);
	}

	public static void nextGreaterElement(int[] arr) throws Exception {

		Stack s = new DynamicStack();

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && arr[i] > s.peek()) {
				int temp = s.pop();

				System.out.println(temp + "->" + arr[i]);
			}

			s.push(arr[i]);

		}

		while (!s.isEmpty()) {
			int temp = s.pop();
			System.out.println(temp + "->" + -1);
		}

	}

	public static int[] stockSpan(int[] prices) throws Exception {

		Stack s = new DynamicStack();

		int[] span = new int[prices.length];

		span[0] = 1;
		s.push(0);

		for (int i = 1; i < prices.length; i++) {

			while (!s.isEmpty() && prices[i] > prices[s.peek()]) {
				s.pop();
			}

			if (s.isEmpty()) {
				span[i] = i + 1;
			} else {
				span[i] = i - s.peek();
			}

			s.push(i);
		}

		return span;

	}

}
