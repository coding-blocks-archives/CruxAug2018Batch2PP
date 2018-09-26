package Assignments.Sep26;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Sep-2018
 *
 */

public class HelpRamu {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {

			int c1 = scn.nextInt();
			int c2 = scn.nextInt();
			int c3 = scn.nextInt();
			int c4 = scn.nextInt();

			int r = scn.nextInt();
			int c = scn.nextInt();

			int[] ra = new int[r];
			int[] ca = new int[c];

			for (int i = 0; i < r; i++) {
				ra[i] = scn.nextInt();
			}

			for (int i = 0; i < c; i++) {
				ca[i] = scn.nextInt();
			}

			int ans = min(c1, c2, c3, c4, ra, ca);

			System.out.println(ans);
			tc--;
		}

	}

	private static int min(int c1, int c2, int c3, int c4, int[] ra, int[] ca) {

		int minR = minTransport(c1, c2, c3, ra);
		int minC = minTransport(c1, c2, c3, ca);

		return Math.min(c4, minR + minC);
	}

	public static int minTransport(int c1, int c2, int c3, int[] arr) {

		int cost = 0;

		for (int i = 0; i < arr.length; i++) {
			cost += Math.min(arr[i] * c1, c2);
		}

		return Math.min(cost, c3);

	}
}
