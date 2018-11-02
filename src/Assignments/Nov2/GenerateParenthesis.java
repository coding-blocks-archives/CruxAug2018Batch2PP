package Assignments.Nov2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Nov-2018
 *
 */

public class GenerateParenthesis {

	public static void main(String[] args) {
		GenerateParenthesis(0, 0, 2, "");
	}

	public static void GenerateParenthesis(int open, int close, int n, String ans) {

		if (open == n && close == n) {
			System.out.println(ans);
			return;
		}

		if (open > n || close > n || close > open) {
			return;
		}

		GenerateParenthesis(open, close + 1, n, ans + ")");
		GenerateParenthesis(open + 1, close, n, ans + "(");

	}

}
