package Assignments.Nov18;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Nov-2018
 *
 */

public class CoinChange {

	public static void main(String[] args) {

		int[] coins = { 2, 3, 5, 6 };
		System.out.println(cc(coins, 10, 0));
		System.out.println(ccBU(coins, 10));

	}

	public static int cc(int[] coins, int amount, int vidx) {

		if (amount == 0) {
			return 1;
		}

		if (amount < 0 || vidx == coins.length) {
			return 0;
		}

		int exclude = cc(coins, amount, vidx + 1);
		int include = cc(coins, amount - coins[vidx], vidx);

		int ans = include + exclude;

		return ans;

	}

	public static int ccTD(int[] coins, int amount, int vidx, int[][] strg) {

		if (amount == 0) {
			return 1;
		}

		if (amount < 0 || vidx == coins.length) {
			return 0;
		}

		if (strg[vidx][amount] != 0) {
			return strg[vidx][amount];
		}

		int exclude = ccTD(coins, amount, vidx + 1, strg);
		int include = ccTD(coins, amount - coins[vidx], vidx, strg);

		int ans = include + exclude;

		strg[vidx][amount] = ans;
		return ans;

	}

	public static int ccBU(int[] coins, int amount) {

		int[] strg = new int[amount + 1];
		strg[0] = 1;

		for (int coin : coins) {

			for (int i = coin; i < strg.length; i++) {
				strg[i] += strg[i - coin];
			}
		}

		return strg[amount];
	}

}
