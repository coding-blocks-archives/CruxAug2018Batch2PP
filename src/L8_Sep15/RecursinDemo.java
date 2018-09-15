package L8_Sep15;

/**
 * @author Garima Chhikara
 * @date Sep 15, 2018
 */

public class RecursinDemo {

	public static void main(String[] args) {

		// printDec(5);
		// printInc(1000000000);

		// printDecIncSkips(9);
		// System.out.println(fibonacci(10));

		int[] arr = { 10, 20, 300, 40, 50, 300 };
		// displayReverse(arr, 0);
		System.out.println(max(arr, 0));
		System.out.println(findStartIndex(arr, 0, 30));
	}

	public static void printDec(int n) {

		if (n == 0) {
			return;
		}

		System.out.println(n);
		printDec(n - 1);

	}

	public static void printInc(int n) {

		if (n == 0) {
			return;
		}

		printInc(n - 1);
		System.out.println(n);

	}

	public static void printDecInc(int n) {

		if (n == 0) {
			return;
		}

		System.out.println(n);
		printDecInc(n - 1);
		System.out.println(n);

	}

	public static void printDecIncSkips(int n) {

		if (n == 0) {
			return;
		}

		if (n % 2 != 0)
			System.out.println(n);

		printDecIncSkips(n - 1);

		if (n % 2 == 0)
			System.out.println(n);

	}

	public static int factorial(int n) {

		if (n == 1) {
			return 1;
		}

		// assumption
		int fnm1 = factorial(n - 1);

		// self work
		int fn = fnm1 * n;

		return fn;
	}

	// x^n
	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int pnm1 = power(x, n - 1);
		int pn = pnm1 * x;

		return pn;

	}

	public static int fibonacci(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		int fn = fnm1 + fnm2;

		return fn;

	}

	public static void display(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		System.out.println(arr[vidx]);
		display(arr, vidx + 1);

	}

	public static void displayReverse(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		displayReverse(arr, vidx + 1);
		System.out.println(arr[vidx]);

	}

	public static int max(int[] arr, int vidx) {

		// if (vidx == arr.length - 1) {
		// return arr[vidx];
		// }

		if (vidx == arr.length) {
			return Integer.MIN_VALUE;
		}

		int recAns = max(arr, vidx + 1);

		if (recAns > arr[vidx]) {
			return recAns;
		} else {
			return arr[vidx];
		}
	}

	public static int findStartIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == item) {
			return vidx;
		}

		int recAns = findStartIndex(arr, vidx + 1, item);

		return recAns;

	}

	public static int findEndIndex(int[] arr, int vidx, int item) {

	}

	public static int[] findAllIndex(int[] arr, int vidx, int item) {

	}

}
