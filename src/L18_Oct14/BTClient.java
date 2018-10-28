package L18_Oct14;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Oct-2018
 *
 */

public class BTClient {

	// 10 true 20 true 40 false false true 50 false false true 30 false false

	// 10 true 20 true 40 true 50 true 60 true 70 false false false false false true
	// 80 false true 90 false true 100 false false true 30 false false
	public static void main(String[] args) {

		int[] pre = { 10, 20, 40, 50, 60, 30, 70 };
		int[] in = { 40, 20, 60, 50, 10, 30, 70 };
		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();
		// System.out.println(bt.size());
		// System.out.println(bt.diameter());
		// System.out.println(bt.diameter2());
		//
		// System.out.println(bt.isBalanced());
		// bt.preorder();
		// bt.preorderI();

	}

}
