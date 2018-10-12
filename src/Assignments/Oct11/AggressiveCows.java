package Assignments.Oct11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Oct-2018
 *
 */

public class AggressiveCows {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nos = scn.nextInt();

		int noc = scn.nextInt();

		int[] stalls = new int[nos];

		for (int i = 0; i < stalls.length; i++) {
			stalls[i] = scn.nextInt();
		}

		Arrays.sort(stalls);

		System.out.println(ac(stalls, nos, noc));

	}

	public static int ac(int[] stalls, int nos, int noc) {

		int lo = 0;
		int hi = stalls[stalls.length - 1] - stalls[0];

		int finalAns = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isPossible(stalls, nos, noc, mid)) {
				lo = mid + 1;
				finalAns = mid;
			} else {
				hi = mid - 1;
			}

		}

		return finalAns;

	}

	private static boolean isPossible(int[] stalls, int nos, int noc, int mid) {

		int pos = stalls[0];
		int cowsPlaced = 1;

		for (int i = 1; i < stalls.length; i++) {

			if (stalls[i] - pos >= mid) {
				cowsPlaced++;
				pos = stalls[i];
			}

			if (cowsPlaced == noc) {
				return true;
			}
		}

		return false;
	}

}
