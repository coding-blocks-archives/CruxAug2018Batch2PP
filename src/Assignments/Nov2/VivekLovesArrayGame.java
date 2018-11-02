package Assignments.Nov2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Nov-2018
 *
 */

public class VivekLovesArrayGame {

	public static void main(String[] args) {

		int[] arr = { 4, 1, 0, 1, 1, 0, 1 };

		System.out.println(game(arr, 0, arr.length - 1));
	}

	private static int game(int[] arr, int si, int ei) {

		for (int mid = si; mid < ei; mid++) {

			int sum1 = 0;
			int sum2 = 0;

			for (int i = si; i <= mid; i++) {
				sum1 += arr[i];
			}

			for (int i = mid + 1; i <= ei; i++) {
				sum2 += arr[i];

			}

			if (sum1 == sum2) {
				int ans1 = game(arr, si, mid);
				int ans2 = game(arr, mid + 1, ei);

				return Math.max(ans1, ans2) + 1;
			}

		}

		return 0;

	}

}
