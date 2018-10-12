package Assignments.Oct11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Oct-2018
 *
 */

public class Painter {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nop = scn.nextInt();

		int nob = scn.nextInt();

		int[] board = new int[nob];

		for (int i = 0; i < board.length; i++) {
			board[i] = scn.nextInt();
		}

		System.out.println(ac(board, nop, nob));

	}

	public static int ac(int[] pages, int nop, int nob) {

		int lo = 0;

		int hi = 0;

		for (int val : pages) {
			hi += val;
		}

		int finalAns = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isPossible(pages, nop, nob, mid)) {
				hi = mid - 1;
				finalAns = mid;
			} else {
				lo = mid + 1;
			}

		}

		return finalAns;

	}

	private static boolean isPossible(int[] board, int nop, int nob, int mid) {

		int painters = 1;
		int timeReamining = mid;

		// i denotes no of boards painted
		int i = 0;

		while (i < board.length && painters <= nop) {

			if (board[i] <= timeReamining) {
				timeReamining -= board[i];
				i++;
			} else {
				painters++;
				timeReamining = mid;
			}

		}

		return i == board.length;

	}

}
