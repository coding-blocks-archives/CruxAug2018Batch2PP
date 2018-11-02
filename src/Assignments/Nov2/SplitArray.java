package Assignments.Nov2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Nov-2018
 *
 */

public class SplitArray {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 3, 4, 5 };

		SplitArray(arr, 0, 0, "", 0, "");

	}

	public static void SplitArray(int[] arr, int vidx, int g1sum, String g1asf, int g2sum, String g2asf) {

		if (vidx == arr.length) {

			if (g1sum == g2sum) {
				System.out.println(g1asf + " and " + g2asf);
			}

			return;
		}

		SplitArray(arr, vidx + 1, g1sum + arr[vidx], g1asf + " " + arr[vidx], g2sum, g2asf);
		SplitArray(arr, vidx + 1, g1sum, g1asf, g2sum + arr[vidx], g2asf + " " + arr[vidx]);

	}

}
