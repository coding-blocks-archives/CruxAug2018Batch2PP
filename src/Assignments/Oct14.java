package Assignments;

import java.util.ArrayList;
import java.util.Scanner;

public class Oct14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		// System.out.println(chess_board(0, 0, n, n));
		// chess_board(0, 0, n, n, "");

		// int n=scn.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scn.nextInt();
		// int[] arr = { 4, 1, 9, 1, 1, 24, 1 };

		// System.out.println(maxScore(arr, 0, arr.length - 1));
		//
		// split(arr, 0, 0, "", 0, "");

		// char ch = '1';
		// System.out.println((char) (ch + 48));

		// ArrayList<String> ans = codesofstring("1125");
		//
		// System.out.println(ans.size());
		// System.out.println(ans);

		System.out.println(split(a, 0, 0, 0, 0));
		split(a, 0, 0, "", 0, "");
		// TOH(3, 's', 'd', 'h');

	}

	public static void chess_board(int cr, int cc, int er, int ec, String ans) {

		// Positive Base Case

		if (cr == er - 1 && cc == ec - 1) {

			System.out.print(ans + "{" + cr + "-" + cc + "} ");
			return;
		}

		// Negative Base case
		if (cr >= er || cc >= ec) {
			return;
		}

		// Knight

		chess_board(cr + 2, cc + 1, er, ec, ans + "{" + cr + "-" + cc + "}K");
		chess_board(cr + 1, cc + 2, er, ec, ans + "{" + cr + "-" + cc + "}K");

		// Rook

		if (cr == 0 || cc == 0 || cr == er - 1 || cc == ec - 1) {

			for (int moves = 1; moves < ec; moves++)
				chess_board(cr, cc + moves, er, ec, ans + "{" + cr + "-" + cc + "}R");

			for (int moves = 1; moves < er; moves++)
				chess_board(cr + moves, cc, er, ec, ans + "{" + cr + "-" + cc + "}R");

		}
		// Bishop

		if (cr == cc || cr + cc == er - 1) {

			for (int moves = 1; moves < er; moves++) {

				chess_board(cr + moves, cc + moves, er, ec, ans + "{" + cr + "-" + cc + "}B");
			}
		}
	}

	public static int chess_board(int cr, int cc, int er, int ec) {

		// Positive Base Case

		if (cr == er - 1 && cc == ec - 1) {

			return 1;
		}

		// Negative Base case
		if (cr >= er || cc >= ec) {
			return 0;
		}
		int cnt = 0;

		// Knight

		cnt += chess_board(cr + 2, cc + 1, er, ec);
		cnt += chess_board(cr + 1, cc + 2, er, ec);

		// Rook

		if (cr == 0 || cc == 0 || cr == er - 1 || cc == ec - 1) {

			for (int moves = 1; moves < ec; moves++)
				cnt += chess_board(cr, cc + moves, er, ec);

			for (int moves = 1; moves < er; moves++)
				cnt += chess_board(cr + moves, cc, er, ec);

		}
		// Bishop

		if (cr == cc || (cr + cc == er - 1)) {

			for (int moves = 1; moves < er; moves++) {

				cnt += chess_board(cr + moves, cc + moves, er, ec);
			}

		}
		return cnt;

	}

	public static void split(int[] arr, int vidx, int sumL, String ansL, int sumR, String ansR) {

		if (vidx == arr.length) {
			if (sumL == sumR) {
				System.out.println(ansL + " and " + ansR);
			}
			return;
		}

		split(arr, vidx + 1, sumL + arr[vidx], ansL + arr[vidx] + " ", sumR, ansR);
		split(arr, vidx + 1, sumL, ansL, sumR + arr[vidx], ansR + arr[vidx] + " ");

	}

	public static int split(int[] a, int vidx, int sum1, int sum2, int c) {
		if (vidx == a.length) {
			if (sum1 == sum2)
				// System.out.println(ans1+ " and "+ ans2);
				c++;
			return c;
		}
		int count = 0;
		count += split(a, vidx + 1, sum1 + a[vidx], sum2, c);
		count += split(a, vidx + 1, sum1, sum2 + a[vidx], c);

		return count;

	}

	public static boolean balanced(String str, String ans) {

		if (str.length() == 0) {

			if (ans.length() == 0)
				return true;
			else
				return false;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		if (ch == '(' || ch == '{' || ch == '[') {

			ans += ch;

		} else if (ch == ')' || ch == '}' || ch == ']') {

			if (ans.length() != 0) {

				char last = ans.charAt(ans.length() - 1);

				if (last == '{' && ch != '}') {
					return false;
				} else if (last == '(' && ch != ')') {
					return false;
				} else if (last == '[' && ch != ']') {

					return false;
				}

				ans = ans.substring(0, ans.length() - 1);

			} else {
				return false;
			}

		}

		return balanced(ros, ans);

	}

	public static int maxScore(int[] arr, int si, int ei) {

		int fh = 0;
		int sh = 0;

		for (int i = si; i < ei; i++) {

			int sum1 = sum(arr, si, i);
			int sum2 = sum(arr, i + 1, ei);

			if (sum1 == sum2) {

				fh = maxScore(arr, si, i);
				sh = maxScore(arr, i + 1, ei);

				return Math.max(fh, sh) + 1;

			}

		}

		return 0;

	}

	public static int sum(int[] arr, int si, int ei) {

		int sum = 0;
		for (int i = si; i <= ei; i++) {

			sum += arr[i];
		}
		return sum;

	}

	public static ArrayList<String> codesofstring(String str) {

		if (str.length() == 0) {

			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);

		char val = (char) (ch + 48);

		ArrayList<String> rr = codesofstring(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String s : rr) {
			mr.add(val + s);
		}

		if (str.length() > 1) {

			String ch2 = str.substring(0, 2);
			int value = Integer.parseInt(ch2);

			if (value <= 26) {

				char alpha = (char) ('a' + value - 1);

				ros = str.substring(2);

				rr = codesofstring(ros);

				for (String s : rr) {
					mr.add(alpha + s);
				}

			}
		}

		return mr;
	}

	public static void TOH(int n, char src, char dest, char helper) {

		if (n == 1) {

			System.out.println("Moving disk 1 from " + src + " to " + dest);
			return;

		}

		TOH(n - 1, src, helper, dest);
		System.out.println("Moving disk " + n + " from " + src + " to " + dest);
		TOH(n - 1, helper, dest, src);

	}

}
