package Assignments.Nov2;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Nov-2018
 *
 */

public class OnlyLadders {

	public static void main(String[] args) {

		int[] ladders = makeLadders(SOE(13));
		
		OnlyLadders(ladders, "", 0, 13);

	}

	private static void OnlyLadders(int[] ladders, String ans, int curr, int end) {

		if (curr == end) {
			System.out.println(ans);
			return;
		}

		if (curr > end) {
			return;
		}

		if (ladders[curr] != 0) {
			OnlyLadders(ladders, ans + "L[" + curr + "->" + ladders[curr] + "]", ladders[curr], end);
		} else {

			for (int dice = 1; dice <= 6; dice++) {
				OnlyLadders(ladders, ans + dice, curr + dice, end);
			}
		}

	}

	public static boolean[] SOE(int n) {

		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table] == false) {
				continue;
			}

			for (int multiplier = 2; multiplier * table <= n; multiplier++) {
				primes[multiplier * table] = false;
			}

		}

		return primes;

	}

	public static int[] makeLadders(boolean[] primes) {

		int[] ladders = new int[primes.length];

		int left = 0;
		int right = primes.length - 1;

		while (left < right) {

			while (primes[left] == false) {
				left++;
			}

			while (primes[right] == false) {
				right--;
			}

			if (left < right) {
				ladders[left] = right;
				left++;
				right--;
			}

		}

		return ladders;

	}

}
