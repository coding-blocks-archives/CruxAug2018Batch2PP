package L22_Oct27;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 27-Oct-2018
 *
 */

public class BSTClient {

	public static void main(String[] args) {

		int[] in = { 5, 10, 15, 20, 25, 30, 35, 40 };

		BST bst = new BST(in);
		bst.display();

		// System.out.println(bst.max());
		//
		// bst.printInRange(7, 25);
		//
		// bst.printDec();

		// bst.replaceWithSumLarger();
		// bst.display();

		// bst.add(11);
		bst.display();

		bst.remove(10);
		bst.display();
	}

}
