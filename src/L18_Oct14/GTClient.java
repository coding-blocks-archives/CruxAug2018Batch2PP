package L18_Oct14;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Oct-2018
 *
 */

public class GTClient {

	// 10 3 20 2 50 0 60 0 30 0 40 1 70 0
	public static void main(String[] args) {
		GenericTree gt = new GenericTree();
		gt.display();

		System.out.println(gt.size());
		System.out.println(gt.height());
		System.out.println(gt.max());
		System.out.println(gt.find(100));

		gt.mirror();
		gt.display();
	}

}
