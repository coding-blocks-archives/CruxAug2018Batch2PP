package L14_Oct2.OOPS_Story1;

import L14_Oct2.DynamicStack;
import L14_Oct2.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 06-Oct-2018
 *
 */

public class DSClient {

	public static void main(String[] args) throws Exception {

		Stack stack = new DynamicStack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.push(80);
		stack.push(90);
		stack.push(100);

		stack.display();

	}

}
