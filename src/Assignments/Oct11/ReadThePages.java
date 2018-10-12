package Assignments.Oct11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Oct-2018
 *
 */

public class ReadThePages {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nob = scn.nextInt();

		int nos = scn.nextInt();

		int[] pages = new int[nob];

		for (int i = 0; i < pages.length; i++) {
			pages[i] = scn.nextInt();
		}

		System.out.println(ac(pages, nob, nos));

	}

	public static int ac(int[] pages, int nob, int nos) {

		int lo = 0;

		int hi = 0;

		for (int val : pages) {
			hi += val;
		}

		int finalAns = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isPossible(pages, nob, nos, mid)) {
				hi = mid - 1;
				finalAns = mid;
			} else {
				lo = mid + 1;
			}

		}

		return finalAns;

	}

	private static boolean isPossible(int[] pages, int nob, int nos, int mid) {

		int noOfStudents = 1;
		int pagesRead = 0;

		for (int i = 0; i < pages.length; i++) {

			if (pages[i] > mid) {
				return false;
			}

			if (pagesRead + pages[i] <= mid) {
				pagesRead += pages[i];
			} else {
				noOfStudents++;
				pagesRead = pages[i];

				if (noOfStudents > nos) {
					return false;
				}
			}
		}

		return true;

	}

}
