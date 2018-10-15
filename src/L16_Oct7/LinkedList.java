package L16_Oct7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Oct-2018
 *
 */

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		return this.head.data;
	}

	// O(1)
	public int getLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		return this.tail.data;
	}

	// O(n)
	public int getAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}

		Node temp = this.head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp.data;

	}

	// O(n)
	private Node getNodeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}

		Node temp = this.head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp;

	}

	// O(n)
	public void display() {

		System.out.println("-----------------------");
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println(".");
		System.out.println("-----------------------");

	}

	// O(1)
	public void addLast(int item) {

		// new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size > 0)
			this.tail.next = nn;

		// data members
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}

	}

	// O(1)
	public void addFirst(int item) {

		// new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size > 0)
			nn.next = this.head;

		// data members
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}

	}

	// O(n)
	public void addAt(int idx, int item) throws Exception {

		if (idx < 0 || idx > this.size) {
			throw new Exception("Invalid Index");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == this.size) {
			addLast(item);
		} else {
			// new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// links
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = getNodeAt(idx);

			nm1.next = nn;
			nn.next = np1;

			this.size++;
		}

	}

	// O(1)
	public int removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		int temp = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return temp;

	}

	// O(n)
	public int removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		int temp = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {

			Node sm2 = getNodeAt(size - 2);
			sm2.next = null;
			this.tail = sm2;

			this.size--;

		}

		return temp;

	}

	// O(n)
	public int removeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {

			Node prev = getNodeAt(idx - 1);
			Node self = prev.next;
			Node ahead = self.next;

			// link
			prev.next = ahead;
			this.size--;

			return self.data;

		}

	}

	public void reverseDI() throws Exception {

		int left = 0;
		int right = this.size - 1;

		while (left < right) {

			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;
		}

	}

	public void reversePI() {

		Node prev = this.head;
		Node curr = prev.next;

		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;

			prev = curr;
			curr = ahead;

		}

		// update head and tail
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;

	}

	public void reversePR() {

		reversePRH(this.head, this.head.next);

		// update head and tail
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;

	}

	private void reversePRH(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		reversePRH(curr, curr.next);
		curr.next = prev;

	}

	public void reverseDRReturn() {

		reverseDRHReturn(this.head, this.head, 0);
	}

	private Node reverseDRHReturn(Node left, Node right, int count) {

		if (right == null) {
			return left;
		}

		left = reverseDRHReturn(left, right.next, count + 1);

		// swap
		if (count >= size / 2) {
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
		}

		return left.next;

	}

	private class HeapMover {
		Node left = head;
	}

	public void reverseDRHeapMover() {

		HeapMover mover = new HeapMover();
		reverseDRHHeapMover(mover, this.head, 0);
	}

	private void reverseDRHHeapMover(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		reverseDRHHeapMover(mover, right.next, count + 1);

		// swap
		if (count >= size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}

		mover.left = mover.left.next;

	}

	public void fold() {
		foldH(new HeapMover(), this.head, 0);
	}

	private void foldH(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		foldH(mover, right.next, count + 1);

		if (count > size / 2) {
			Node ahead = mover.left.next;
			mover.left.next = right;
			right.next = ahead;

			mover.left = ahead;
		}

		if (count == size / 2) {
			this.tail = right;
			this.tail.next = null;
		}

	}

	public int mid() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;

		}

		return slow.data;

	}

	public int kthFromLast(int k) {

		Node slow = this.head;
		Node fast = this.head;

		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow.data;

	}

	public void kReverse(int k) throws Exception {

		LinkedList prev = null;

		while (this.size != 0) {

			LinkedList curr = new LinkedList();

			for (int i = 1; i <= k; i++) {
				curr.addFirst(this.removeFirst());
			}

			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}

		}

		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;

	}

	public void createDummyLL() {
		Node n1 = new Node();
		n1.data = 10;
		Node n2 = new Node();
		n2.data = 20;
		Node n3 = new Node();
		n3.data = 30;
		Node n4 = new Node();
		n4.data = 40;
		Node n5 = new Node();
		n5.data = 50;
		Node n6 = new Node();
		n6.data = 60;

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n6.next = n4;

		LinkedList first = new LinkedList();
		first.head = n1;
		first.tail = n5;

		LinkedList sec = new LinkedList();
		sec.head = n6;
		sec.tail = n5;

	}

}
