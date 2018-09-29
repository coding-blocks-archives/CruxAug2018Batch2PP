package L12_Sep29;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Sep-2018
 *
 */

public class RecursionSorting {

	public static void main(String[] args) {

//		int[] one = { 10, 20, 30, 40, 50 };
//		int[] two = { 5, 12, 17, 20, 25, 60, 70, 80 };
//
//		int[] ans = mergeTwoSortedArrays(one, two);
//
//		for (int val : ans) {
//			System.out.println(val);
//		}

		int[] arr = { 50, 20, 1, 3, 7, 8, 122, 98 };
//		int[] ans = mergeSort(arr, 0, arr.length - 1);

		quickSort(arr, 0, arr.length - 1);
		for (int val : arr) {
			System.out.println(val);
		}

	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {

		int[] merged = new int[one.length + two.length];

		int i = 0;
		int j = 0;
		int k = 0;

		// work till both are in limits
		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				merged[k] = one[i];
				i++;
				k++;
			} else {
				merged[k] = two[j];
				j++;
				k++;
			}

		}

		// if one is finished then loop on two
		if (i == one.length) {
			while (j < two.length) {
				merged[k] = two[j];
				j++;
				k++;
			}
		}

		if (j == two.length) {
			while (i < one.length) {
				merged[k] = one[i];
				i++;
				k++;
			}
		}

		return merged;

	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid + 1, hi);

		int[] sorted = mergeTwoSortedArrays(fh, sh);

		return sorted;

	}

	public static void quickSort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		// partitioning
		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		int left = lo;
		int right = hi;

		while (left <= right) {

			// left
			while (arr[left] < pivot) {
				left++;
			}

			// right
			while (arr[right] > pivot) {
				right--;
			}

			// swap
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}
		}

		// smaller problem
		quickSort(arr, lo, right);
		quickSort(arr, left, hi);

	}

}
