package Assignments.Oct4;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Oct-2018
 *
 */

public class PairOfRoses {

	public static void main(String[] args) {

		int[] arr = { 50, 60, 55, 10, 30, 20, 40 };

		int target = 80;

		Arrays.sort(arr);

		int i = 0;
		int j = arr.length - 1;

		int ansl = 0;
		int ansr = 0;

		while (i < j) {

			if (arr[i] + arr[j] > target) {
				j--;
			} else if (arr[i] + arr[j] < target) {
				i++;
			} else {
				ansl = arr[i];
				ansr = arr[j];
				i++;
				j--;
			}

		}

		System.out.println(ansl + " " + ansr);

	}

}
