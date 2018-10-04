package Assignments.Oct4;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Oct-2018
 *
 */

public class ValidInvalidSeq {

	public static void main(String[] args) {
		System.out.println(validinvalid());
	}

	public static boolean validinvalid() {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		boolean gd = true;

		int prev = scn.nextInt();

		for (int i = 1; i <= n - 1; i++) {

			int curr = scn.nextInt();

			if (gd) {
				if (prev > curr) {
					// acceptable
				} else {
					gd = false;
				}

			} else {
				if (prev < curr) {
					// acceptable
				} else {
					return false;
				}
			}

			prev = curr;
		}

		return true;

	}

}
