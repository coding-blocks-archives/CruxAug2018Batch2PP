package Assignments.Oct4;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Oct-2018
 *
 */

public class Boston {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int digitSum = 0;
		int factorSum = 0;

		int temp = n;
		while (temp != 0) {
			int rem = temp % 10;
			digitSum += rem;
			temp = temp / 10;
		}

		// case of 2
		while (n % 2 == 0) {
			factorSum += 2;
			n = n / 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i = i + 2) {

			while (n % i == 0) {

				// i can be a multiple digit no. , if it is then find out the sum of individual
				// digits
				int t = i;
				while (t != 0) {
					int rem = t % 10;
					factorSum += rem;
					t = t / 10;
				}

				n = n / i;
			}

		}

		if (n > 1) {
			while (n != 0) {
				int rem = n % 10;
				factorSum += rem;
				n = n / 10;
			}
		}

		if (factorSum == digitSum) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}

	}

}
