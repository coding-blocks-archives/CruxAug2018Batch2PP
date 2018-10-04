package Assignments.Oct4;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Oct-2018
 *
 */

public class ShoppingGame {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int ayushLimit = scn.nextInt();
		int harshitLimit = scn.nextInt();

		int ayushCount = 0;
		int harshitCount = 0;

		int i = 1;

		while (true) {

			// aayush odd
			if (i % 2 != 0) {
				if (ayushCount + i <= ayushLimit) {
					ayushCount += i;
				} else {
					// aayush is not able to purchase phone
					System.out.println("Harshit");
					break;
				}
			} else { // harshit even
				if (harshitCount + i <= harshitLimit) {
					harshitCount += i;
				} else {
					// harshit is not able to purchase phone
					System.out.println("Aayush");
					break;
				}
			}
			i++;
		}

	}

}
