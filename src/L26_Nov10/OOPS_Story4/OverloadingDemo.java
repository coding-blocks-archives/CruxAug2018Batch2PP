package L26_Nov10.OOPS_Story4;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Nov-2018
 *
 */

public class OverloadingDemo {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 4, 5, 6 };
		add(3, 4, arr);
		// System.out.println(add(2.8, 3.4));
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static double add(double a, double b) {
		return a + b;
	}

	public static int add(int a, int b, int c) {
		return a + b + c;
	}

	public static void add(int b, int c, int... a) {

		int sum = 0;

		for (int val : a) {
			sum += val;
		}

		System.out.println(sum);
	}

}
