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

	}

}
