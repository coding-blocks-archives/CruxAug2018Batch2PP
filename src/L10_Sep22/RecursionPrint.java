package L10_Sep22;

import L9_Sep16.RecursionGet;

/**
 * @author Garima Chhikara
 * @date Sep 22, 2018
 */

public class RecursionPrint {

	public static void main(String[] args) {

		// printSS("ab", "");
		printSSAscii("ab", "");
		printKPC("145", "");
	}

	public static void printSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		// System.out.println("hii " + ques);

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		// System.out.println("going towards " + ans);
		printSS(roq, ans); // no
		// System.out.println("coming back from " + ans);
		// System.out.println("going towards " + (ans + ch));
		printSS(roq, ans + ch); // yes
		// System.out.println("coming back from " + (ans + ch));

		// System.out.println("bye " + ques);
	}

	public static void printSSAscii(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		// System.out.println("hii " + ques);

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSSAscii(roq, ans); // no
		printSSAscii(roq, ans + ch); // yes
		printSSAscii(roq, ans + (int) ch);

	}

	public static void printKPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		String code = RecursionGet.getCode(ch);

		for (int i = 0; i < code.length(); i++) {
			printKPC(roq, ans + code.charAt(i));
		}

	}

	public static void printPermutation(String ques, String ans) {

	}
}
