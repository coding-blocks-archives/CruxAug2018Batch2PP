package Assignments.Nov18;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Nov-2018
 *
 */

public class MurthalPratha {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in) ;
		
		int np = scn.nextInt() ;
		
		int l = scn.nextInt() ;
		
		int[] rank = new int[l] ;
		for(int i=0 ; i < l ; i++) {
			rank[i] = scn.nextInt() ;
		}
		
		mp(rank, np, l);

	}

	public static void mp(int[] rank, int np, int nc) {

		int lo = 0;
		int hi = Integer.MAX_VALUE;

		int ans = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isPossible(rank, np, mid)) {
				hi = mid - 1;
				ans = mid;
			} else {
				lo = mid + 1;
			}

		}

		System.out.println(ans);

	}

	private static boolean isPossible(int[] rank, int np, int mid) {

		for (int i = 0; i < rank.length; i++) {

			int count = 1;
			int time = 0;

			while (time + count * rank[i] <= mid && np > 0) {

				time += count * rank[i];
				count++;
				np--;
			}

			if (np == 0) {
				return true;
			}

		}

		return false;
	}

}
