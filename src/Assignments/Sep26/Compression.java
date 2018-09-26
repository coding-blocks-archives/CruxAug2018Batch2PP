package Assignments.Sep26;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Sep-2018
 *
 */

public class Compression {

	public static void main(String[] args) {

		String str = "aaaaabbccddeaa";
		int count = 1;
		String ans = "";

		for (int i = 0; i < str.length() - 1; i++) {

			if (str.charAt(i) == str.charAt(i + 1)) {
				count++;
			} else {
				ans += str.charAt(i);

				if (count != 1) {
					ans += count;
				}

				count = 1;
			}

		}

		ans += str.charAt(str.length() - 1);

		if (count != 1) {
			ans += count;
		}

		System.out.println(ans);
	}

}
