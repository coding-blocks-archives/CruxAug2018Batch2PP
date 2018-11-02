package Assignments.Nov2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Nov-2018
 *
 */

public class LargerPermutation {

	public static void main(String[] args) {
		printPermutation("bac", "", false);

	}

	public static void printPermutation(String ques, String ans, String os) {

		if (ques.length() == 0) {
			if (ans.compareTo(os) > 0) {
				System.out.println(ans);
			}
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			printPermutation(roq, ans + ch, os);

		}

	}

	public static void printPermutation(String ques, String ans, boolean isLarger) {

		if (ques.length() == 0) {
			if (isLarger)
				System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			if (isLarger == false) {
				if (ch > ques.charAt(0)) {
					printPermutation(roq, ans + ch, true);
				} else if (ch < ques.charAt(0)) {
					// no calls
				} else {
					printPermutation(roq, ans + ch, false);
				}
			} else {
				printPermutation(roq, ans + ch, true);
			}

		}

	}
}
