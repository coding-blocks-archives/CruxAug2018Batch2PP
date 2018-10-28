package L21_Oct24.Adapters;

import L16_Oct7.LinkedList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Oct-2018
 *
 */

public class StackULL {

	LinkedList list = new LinkedList();

	public void push(int item) {
		list.addFirst(item);
	}

	public int pop() throws Exception {

		try {
			return list.removeFirst();
		} catch (Exception e) {
			throw new Exception("Stack is Empty");
		}

	}

	public int peek() throws Exception {

		try {
			return list.getFirst();
		} catch (Exception e) {
			throw new Exception("Stack is Empty");
		}

	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		list.display();
	}

}
