package Assignments.Sep26;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Sep-2018
 *
 */

public class Painter {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		long nop = scn.nextLong();
		int nob = scn.nextInt();

		long[] arr = new long[nob];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextLong();
		}

		System.out.println(painter(arr, nop, nob));

	}

	public static long painter(long[] arr, long nop, int nob) {

		long lo = 0;

		long sum = 0;
		for (long val : arr) {
			sum += val;
		}

		long hi = sum;

		long finalAns = 0;

		while (lo <= hi) {

			long mid = (lo + hi) / 2;

			if (isPossible(arr, nop, nob, mid)) {
				finalAns = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}

		return finalAns;

	}

	public static boolean isPossible(long[] arr, long nop, int nob, long mid) {

		int painter = 1;
		long timeRemaining = mid;

		// i denotes the no. of boards painted
		int i = 0;

		while (i < arr.length && painter <= nop) {

			if (arr[i] <= timeRemaining) {
				timeRemaining = timeRemaining - arr[i];
				i++;
			} else {
				painter++;
				timeRemaining = mid;

			}

		}

		if (i == arr.length) {
			return true;
		} else {
			return false;
		}

	}

}
