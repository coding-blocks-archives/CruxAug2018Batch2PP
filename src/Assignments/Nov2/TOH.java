package Assignments.Nov2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Nov-2018
 *
 */

public class TOH {

	public static void main(String[] args) {

		TOH(3, "S", "D", "H");
	}

	public static void TOH(int n, String src, String dst, String helper) {

		if (n == 0) {
			return;
		}
		TOH(n - 1, src, helper, dst);
		System.out.println("Move " + n + "th disc from " + src + " to " + dst);
		TOH(n - 1, helper, dst, src);

	}
}
