package Assignments.Nov18;

import java.util.*;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Nov-2018
 *
 */

public class LIS {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextLong();
		}
		// int[] arr = { 50, 3, 10, 7, 40, 80 };

		long[] strg = new long[arr.length];

		Arrays.fill(strg, 1);

		for (int i = 1; i < strg.length; i++) {

			for (int j = 0; j < i; j++) {

				if (arr[j] < arr[i]) {

					long nval = strg[j] + 1;

					if (nval > strg[i]) {
						strg[i] = nval;
					}
				}
			}
		}

		long ans = 0;
		for (long val : strg) {
			if (val > ans) {
				ans = val;
			}
		}

		System.out.println(ans);

	}

}
