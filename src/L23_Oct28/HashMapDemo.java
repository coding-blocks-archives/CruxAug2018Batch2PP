package L23_Oct28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Oct-2018
 *
 */

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();

		// put -> O(1)
		map.put("India", 10);
		map.put("US", 20);
		map.put("UK", 30);

		System.out.println(map);
		map.put("US", 50);
		System.out.println(map);

		// get -> O(1)
		System.out.println(map.get("India"));
		System.out.println(map.get("Aus"));

		// containsKey -> O(1)
		System.out.println(map.containsKey("Aus"));
		System.out.println(map.containsKey("India"));

		// remove -> O(1)
		System.out.println(map.remove("India"));
		System.out.println(map.remove("Abc"));

		// keySet -> O(n)
		ArrayList<String> list = new ArrayList<>(map.keySet());
		System.out.println(list);

		Set<String> set = map.keySet();

		for (String key : set) {
			System.out.println(key + "->" + map.get(key));
		}
		
		
		int[] one = {10,10,20,20,20} ;
		int[] two = {10,10,10, 20,20} ;
		
		System.out.println(intersection(one, two));

	}

	public char maxFreqChar(String s) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (map.containsKey(ch)) {
				int of = map.get(ch);
				int nf = of + 1;
				map.put(ch, nf);

			} else {
				map.put(ch, 1);
			}

		}

		int max = Integer.MIN_VALUE;
		char ch = ' ';

		for (Character key : map.keySet()) {

			if (map.get(key) > max) {
				max = map.get(key);
				ch = key;
			}

		}

		return ch;

	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {

		ArrayList<Integer> ans = new ArrayList<>();

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < one.length; i++) {

			int val = one[i];
			if (map.containsKey(val)) {
				int of = map.get(val);
				int nf = of + 1;
				map.put(val, nf);

			} else {
				map.put(val, 1);
			}

		}

		for (int i = 0; i < two.length; i++) {

			int val = two[i];

			if (map.containsKey(val) && map.get(val) > 0) {

				ans.add(val);
				map.put(val, map.get(val) - 1);

			}
		}

		return ans;
	}

	public ArrayList<Integer> longestConsecutiveSeq(int[] arr) {

		ArrayList<Integer> ans = new ArrayList<>();

		return ans;

	}

}
