package Assignments.Oct4;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Oct-2018
 *
 */

public class Alex {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int[] arr = { 100, 200, 400, 100 };

		int q = scn.nextInt();

		for (int i = 1; i <= q; i++) {

			int amount = scn.nextInt();
			int k = scn.nextInt();

			int count = 0;

			for (int j = 0; j < arr.length; j++) {
				if (amount % arr[j] == 0) {
					count++;
				}
			}

			if (count >= k) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}

		}

	}

}
