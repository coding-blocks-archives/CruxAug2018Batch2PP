package L24_Nov3;

import java.util.ArrayList;

import L23_Oct28.GenericFxn.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Nov-2018
 *
 */

public class HeapClient {

	public static void main(String[] args) {

		Heap heap = new Heap();

		for (int i = 5; i >= 1; i--) {
			heap.add(i * 10);
			heap.display();
		}

		while (!heap.isEmpty()) {
			System.out.println(heap.remove());
			heap.display();
		}

		HeapGeneric<Car> heapg = new HeapGeneric<>();

		Car[] carr = new Car[5];

		carr[0] = new Car(100, 50, "Black");
		carr[1] = new Car(200, 20, "Grey");
		carr[2] = new Car(6, 10, "White");
		carr[3] = new Car(120, 5, "Red");
		carr[4] = new Car(900, 88, "Blue");

		for (int i = 0; i < carr.length; i++) {
			heapg.add(carr[i]);
		}

		while (!heapg.isEmpty()) {
			System.out.println(heapg.remove());
		}

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(2);
		list1.add(3);
		list1.add(5);
		list1.add(10);
		list1.add(15);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(15);
		list2.add(100);
		list2.add(200);
		list2.add(300);
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(6);
		list3.add(8);
		list3.add(9);
		list3.add(10);

		lists.add(list1);
		lists.add(list2);
		lists.add(list3);

		System.out.println(mergeKSortedList(lists));

		ArrayList<Integer> list = new ArrayList<>();

		list.add(10);
		list.add(100);
		list.add(20);
		list.add(30);
		list.add(5);

		System.out.println(KLargestElements(list, 3));

	}

	public static class Pair implements Comparable<Pair> {
		int data;
		int listNo;
		int indexNo;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}
	}

	public static ArrayList<Integer> mergeKSortedList(ArrayList<ArrayList<Integer>> lists) {

		ArrayList<Integer> ans = new ArrayList<>();

		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < lists.size(); i++) {

			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.listNo = i;
			np.indexNo = 0;

			heap.add(np);
		}

		while (!heap.isEmpty()) {

			Pair rp = heap.remove();
			ans.add(rp.data);

			// update the removed pair
			rp.indexNo++;
			if (rp.indexNo < lists.get(rp.listNo).size()) {
				rp.data = lists.get(rp.listNo).get(rp.indexNo);
				heap.add(rp);
			}

		}

		return ans;
	}

	public static ArrayList<Integer> KLargestElements(ArrayList<Integer> list, int k) {

		ArrayList<Integer> ans = new ArrayList<>();

		Heap heap = new Heap();

		for (int i = 0; i < k; i++) {
			heap.add(list.get(i));
		}

		for (int i = k; i < list.size(); i++) {

			int min = heap.getHP();

			if (list.get(i) > min) {
				heap.remove();
				heap.add(list.get(i));
			}

		}

		while (!heap.isEmpty()) {
			ans.add(heap.remove());
		}

		return ans;

	}

}
