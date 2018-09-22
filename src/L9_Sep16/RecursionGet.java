package L9_Sep16;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @date Sep 16, 2018
 */

public class RecursionGet {

	public static void main(String[] args) {
		//
		// String str = "";
		// System.out.println(str.length());
		//
		// ArrayList<String> list = new ArrayList<>();
		// System.out.println(list.size());
		//
		// list.add(str);
		// System.out.println(list.size());
		// System.out.println(list.get(0).length());

		// System.out.println(getSS("abc"));
		// System.out.println(getKPC("145"));
		// System.out.println(getPermutation("abc")

		// System.out.println(getBoardPath(0, 10));
		// System.out.println(getCoinToss(3));
		// System.out.println(getMazePathD(0, 0, 2, 2));

		int[][] blocked = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };

		System.out.println(getMazePathDMM(0, 0, 2, 2).size());
	}

	public static ArrayList<String> getSS(String str) {

		if (str.length() == 0) {

			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> recRes = getSS(ros);
		ArrayList<String> myRes = new ArrayList<>();

		for (String val : recRes) {
			myRes.add(val); // no
			myRes.add(ch + val); // yes
		}

		return myRes;

	}

	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static ArrayList<String> getKPC(String str) {

		if (str.length() == 0) {
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> recRes = getKPC(ros);
		ArrayList<String> myRes = new ArrayList<>();

		String code = getCode(ch);

		for (int i = 0; i < code.length(); i++) {

			for (String val : recRes) {
				myRes.add(code.charAt(i) + val);
			}
		}
		return myRes;

	}

	public static ArrayList<String> getPermutation(String str) {

		if (str.length() == 0) {
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> recRes = getPermutation(ros);
		ArrayList<String> myRes = new ArrayList<>();

		for (String val : recRes) {

			for (int i = 0; i <= val.length(); i++) {

				String ans = val.substring(0, i) + ch + val.substring(i);
				myRes.add(ans);

			}

		}

		return myRes;

	}

	public static ArrayList<String> getBoardPath(int curr, int end) {

		if (curr == end) {
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("\n");
			return baseRes;
		}

		if (curr > end) {
			ArrayList<String> baseRes = new ArrayList<>();
			return baseRes;
		}

		ArrayList<String> myRes = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> recRes = getBoardPath(curr + dice, end);
			for (String val : recRes) {
				myRes.add(dice + val);
			}
		}

		return myRes;
	}

	public static ArrayList<String> getCoinToss(int n) {

		if (n == 0) {
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}

		ArrayList<String> recRes = getCoinToss(n - 1);

		ArrayList<String> myRes = new ArrayList<>();

		for (String val : recRes) {
			myRes.add("H" + val);
			myRes.add("T" + val);
		}

		return myRes;

	}

	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> baseRes = new ArrayList<>();
			return baseRes;
		}

		ArrayList<String> myRes = new ArrayList<>();

		// if (cc < ec) {
		ArrayList<String> recResH = getMazePath(cr, cc + 1, er, ec);
		for (String val : recResH) {
			myRes.add("H" + val);
		}
		// }

		// if (cr < er) {
		ArrayList<String> recResV = getMazePath(cr + 1, cc, er, ec);
		for (String val : recResV) {
			myRes.add("V" + val);
		}
		// }

		return myRes;
	}

	public static ArrayList<String> getMazePathD(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> baseRes = new ArrayList<>();
			return baseRes;
		}

		ArrayList<String> myRes = new ArrayList<>();

		ArrayList<String> recResH = getMazePathD(cr, cc + 1, er, ec);
		for (String val : recResH) {
			myRes.add("H" + val);
		}

		ArrayList<String> recResV = getMazePathD(cr + 1, cc, er, ec);
		for (String val : recResV) {
			myRes.add("V" + val);
		}

		ArrayList<String> recResD = getMazePathD(cr + 1, cc + 1, er, ec);
		for (String val : recResD) {
			myRes.add("D" + val);
		}

		return myRes;
	}

	public static ArrayList<String> getMazePathDMM(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}

		ArrayList<String> myRes = new ArrayList<>();

		for (int move = 1; move <= ec - cc; move++) {
			ArrayList<String> recResH = getMazePathDMM(cr, cc + move, er, ec);
			for (String val : recResH) {
				myRes.add("H" + move + val);
			}
		}

		for (int move = 1; move <= er - cr; move++) {
			ArrayList<String> recResV = getMazePathDMM(cr + move, cc, er, ec);
			for (String val : recResV) {
				myRes.add("V" + move + val);
			}
		}

		for (int move = 1; move <= ec - cc && move <= er - cr; move++) {
			ArrayList<String> recResD = getMazePathDMM(cr + move, cc + move, er, ec);
			for (String val : recResD) {
				myRes.add("D" + move + val);
			}

		}
		return myRes;

	}

}
