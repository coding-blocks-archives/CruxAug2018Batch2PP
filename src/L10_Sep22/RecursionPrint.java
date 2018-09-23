package L10_Sep22;

import L9_Sep16.RecursionGet;

/**
 * @author Garima Chhikara
 * @date Sep 22, 2018
 */

public class RecursionPrint {

	public static void main(String[] args) {

		// printSS("ab", "");
		// printSSAscii("ab", "");
		// printKPC("145", "");
		// printPermutation2("aba", "");
		// permutationNoDuplicate("aba", "");
		// System.out.println(coinToss(3, ""));
		// coinTossNoConsecutiveHead(3, "", true);

		lexicoCounting2(1, 1000);
		// System.out.println(boardPath(0, 10, ""));
		// System.out.println(mazePath(0, 0, 2, 2, ""));
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

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		for (int i = 0; i <= ans.length(); i++) {

			String val = ans.substring(0, i) + ch + ans.substring(i);
			printPermutation(roq, val);

		}

	}

	public static void printPermutation2(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			printPermutation2(roq, ans + ch);

		}

	}

	public static void permutationNoDuplicate(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		boolean[] visited = new boolean[256];

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			if (!visited[ch])
				permutationNoDuplicate(roq, ans + ch);

			visited[ch] = true;
		}

	}

	public static void permutationNoDuplicate2(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			boolean flag = true;

			for (int j = i + 1; j < ques.length(); j++) {
				if (ch == ques.charAt(j)) {
					flag = false;
				}
			}

			if (flag)
				permutationNoDuplicate2(roq, ans + ch);

		}

	}

	public static int coinToss(int n, String ans) {

		if (n == 0) {
			System.out.println(ans);
			return 1;
		}

		int ch = coinToss(n - 1, ans + "H");
		int ct = coinToss(n - 1, ans + "T");

		return ch + ct;

	}

	public static void coinTossNoConsecutiveHead(int n, String ans, boolean wasLastHeadIncluded) {

		if (n == 0) {
			System.out.println(ans);
			return;
		}

		if (wasLastHeadIncluded) {
			coinTossNoConsecutiveHead(n - 1, ans + "T", false);
		} else {
			coinTossNoConsecutiveHead(n - 1, ans + "H", true);
			coinTossNoConsecutiveHead(n - 1, ans + "T", false);

		}
	}

	public static void permutationLexicoLarger(String ques, String ans) {

	}

	public static int boardPath(int curr, int end, String ans) {

		if (curr == end) {
			System.out.println(ans);
			return 1;
		}

		if (curr > end) {
			// System.out.println(ans);
			return 0;
		}
		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += boardPath(curr + dice, end, ans + dice);
		}

		return count;
	}

	public static int mazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			System.out.println(ans);
			return 0;
		}

		int ch = mazePath(cr, cc + 1, er, ec, ans + "H");
		int cv = mazePath(cr + 1, cc, er, ec, ans + "V");

		return ch + cv;
	}

	// if curr is 1 then it will print all numbers which starts from 1 in lexico
	// order
	public static void lexicoCounting(int curr, int end) {

		if (curr > end) {
			return;
		}

		System.out.println(curr);

		int i = 0;
		if (curr == 0) {
			i = 1;
		}

		for (; i <= 9; i++) {
			lexicoCounting(curr * 10 + i, end);
		}

	}

	// if curr is 1 then it will print all numbers from 1 to end in lexico order
	public static void lexicoCounting2(int curr, int end) {

		if (curr > end) {
			return;
		}

		System.out.println(curr);

		if (curr != 0) {
			for (int i = 0; i <= 9; i++) {
				lexicoCounting2(curr * 10 + i, end);
			}
		}

		if (curr + 1 <= 9)
			lexicoCounting2(curr + 1, end);

	}

}
