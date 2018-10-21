package L18_Oct14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Oct-2018
 *
 */

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {

		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
		this.root = takeInput(null, -1);
	}

	private Node takeInput(Node parent, int ith) {

		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data);
		}

		int item = scn.nextInt();

		// create a new node
		Node nn = new Node();
		nn.data = item;

		System.out.println("No of children for " + nn.data);
		int noc = scn.nextInt();

		for (int i = 0; i < noc; i++) {
			Node child = takeInput(nn, i);
			nn.children.add(child);
		}

		return nn;

	}

	public void display() {

		System.out.println("---------------------");
		display(this.root);
		System.out.println("---------------------");

	}

	private void display(Node node) {

		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + ", ";
		}

		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		int ts = 0;

		for (Node child : node.children) {
			int cs = size(child);
			ts += cs;
		}

		return ts + 1;

	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		int tm = node.data;

		for (Node child : node.children) {
			int cm = max(child);

			if (cm > tm) {
				tm = cm;
			}
		}

		return tm;

	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {

		int th = -1;

		for (Node child : node.children) {
			int ch = height(child);

			if (ch > th) {
				th = ch;
			}
		}

		return th + 1;
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {
			boolean res = find(child, item);

			if (res) {
				return true;
			}
		}

		return false;
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {

		for (Node child : node.children) {
			mirror(child);
		}

		int left = 0;
		int right = node.children.size() - 1;

		while (left < right) {

			Node ln = node.children.get(left);
			Node rn = node.children.get(right);

			node.children.set(left, rn);
			node.children.set(right, ln);

			left++;
			right--;
		}

	}

	public void display1() {
		display1(this.root);
	}

	private void display1(Node node) {

		System.out.println("hii " + node.data);

		for (Node child : node.children) {
			System.out.println("going towards " + child.data);
			display1(child);
			System.out.println("coming back from " + child.data);
		}

		System.out.println("bye " + node.data);

	}

	// Node Child
	public void preorder() {
		preorder(this.root);
		System.out.println();

	}

	private void preorder(Node node) {

		System.out.print(node.data + " ");

		for (Node child : node.children) {
			preorder(child);
		}

	}

	// Child Node
	public void postorder() {
		postorder(this.root);
		System.out.println();

	}

	private void postorder(Node node) {

		for (Node child : node.children) {
			postorder(child);
		}

		System.out.print(node.data + " ");

	}

	public void levelOrder() {

		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			// remove the node
			Node rn = queue.removeFirst();

			// print
			System.out.print(rn.data + " ");

			// child
			for (Node child : rn.children)
				queue.addLast(child);
		}

		System.out.println();

	}

	public void levelOrderLW() {

		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		primary.addLast(this.root);

		while (!primary.isEmpty()) {

			Node rn = primary.removeFirst();

			// print
			System.out.print(rn.data + " ");

			// child
			for (Node child : rn.children) {
				helper.addLast(child);
			}

			if (primary.isEmpty()) {
				System.out.println();

				primary = helper;
				helper = new LinkedList<>();
			}

		}

	}

	public void levelOrderZZ() {

		int count = 0;

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();

		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			// print
			System.out.print(rn.data + " ");

			// child
			if (count % 2 == 0) {
				for (int i = 0; i < rn.children.size(); i++) {
					stack.addFirst(rn.children.get(i));
				}
			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					stack.addFirst(rn.children.get(i));
				}
			}

			if (queue.isEmpty()) {

				System.out.println();
				count++;
				queue = stack;
				stack = new LinkedList<>();
			}

		}

	}

	public void printAtLevel(int level) {

		printAtLevel(root, 0, level);
		System.out.println();
	}

	private void printAtLevel(Node node, int count, int level) {

		if (count == level) {
			System.out.print(node.data + " ");
			return;
		}

		for (Node child : node.children) {
			printAtLevel(child, count + 1, level);
		}

	}

	private class HeapMover {
		int size;
		int ht;
		int max = Integer.MIN_VALUE;
		boolean find;

		Node succ;
		Node pred;
		Node jl;
	}

	public void multiSolver(int item) {

		HeapMover mover = new HeapMover();

		multiSolver(this.root, mover, item, 0);

		System.out.println("Max : " + mover.max);
		System.out.println("Size : " + mover.size);
		System.out.println("Find : " + mover.find);
		System.out.println("Ht : " + mover.ht);

		System.out.println("Pred : " + (mover.pred == null ? null : mover.pred.data));
		System.out.println("Succ : " + (mover.succ == null ? null : mover.succ.data));
		System.out.println("JL : " + (mover.jl == null ? null : mover.jl.data));

	}

	private void multiSolver(Node node, HeapMover mover, int item, int count) {

		mover.size++;

		if (mover.find == true && mover.succ == null) {
			mover.succ = node;
		}

		if (node.data == item) {
			mover.find = true;
		}

		if (mover.find == false) {
			mover.pred = node;
		}

		if (count > mover.ht) {
			mover.ht = count;
		}

		if (node.data > mover.max) {
			mover.max = node.data;
		}

		if (node.data > item) {

			if (mover.jl == null || node.data < mover.jl.data) {
				mover.jl = node;
			}

		}

		for (Node child : node.children) {
			multiSolver(child, mover, item, count + 1);
		}

	}

	public boolean isMirror(GenericTree other) {
		return isMirror(this.root, other.root);
	}

	private boolean isMirror(Node tnode, Node onode) {

		if (tnode.children.size() != onode.children.size()) {
			return false;
		}

		for (int i = 0; i < tnode.children.size(); i++) {

			Node tn = tnode.children.get(i);
			Node on = onode.children.get(tnode.children.size() - i - 1);

			if (!isMirror(tn, on)) {
				return false;
			}

		}

		return true;

	}

}
