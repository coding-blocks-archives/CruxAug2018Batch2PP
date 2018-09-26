package Assignments.Sep26;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Sep-2018
 *
 */

public class ReadPages {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		long tc = scn.nextLong();

		while (tc > 0) {
			int nob = scn.nextInt();
			long nos = scn.nextLong();

			long[] arr = new long[nob];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextLong();
			}

			System.out.println(rp(arr, nob, nos));
			tc--;
		}

	}

	public static long rp(long[] arr, int nob, long nos) {

		long lo = 0;

		long sum = 0;
		for (long val : arr) {
			sum += val;
		}

		long hi = sum;

		long finalAns = 0;

		while (lo <= hi) {

			long mid = (lo + hi) / 2;

			if (isPossible(arr, nob, nos, mid)) {
				finalAns = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}

		return finalAns;

	}

	public static boolean isPossible(long[] arr, int nob, long nos, long mid) {

		long students = 1;
		long pagesRead = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > mid) {
				return false;
			}

			if (pagesRead + arr[i] <= mid) {
				pagesRead += arr[i];
			} else {

				students++;
				pagesRead = arr[i];

				if (students > nos) {
					return false;
				}

			}

		}

		return true;

	}

}
