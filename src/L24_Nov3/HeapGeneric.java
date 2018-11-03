package L24_Nov3;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Nov-2018
 *
 */

public class HeapGeneric<T extends Comparable<T>> {

	private ArrayList<T> data = new ArrayList<>();

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void add(T item) {

		this.data.add(item);
		upheapify(this.data.size() - 1);
	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (isLarger(data.get(ci), data.get(pi)) > 0) {
			swap(pi, ci);
			upheapify(pi);

		}

	}

	private void swap(int i, int j) {

		T ith = this.data.get(i);
		T jth = this.data.get(j);

		data.set(i, jth);
		data.set(j, ith);

	}

	public T remove() {

		swap(0, this.data.size() - 1);
		T rv = this.data.remove(data.size() - 1);

		downheapify(0);
		return rv;

	}

	private void downheapify(int pi) {

		int mini = pi;

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		if (lci < data.size() && isLarger(data.get(lci), data.get(mini)) > 0) {
			mini = lci;
		}

		if (rci < data.size() && isLarger(data.get(rci), data.get(mini)) > 0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(pi, mini);
			downheapify(mini);
		}
	}

	public T getHP() {
		return this.data.get(0);
	}

	public void display() {
		System.out.println(data);
	}

	public int isLarger(T t, T o) {
		return t.compareTo(o);
	}

}
