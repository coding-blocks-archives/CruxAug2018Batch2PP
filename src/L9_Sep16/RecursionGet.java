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
		System.out.println(getPermutation("abc"));
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

}
