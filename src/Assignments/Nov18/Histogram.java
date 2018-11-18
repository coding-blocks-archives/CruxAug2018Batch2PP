package Assignments.Nov18;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Nov-2018
 *
 */

public class Histogram {

	public static void main(String[] args) {

		// int[] arr = { 10, 40, 30, 70, 10, 30, 60 };

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		long[] arr = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextLong();
		}

		long maxArea = Long.MIN_VALUE;
		Stack<Integer> stack = new Stack<>();

		int i = 0;

		for (; i < arr.length;) {

			if (stack.isEmpty() || arr[i] > arr[stack.peek()]) {
				stack.push(i);
				i++;
			} else {

				int tp = stack.pop();

				long area = 0;

				if (stack.isEmpty()) {
					area = arr[tp] * i;
				} else {
					area = arr[tp] * (i - stack.peek() - 1);
				}

				if (area > maxArea) {
					maxArea = area;
				}
			}
		}

		while (!stack.isEmpty()) {
			int tp = stack.pop();

			long area = 0;

			if (stack.isEmpty()) {
				area = arr[tp] * i;
			} else {
				area = arr[tp] * (i - stack.peek() - 1);
			}

			if (area > maxArea) {
				maxArea = area;
			}
		}

		System.out.println(maxArea);
	}

}
