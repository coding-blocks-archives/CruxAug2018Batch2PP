package L14_Oct2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 06-Oct-2018
 *
 */

public class DynamicStack extends Stack {

	@Override
	public void push(int item) throws Exception {

		if (isFull()) {

			int[] oa = this.data;
			int[] na = new int[oa.length * 2];

			for (int i = 0; i < oa.length; i++) {
				na[i] = oa[i];
			}

			this.data = na;

		}

		super.push(item);

	}

}
