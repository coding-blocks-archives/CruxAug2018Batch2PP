package L21_Oct24.Adapters;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Oct-2018
 *
 */

public class StackUQueueClient {

	public static void main(String[] args) throws Exception {

		StackULL stack = new StackULL();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.display();

		System.out.println(stack.pop());
		stack.display();

	}

}
