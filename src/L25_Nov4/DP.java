package L25_Nov4;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Nov-2018
 *
 */

public class DP {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		int n = 3;
		// System.out.println(fibTD(n, new int[n + 1]));
		// System.out.println(fibBU(n));
		// System.out.println(fibBUSE(n));

		// System.out.println(boardPathTD(0, n, new int[n + 1]));
		// System.out.println(boardPathBU(n));
		// System.out.println(boardPathBUSE(n));

		// System.out.println(mazePath(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(mazePathBU(n, n));
		// System.out.println(mazePathBUSE(n, n));
		// System.out.println(mazePathBUSEDiag(n, n));

		// System.out.println(LCSBU("abcdefghtgcdhjsvcduj", "agcfdgjhjsdgcyugeuht"));
		// System.out.println(EditDistance("saturday", "sunday"));

		// int[] prices = { 2, 3, 5, 1, 4, 6, 1, 2, 3, 6, 45, 9, 8 };

		// System.out.println(WineProblem(prices, 0, prices.length - 1, 1));
		// System.out.println(WineProblemTD(prices, 0, prices.length - 1, new
		// int[prices.length][prices.length]));
		// System.out.println(WineProblemBU(prices));

		// int[] arr = { 2, 3, 4, 5, 6 };
		// int[] arr = new int[1000];
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = i + 1;
		// }
		// System.out.println(MCMTD(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));
		// System.out.println(MCMBU(arr));

		int[] wt = { 1, 3, 4, 5 };
		int[] price = { 1, 4, 5, 7 };

		int cap = 7;

		System.out.println(Knapsack(wt, price, 0, cap, new int[wt.length][cap + 1]));
		System.out.println(KnapsackBU(wt, price, cap));

		int[] arr = { 40, 60, 20 };
		System.out.println(Mixtures(arr, 0, arr.length - 1, new int[arr.length][arr.length]));

		System.out.println(wildCardMatching("abcdef", "?a*"));

		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static int fibTD(int n, int[] strg) {

		if (n == 0 || n == 1) {
			return n;
		}

		// use
		if (strg[n] != 0) {
			return strg[n];
		}

		int fnm1 = fibTD(n - 1, strg);
		int fnm2 = fibTD(n - 2, strg);

		int fn = fnm1 + fnm2;

		// store
		strg[n] = fn;

		return fn;

	}

	public static int fibBU(int n) {

		int[] strg = new int[n + 1];
		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	public static int fibBUSE(int n) {

		int[] strg = new int[2];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 1; i <= n - 1; i++) {

			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;

		}

		return strg[1];

	}

	public static int boardPathTD(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += boardPathTD(curr + dice, end, strg);
		}

		strg[curr] = count;

