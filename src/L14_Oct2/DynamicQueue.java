package L14_Oct2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 06-Oct-2018
 *
 */

public class DynamicQueue extends Queue {

	@Override
	public void enqueue(int item) throws Exception {

		if (isFull()) {
			int[] oa = this.data;
			int[] na = new int[2 * oa.length];

			for (int i = 0; i < this.size(); i++) {
				int idx = (i + this.front) % this.data.length;
				na[i] = oa[idx];
			}

			this.data = na;
			this.front = 0;

		}
		super.enqueue(item);
	}
}
