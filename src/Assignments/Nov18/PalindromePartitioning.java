package Assignments.Nov18;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Nov-2018
 *
 */

public class PalindromePartitioning {

	public static void main(String[] args) {

		String str = "ababbbabbababa";
		System.out.println(pp(str, 0, str.length() - 1));

	}

	public static int pp(String str, int si, int ei) {

		if (isPalindrome(str, si, ei)) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k < ei; k++) {

			int fh = pp(str, si, k);
			int sh = pp(str, k + 1, ei);

			int total = fh + sh + 1;

			if (total < min) {
				min = total;
			}

		}

		return min;

	}

	public static boolean isPalindrome(String str, int si, int ei) {

		int left = si;
		int right = ei;

		while (left <= right) {

			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

}
