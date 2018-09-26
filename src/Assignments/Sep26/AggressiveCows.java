package Assignments.Sep26;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Sep-2018
 *
 */

public class AggressiveCows {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nos = scn.nextInt();
		int noc = scn.nextInt();

		int[] arr = new int[nos];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Arrays.sort(arr);
		System.out.println(ac(arr, nos, noc));

	}

	public static int ac(int[] arr, int nos, int noc) {

		int lo = 0;
		int hi = arr[arr.length - 1] - arr[0];

		int finalAns = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isPossible(arr, nos, noc, mid)) {
				finalAns = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}

		}

		return finalAns;

	}

	public static boolean isPossible(int[] arr, int nos, int noc, int mid) {

		int cowsPlaced = 1;
		int pos = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] - pos >= mid) {
				cowsPlaced++;
				pos = arr[i];

				if (cowsPlaced == noc) {
					return true;
				}

			}

		}

		return false;

	}

}
