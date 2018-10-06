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

		displayReverse(stack);

		stack.display();
		actualReverse(stack, new DynamicStack());
		stack.display();
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

}
