package Assignments.Nov18;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Nov-2018
 *
 */

public class BinaryStrings {

	public static void main(String[] args) {

		int n = 4;

		int[] a = new int[n + 1];
		int[] b = new int[n + 1];

		a[1] = 1;
		b[1] = 1;

		for (int i = 2; i <= n; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}

		System.out.println(a[n] + b[n]);
	}

}
