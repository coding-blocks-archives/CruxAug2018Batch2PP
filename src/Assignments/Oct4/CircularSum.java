package Assignments.Oct4;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Oct-2018
 *
 */

public class CircularSum {

	public static void main(String[] args) {

		int[] arr = { 8, -8, 9, -9, 10, -11, 12 };

		int[] na = new int[arr.length * 2];

		for (int i = 0; i < arr.length; i++) {
			na[i] = arr[i];
			na[i + arr.length] = arr[i];
		}

		int maxSum = 0;

		for (int si = 0; si <= arr.length - 1; si++) {

			for (int ei = si; ei <= si + arr.length - 1; ei++) {

				int subarraySum = 0;

				for (int k = si; k <= ei; k++) {
					subarraySum += na[k];
				}

				if (subarraySum > maxSum) {
					maxSum = subarraySum;
				}
			}
		}

		System.out.println(maxSum);

	}

}
