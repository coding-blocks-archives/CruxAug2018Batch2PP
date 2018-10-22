package Assignments.Hackathon;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 22-Oct-2018
 *
 */

public class CBNumber {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		scn.nextInt();

		String str = scn.next();

		int count = 0;
		boolean[] visited = new boolean[str.length()];

		for (int len = 1; len <= str.length(); len++) {

			for (int si = 0; si <= str.length() - len; si++) {

				int ei = si + len;

				String ss = str.substring(si, ei);

				if (isCBNo(Long.valueOf(ss)) && isValid(visited, si, ei)) {

					count++;

					for (int i = si; i < ei; i++) {
						visited[i] = true;
					}

				}
			}

		}

		System.out.println(count);

	}

	public static boolean isValid(boolean[] visited, int start, int end) {

		for (int i = start; i < end; i++) {
			if (visited[i]) {
				return false;
			}
		}

		return true;
	}

	public static boolean isCBNo(long n) {

		if (n == 0 || n == 1) {
			return false;
		}

		long[] arr = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

		for (int i = 0; i < arr.length; i++) {
			if (n == arr[i]) {
				return true;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (n % arr[i] == 0) {
				return false;
			}
		}

		return true;
	}

}
