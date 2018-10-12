package Assignments.Oct11;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Oct-2018
 *
 */

public class Boston {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int digitSum = sumOfDigits(n);

		int factorSum = 0;

		int onum = n;
		for (int i = 2; i <= Math.sqrt(onum); i++) {

			if (isPrime(i)) {

				while (n % i == 0) {
					factorSum += sumOfDigits(i);
					n = n / i;
				}
			}

		}

		if (n >= 2)
			factorSum += sumOfDigits(n);

		System.out.println(digitSum == factorSum);

	}

	public static int sumOfDigits(int n) {

		int sum = 0;

		while (n != 0) {

			int rem = n % 10;
			sum += rem;
			n = n / 10;
		}

		return sum;
	}

	public static boolean isPrime(int n) {

		for (int div = 2; div <= Math.sqrt(n); div++) {
			if (n % div == 0) {
				return false;
			}
		}

		return true;
	}

}
