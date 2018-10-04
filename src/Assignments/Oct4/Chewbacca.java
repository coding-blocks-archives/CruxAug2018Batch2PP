package Assignments.Oct4;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Oct-2018
 *
 */

public class Chewbacca {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		long n = scn.nextLong();

		long[] arr = new long[18];

		int count = 0;

		while (n != 0) {
			long rem = n % 10;
			arr[count] = rem;
			count++;
			n = n / 10;
		}

		// count will tell total no. of digits

		for (int i = 0; i < count; i++) {

			if (i != count - 1) {
				if (arr[i] >= 5) {
					arr[i] = 9 - arr[i];
				}
			} else {
				if (arr[i] >= 5 && arr[i] <= 8) {
					arr[i] = 9 - arr[i];
				}
			}
		}

		for (int i = count - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}

	}

}
