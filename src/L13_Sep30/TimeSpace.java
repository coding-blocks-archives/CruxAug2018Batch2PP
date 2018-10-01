package L13_Sep30;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Sep-2018
 *
 */

public class TimeSpace {

	public static void main(String[] args) {

		int[] arr = new int[1000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - i;
		}

		long start = System.currentTimeMillis();
		// bubblesort(arr);
		// L12_Sep29.RecursionSorting.mergeSort(arr, 0, arr.length - 1) ;
		System.out.println(power(2, 1000000000));

		long end = System.currentTimeMillis();
		System.out.println(end - start);

		// System.out.println(polynomial(3, 5));
		// System.out.println(palindromicSS("aabaa"));

	}

	public static void bubblesort(int[] arr) {

		boolean flag = true;
		for (int counter = 0; counter < arr.length - 1; counter++) {

			for (int j = 0; j < arr.length - 1 - counter; j++) {

				if (arr[j] > arr[j + 1]) {

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = false;
				}
			}

			if (flag) {
				break;
			}
		}

	}

	public static int polynomial(int x, int n) {

		int sum = 0;
		int power = x;

		for (int coeff = n; coeff >= 1; coeff--) {
			sum += coeff * power;
			power = power * x;
		}

		return sum;
	}

	public static int palindromicSS(String str) {

		int count = 0;

		// odd length palindromic ss
		for (int axis = 0; axis < str.length(); axis++) {

			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					count++;
				} else {
					break;
				}
			}

		}

		// even length palindromic ss
		for (double axis = 0.5; axis < str.length(); axis++) {

			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {
					count++;
				} else {
					break;
				}
			}

		}

		return count;

	}

	// x^n
	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int pnby2 = power(x, n / 2);

		int ans = 0;

		if (n % 2 == 0) {
			ans = pnby2 * pnby2;
		} else {
			ans = pnby2 * pnby2 * x;
		}

		return ans;

	}

}
