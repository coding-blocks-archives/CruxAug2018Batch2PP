package L23_Oct28.GenericClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Oct-2018
 *
 */

public class GenericClassDemo {

	public static void main(String[] args) {

		Pair<ArrayList<Integer>, Double> p = new Pair<>();
		p.one = new ArrayList<>();
		p.one.add(10);
		p.one.add(20);
		System.out.println(p.one);
		System.out.println(p.two);

		Pair<Pair<Integer, String>, Pair<Character, Double>> p1 = new Pair<>();
		p1.one = new Pair<>();
		p1.one.one = 10;
		p1.one.two = "abc";

		// System.out.println(p1.two.two);

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.get(0).add(10);
		list.get(0).add(20);
		list.get(1).add(30);
		list.get(1).add(40);
		System.out.println(list);

		LinkedListGeneric<ArrayList<Integer>> ll = new LinkedListGeneric<>();
		// ll.addLast("abc");
		// ll.addLast("def");
		// ll.addFirst("xyz");

		ll.addLast(list.get(0));
		ll.addLast(list.get(1));
		ll.display();
		
		// array of generics
		LinkedListGeneric<Integer> list2 = new LinkedListGeneric<>() ;		
		LinkedListGeneric<Integer>[] arrrr = new LinkedListGeneric[5] ;
		arrrr[0] = list2 ;
		
		System.out.println(arrrr[0]);
		
	}

}
