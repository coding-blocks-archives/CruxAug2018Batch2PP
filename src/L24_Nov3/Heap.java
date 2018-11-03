package L24_Nov3;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Nov-2018
 *
 */

public class Heap {

	private ArrayList<Integer> data = new ArrayList<>();

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void add(int item) {

		this.data.add(item);
		upheapify(this.data.size() - 1);
	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (data.get(ci) < data.get(pi)) {
			swap(pi, ci);
			upheapify(pi);

		}

	}

	private void swap(int i, int j) {

		int ith = this.data.get(i);
		int jth = this.data.get(j);

		data.set(i, jth);
		data.set(j, ith);

	}

	public int remove() {

		swap(0, this.data.size() - 1);
		int rv = this.data.remove(data.size() - 1);

		downheapify(0);
		return rv;

	}

	private void downheapify(int pi) {

		int mini = pi;

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		if (lci < data.size() && data.get(lci) < data.get(mini)) {
			mini = lci;
		}

		if (rci < data.size() && data.get(rci) < data.get(mini)) {
			mini = rci;
		}

		if (mini != pi) {
			swap(pi, mini);
			downheapify(mini);
		}
	}

	public int getHP() {
		return this.data.get(0);
	}

	public void display() {
		System.out.println(data);
	}

}
