package L27_Nov11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Nov-2018
 *
 */

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private HashMap<String, Vertex> vtces = new HashMap<>();

	public int numVertex() {
		return vtces.size();
	}

	public boolean containsVertex(String vname) {
		return vtces.containsKey(vname);
	}

	public void addVertex(String vname) {

		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {

		Vertex vtx = vtces.get(vname); // 2k

		for (String nbr : vtx.nbrs.keySet()) {

			Vertex nbrVtx = vtces.get(nbr); // B : 3k
			nbrVtx.nbrs.remove(vname);
		}

		vtces.remove(vname);

	}

	public int numEdges() {

		int sum = 0;

		for (String key : vtces.keySet()) {

			Vertex vtx = vtces.get(key);
			sum += vtx.nbrs.size();

		}

		return sum / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void display() {

		System.out.println("--------------");

		for (String key : vtces.keySet()) {
			System.out.println(key + " -> " + vtces.get(key).nbrs);
		}

		System.out.println("--------------");
	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {

		processed.put(src, true);

		if (containsEdge(src, dst)) {
			return true;
		}

		Vertex vtx = vtces.get(src);
		for (String nbr : vtx.nbrs.keySet()) {

			if (!processed.containsKey(nbr) && hasPath(nbr, dst, processed)) {
				return true;
			}

		}

		return false;
	}

	private class Pair {

		String vname;
		String psf;

		String color;
	}

	public boolean bfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		// implement queue using ll
		LinkedList<Pair> queue = new LinkedList<>();

		// make a pair and put in queue
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		queue.addLast(sp);

		// work till queue is not empty
		while (!queue.isEmpty()) {

			// remove the first pair from queue
			Pair rp = queue.removeFirst();

			// ignore the second C
			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// procesesd put
			processed.put(rp.vname, true);

			// direct edge
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// loop on nbrs
			Vertex vtx = vtces.get(rp.vname);

			for (String nbr : vtx.nbrs.keySet()) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					queue.addLast(np);
				}

			}

		}

		return false;

	}

	public boolean dfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		// implement queue using ll
		LinkedList<Pair> stack = new LinkedList<>();

		// make a pair and put in queue
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		stack.addFirst(sp);

		// work till queue is not empty
		while (!stack.isEmpty()) {

			// remove the first pair from queue
			Pair rp = stack.removeFirst();

			// ignore the second C
			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// procesesd put
			processed.put(rp.vname, true);

			// direct edge
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// loop on nbrs
			Vertex vtx = vtces.get(rp.vname);

			for (String nbr : vtx.nbrs.keySet()) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					stack.addFirst(np);
				}

			}

		}

		return false;

	}

	public void bft() {

		HashMap<String, Boolean> processed = new HashMap<>();

		// implement queue using ll
		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// make a pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove the first pair from queue
				Pair rp = queue.removeFirst();

				// ignore the second C
				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// procesesd put
				processed.put(rp.vname, true);

				// syso
				System.out.println(rp.vname + " via " + rp.psf);

				// loop on nbrs
				Vertex vtx = vtces.get(rp.vname);

				for (String nbr : vtx.nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}

				}

			}
		}

	}

	public void dft() {

		HashMap<String, Boolean> processed = new HashMap<>();

		// implement queue using ll
		LinkedList<Pair> stack = new LinkedList<>();

		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// make a pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			stack.addFirst(sp);

			// work till queue is not empty
			while (!stack.isEmpty()) {

				// remove the first pair from queue
				Pair rp = stack.removeFirst();

				// ignore the second C
				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// procesesd put
				processed.put(rp.vname, true);

				// syso
				System.out.println(rp.vname + " via " + rp.psf);

				// loop on nbrs
				Vertex vtx = vtces.get(rp.vname);

				for (String nbr : vtx.nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						stack.addFirst(np);
					}

				}

			}
		}

	}

	public boolean isConnected() {

		int flag = 0;

		HashMap<String, Boolean> processed = new HashMap<>();

		// implement queue using ll
		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			flag++;

			// make a pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove the first pair from queue
				Pair rp = queue.removeFirst();

				// ignore the second C
				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// procesesd put
				processed.put(rp.vname, true);

				// loop on nbrs
				Vertex vtx = vtces.get(rp.vname);

				for (String nbr : vtx.nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}

				}

			}
		}

		return flag == 1;
	}

	public boolean isCyclic() {

		HashMap<String, Boolean> processed = new HashMap<>();

		// implement queue using ll
		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// make a pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove the first pair from queue
				Pair rp = queue.removeFirst();

				// ignore the second C
				if (processed.containsKey(rp.vname)) {
					return true;
				}

				// procesesd put
				processed.put(rp.vname, true);

				// loop on nbrs
				Vertex vtx = vtces.get(rp.vname);

				for (String nbr : vtx.nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}

				}

			}
		}

		return false;
	}

	public boolean isTree() {
		return isConnected() && !isCyclic();
	}

	public ArrayList<ArrayList<String>> getCC() {

		ArrayList<ArrayList<String>> ans = new ArrayList<>();

		HashMap<String, Boolean> processed = new HashMap<>();

		// implement queue using ll
		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			ArrayList<String> subans = new ArrayList<>();

			// make a pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove the first pair from queue
				Pair rp = queue.removeFirst();

				// ignore the second C
				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// procesesd put
				processed.put(rp.vname, true);

				subans.add(rp.vname);

				// loop on nbrs
				Vertex vtx = vtces.get(rp.vname);

				for (String nbr : vtx.nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}

				}

			}

			ans.add(subans);
		}

		return ans;
	}

	public boolean isBipartite() {

		HashMap<String, String> processed = new HashMap<>();

		// implement queue using ll
		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// make a pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.color = "r";

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove the first pair from queue
				Pair rp = queue.removeFirst();

				// ignore the second C
				if (processed.containsKey(rp.vname)) {

					String oc = processed.get(rp.vname);
					String nc = rp.color;

					if (!oc.equals(nc)) {
						return false;
					}

					continue;
				}

				// procesesd put
				processed.put(rp.vname, rp.color);

				// loop on nbrs
				Vertex vtx = vtces.get(rp.vname);

				for (String nbr : vtx.nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						String color = rp.color.equals("r") ? "g" : "r";
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.color = color;

						queue.addLast(np);
					}

				}

			}
		}

		return true;

	}
}
