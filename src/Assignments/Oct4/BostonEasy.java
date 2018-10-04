package Assignments.Oct4;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Oct-2018
 *
 */

public class BostonEasy {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int digitSum = 0;
		int factorSum = 0;

		// digit sum
		digitSum = sumOfDigits(n);

		int onum = n;
		for (int i = 2; i <= Math.sqrt(onum); i++) {
			if (isPrime(i)) {
				while (n % i == 0) {
					factorSum += sumOfDigits(i);
					n = n / i;
				}
			}

		}

		// leftover n is prime no
		if (n > 1) {
			factorSum += sumOfDigits(n);
		}

		if (factorSum == digitSum) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	public static int sumOfDigits(int n) {

		int sum = 0;
		while (n != 0) {
			sum += (n % 10);
			n = n / 10;
		}

		return sum;

	}

	public static boolean isPrime(int n) {

		boolean flag = true;

		for (int div = 2; div <= Math.sqrt(n); div++) {
			if (n % div == 0) {
				flag = false;
				break;
			}

		}

		return flag;

	}

}
