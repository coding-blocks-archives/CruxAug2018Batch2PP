package L18_Oct14;

import java.awt.HeadlessException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Oct-2018
 *
 */

public class BinaryTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		this.root = takeInput(null, false);
	}

	private Node takeInput(Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {

			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		int item = scn.nextInt();

		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + " has left child ?");
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			nn.left = takeInput(nn, true);
		}

		System.out.println(nn.data + " has right child ?");
		boolean hrc = scn.nextBoolean();

		if (hrc) {
			nn.right = takeInput(nn, false);
		}

		return nn;

	}

	public BinaryTree(int[] pre, int[] in) {

		this.root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		
		
	}

	public void display() {

		System.out.println("------------------");
		display(this.root);
		System.out.println("------------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(node.data, Math.max(lm, rm));

	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		boolean lf = find(node.left, item);
		boolean rf = find(node.right, item);

		return lf || rf;

	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;

	}

	// diameter : max distance possible b/w any two leaf nodes
	public int diameter() {
		return diameter(this.root);
	}

	private int diameter(Node node) {

		if (node == null) {
			return 0;
		}

		int ld = diameter(node.left);
		int rd = diameter(node.right);
		int sp = ht(node.left) + ht(node.right) + 2;

		return Math.max(sp, Math.max(ld, rd));

	}

	private class DiaPiar {
		int ht = -1;
		int diameter = 0;
	}

	public int diameter2() {
		return diameter2(this.root).diameter;
	}

	private DiaPiar diameter2(Node node) {

		if (node == null) {
			DiaPiar bp = new DiaPiar();
			return bp;
		}

		DiaPiar ldp = diameter2(node.left);
		DiaPiar rdp = diameter2(node.right);

		DiaPiar np = new DiaPiar();
		np.ht = Math.max(ldp.ht, rdp.ht) + 1;

		int ld = ldp.diameter;
		int rd = rdp.diameter;
		int sp = ldp.ht + rdp.ht + 2;

		np.diameter = Math.max(sp, Math.max(ld, rd));

		return np;

	}

	private class BalPair {

		int ht = -1;
		boolean isBal = true;
	}

	public boolean isBalanced() {

		return isBalanced(this.root).isBal;
	}

	private BalPair isBalanced(Node node) {

		if (node == null) {
			BalPair bp = new BalPair();
			return bp;
		}
		BalPair lbp = isBalanced(node.left);
		BalPair rbp = isBalanced(node.right);

		int bf = Math.abs(lbp.ht - rbp.ht);

		BalPair np = new BalPair();
		np.ht = Math.max(lbp.ht, rbp.ht) + 1;

		if (lbp.isBal && rbp.isBal && bf <= 1) {
			np.isBal = true;
		} else {
			np.isBal = false;
		}

		return np;
	}

	public void preorder() {
		preorder(this.root);
		System.out.println();
	}

	private void preorder(Node node) {

		if (node == null) {
			return;
		}

		// N
		System.out.print(node.data + " ");

		// L
		preorder(node.left);

		// R
		preorder(node.right);

	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node node) {

		if (node == null) {
			return;
		}

		// L
		postorder(node.left);

		// R
		postorder(node.right);

		// N
		System.out.print(node.data);

	}

	public void inorder() {
		inorder(this.root);
	}

	private void inorder(Node node) {

		if (node == null) {
			return;
		}

		// L
		inorder(node.left);

		// N
		System.out.print(node.data);

		// R
		inorder(node.right);

	}

	private class Pair {
		Node node;
		boolean selfDone;
		boolean leftDone;
		boolean rightDone;
	}

	public void preorderI() {

		LinkedList<Pair> stack = new LinkedList<>();
		Pair sp = new Pair();
		sp.node = this.root;
		stack.addFirst(sp);

		while (!stack.isEmpty()) {

			Pair tp = stack.getFirst();

			if (tp.node == null) {
				stack.removeFirst();
				continue;
			}

			if (tp.selfDone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfDone = true;
			} else if (tp.leftDone == false) {
				Pair np = new Pair();
				np.node = tp.node.left;
				stack.addFirst(np);

				tp.leftDone = true;
			} else if (tp.rightDone == false) {

				Pair np = new Pair();
				np.node = tp.node.right;
				stack.addFirst(np);

				tp.rightDone = true;
			} else {
				stack.removeFirst();
			}

		}

		System.out.println();

	}

}