		return count;
	}

	public static int boardPathBU(int n) {

		int[] strg = new int[n + 6];
		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {

			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}

		return strg[0];

	}

	public static int boardPathBUSE(int n) {

		int[] strg = new int[6];
		strg[0] = 1;

		for (int slide = 1; slide <= n; slide++) {

			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];

			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];

			strg[0] = sum;

		}

		return strg[0];
	}

	public static int mazePath(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = mazePath(cr, cc + 1, er, ec, strg);
		int cv = mazePath(cr + 1, cc, er, ec, strg);

		strg[cr][cc] = ch + cv;

		return ch + cv;
	}

	public static int mazePathBU(int er, int ec) {

		// int[][] strg = new int[er + 1][ec + 1];
		//
		// for (int row = er; row >= 0; row--) {
		//
		// for (int col = ec; col >= 0; col--) {
		//
		// if (row == er || col == ec) {
		// strg[row][col] = 1;
		// } else {
		// strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
		// }
		// }
		// }

		int[][] strg = new int[er + 2][ec + 2];

		for (int row = er; row >= 0; row--) {

			for (int col = ec; col >= 0; col--) {

				if (row == er && col == ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
				}
			}
		}

		return strg[0][0];
	}

	public static int mazePathBUSE(int er, int ec) {

		int[] strg = new int[ec + 1];
		Arrays.fill(strg, 1);

		for (int slide = er - 1; slide >= 0; slide--) {

			for (int col = ec; col >= 0; col--) {

				if (col == ec) {
					strg[col] = 1;
				} else {
					strg[col] = strg[col] + strg[col + 1];
				}
			}
		}

		return strg[0];

	}

	public static int mazePathBUSEDiag(int er, int ec) {

		int[] strg = new int[ec + 1];
		Arrays.fill(strg, 1);

		int diag = 0;

		for (int slide = er - 1; slide >= 0; slide--) {

			for (int col = ec; col >= 0; col--) {

				if (col == ec) {
					strg[col] = 1;
					diag = 1;
				} else {
					int sum = strg[col] + strg[col + 1] + diag;
					diag = strg[col];
					strg[col] = sum;
				}
			}
		}

		return strg[0];

	}

	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);

		char ch2 = s2.charAt(0);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {
			ans = Math.max(LCS(ros1, s2), LCS(s1, ros2));
		}

		return ans;
	}

	public static int LCSBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {

			for (int col = s2.length() - 1; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
				} else {
					strg[row][col] = Math.max(strg[row + 1][col], strg[row][col + 1]);
				}
			}

		}

		return strg[0][0];

	}

	public static int EditDistance(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);

		char ch2 = s2.charAt(0);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);
		} else {

			int insert = EditDistance(ros1, s2);
			int delete = EditDistance(s1, ros2);
			int replace = EditDistance(ros1, ros2);

			ans = Math.min(replace, Math.min(insert, delete)) + 1;

		}

		return ans;

	}

	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {

			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
					continue;
				}

				if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
					continue;
				}

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {

					int insert = strg[row + 1][col];
					int delete = strg[row][col + 1];
					int replace = strg[row + 1][col + 1];

					strg[row][col] = Math.min(replace, Math.min(insert, delete)) + 1;

				}

			}
		}

		return strg[0][0];

	}

	public static int WineProblem(int[] price, int si, int ei, int yr) {

		if (si == ei) {
			return price[si] * yr;
		}

		int sc = WineProblem(price, si + 1, ei, yr + 1) + price[si] * yr;
		int ec = WineProblem(price, si, ei - 1, yr + 1) + price[ei] * yr;

		int ans = Math.max(sc, ec);

		return ans;

	}

	public static int WineProblemTD(int[] price, int si, int ei, int[][] strg) {

		int yr = price.length - (ei - si);

		if (si == ei) {
			return price[si] * yr;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int sc = WineProblemTD(price, si + 1, ei, strg) + price[si] * yr;
		int ec = WineProblemTD(price, si, ei - 1, strg) + price[ei] * yr;

		int ans = Math.max(sc, ec);

		strg[si][ei] = ans;

		return ans;

	}

	public static int WineProblemBU(int[] price) {

		int n = price.length;

		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n; slide++) {

			for (int si = 0; si <= n - slide; si++) {

				int ei = si + slide - 1;

				int yr = n - (ei - si);

				if (si == ei) {
					strg[si][ei] = price[si] * yr;
				} else {

					int sc = strg[si + 1][ei] + price[si] * yr;
					int ec = strg[si][ei - 1] + price[ei] * yr;

					int ans = Math.max(sc, ec);

					strg[si][ei] = ans;

				}

			}
		}

		return strg[0][n - 1];

	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {

		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int fc = MCMTD(arr, si, k, strg);
			int sc = MCMTD(arr, k, ei, strg);

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fc + sc + sw;

			if (total < min) {
				min = total;
			}

		}

		strg[si][ei] = min;
		return min;

	}

	public static int MCMBU(int[] arr) {

		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				if (si + 1 == ei) {
					strg[si][ei] = 0;
				} else {
					int min = Integer.MAX_VALUE;

					for (int k = si + 1; k <= ei - 1; k++) {

						int fc = strg[si][k];
						int sc = strg[k][ei];

						int sw = arr[si] * arr[k] * arr[ei];

						int total = fc + sc + sw;

						if (total < min) {
							min = total;
						}

					}

					strg[si][ei] = min;
				}

			}

		}

		return strg[0][n - 1];

	}

	public static int Knapsack(int[] wt, int[] price, int vidx, int cap, int[][] strg) {

		if (vidx == wt.length) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		int include = 0;

		if (cap >= wt[vidx]) {
			include = Knapsack(wt, price, vidx + 1, cap - wt[vidx], strg) + price[vidx];
		}

		int exclude = Knapsack(wt, price, vidx + 1, cap, strg);

		int max = Math.max(include, exclude);

		strg[vidx][cap] = max;

		return max;

	}

	public static int KnapsackBU(int[] wt, int[] price, int cap) {

		int nr = wt.length + 1;
		int nc = cap + 1;

		int[][] strg = new int[nr][nc];

		for (int row = 0; row < nr; row++) {

			for (int col = 0; col < nc; col++) {

				if (row == 0 || col == 0) {
					strg[row][col] = 0;
				} else {

					int include = 0;
					if (col >= wt[row - 1]) {
						include = price[row - 1] + strg[row - 1][col - wt[row - 1]];
					}

					int exclude = strg[row - 1][col];

					int max = Math.max(include, exclude);

					strg[row][col] = max;

				}

			}
		}

		return strg[nr - 1][nc - 1];
	}

	public static int color(int[] arr, int si, int ei) {

		int sum = 0;
		for (int i = si; i <= ei; i++) {
			sum += arr[i];
		}

		return sum % 100;
	}

	public static int Mixtures(int[] arr, int si, int ei, int[][] strg) {

		if (si == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int fc = Mixtures(arr, si, k, strg);
			int sc = Mixtures(arr, k + 1, ei, strg);

			int sw = color(arr, si, k) * color(arr, k + 1, ei);

			int total = fc + sc + sw;

			if (total < min) {
				min = total;
			}
		}

		strg[si][ei] = min;
		return min;

	}

	public static boolean wildCardMatching(String src, String pattern) {

		if (src.length() == 0 && pattern.length() == 0) {
			return true;
		}

		if (src.length() != 0 && pattern.length() == 0) {
			return false;
		}

		if (src.length() == 0 && pattern.length() != 0) {
			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*') {
					return false;
				}
			}

			return true;

		}

		char chsrc = src.charAt(0);
		char chpattern = pattern.charAt(0);

		String rossrc = src.substring(1);
		String rospattern = pattern.substring(1);

		boolean ans;

		if (chpattern == '*') {
			ans = wildCardMatching(src, rospattern) || wildCardMatching(rossrc, pattern);
		} else if (chpattern == chsrc || chpattern == '?') {
			ans = wildCardMatching(rossrc, rospattern);
		} else {
			ans = false;
		}

		return ans;

	}

}
