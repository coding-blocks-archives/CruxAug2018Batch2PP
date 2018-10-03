package L14_Oct2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Oct-2018
 *
 */

public class Stack {

	private int[] data;
	private int tos;

	public Stack() {
		this.data = new int[5];
		this.tos = -1;
	}

	public Stack(int cap) {
		this.data = new int[cap];
		this.tos = -1;
	}

	public void push(int item) throws Exception {

		if (this.isFull()) {
			throw new Exception("Stack is Full");
		}

		this.tos++;
		this.data[this.tos] = item;

	}

	public int pop() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Stack is Empty");
		}

		int rv = this.data[this.tos];
		this.data[this.tos] = 0;
		this.tos--;

		return rv;

	}

	public int peek() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Stack is Empty");
		}

		int rv = this.data[this.tos];
		return rv;

	}

	public int size() {
		return this.tos + 1;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public boolean isFull() {
		return this.size() == this.data.length;
	}

	public void display() {

		System.out.println("---------------");

		for (int i = this.tos; i >= 0; i--) {
			System.out.print(this.data[i] + " ");
		}

		System.out.println();
		System.out.println("---------------");
	}

}
