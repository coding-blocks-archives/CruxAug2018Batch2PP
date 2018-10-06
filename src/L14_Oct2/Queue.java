package L14_Oct2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Oct-2018
 *
 */

public class Queue {

	protected int[] data;
	protected int front;
	private int size;

	public Queue() {
		this.data = new int[5];
		this.front = 0;
		this.size = 0;
	}

	public Queue(int cap) {
		this.data = new int[cap];
		this.front = 0;
		this.size = 0;
	}

	public void enqueue(int item) throws Exception {

		if (this.isFull()) {
			throw new Exception("Queue is Full");
		}

		int idx = (this.front + this.size) % this.data.length;
		this.data[idx] = item;

		// data members
		this.size++;

	}

	public int dequeue() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Queue is Empty");
		}

		int rv = this.data[this.front];
		this.data[this.front] = 0;

		// data members
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return rv;

	}

	public int getFront() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Queue is Empty");
		}

		int rv = this.data[this.front];
		return rv;

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == this.data.length;
	}

	public void display() {

		System.out.println("--------------");

		for (int i = 0; i < this.size; i++) {
			int idx = (i + this.front) % this.data.length;
			System.out.print(this.data[idx] + " ");
		}

		System.out.println();
		System.out.println("--------------");

	}

}
