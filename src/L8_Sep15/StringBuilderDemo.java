package L8_Sep15;

/**
 * @author Garima Chhikara
 * @date Sep 15, 2018
 */

public class StringBuilderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		// String str = "hello" ;
		// str = str.replace('l', 'a') ;
		//
		// System.out.println(str);

		 long start = System.currentTimeMillis();
		 appendString();
		 long end = System.currentTimeMillis();
		 System.out.println(end - start);

		StringBuilder sb = new StringBuilder("hello");

		System.out.println(sb.length());

		sb.append("abc");
		System.out.println(sb);
		sb.append('d');
		System.out.println(sb);

		sb.insert(2, 'e');
		System.out.println(sb);

		sb.setCharAt(2, 'a');
		System.out.println(sb);

		sb.deleteCharAt(2);
		System.out.println(sb);

		String str = sb.toString();
		System.out.println(str);

	}

	public static void appendString() {

		// String str = "";
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 100000; i++) {
			// str += i;
			sb.append(i);
		}

	}

}
