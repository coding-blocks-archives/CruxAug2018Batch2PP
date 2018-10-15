package L16_Oct7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Oct-2018
 *
 */

public class Client {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		// System.out.println(list.getAt(5));
		list.display();
		list.addAt(2, 60);
		list.display();

		System.out.println(list.removeFirst());
		// System.out.println(list.removeLast());
		// System.out.println(list.removeAt(0));
		list.display();

		// list.reverseDI();
		// list.reverseDR();
		// list.reverseDRHeapMover();
		list.addFirst(100);
		list.addFirst(200);
		list.addFirst(300);
		list.addFirst(400);
		list.addFirst(500);
		list.display();
		// list.fold();
		// System.out.println(list.mid());
		list.display();

		// System.out.println(list.kthFromLast(3));
		list.kReverse(5);
		list.display();

	}

}
