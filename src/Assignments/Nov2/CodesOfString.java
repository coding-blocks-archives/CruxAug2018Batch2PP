package Assignments.Nov2;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Nov-2018
 *
 */

public class CodesOfString {

	public static void main(String[] args) {

		System.out.println(CodesOfString("1125", ""));
	}

	public static ArrayList<String> CodesOfString(String ques, String ans) {

		if (ques.length() == 0) {
			// System.out.println(ans);
			ArrayList<String> br = new ArrayList<>();
			br.add("") ;
			return br;
		}

		String ch1 = ques.substring(0, 1);
		Integer intch1 = Integer.valueOf(ch1);
		char charch1 = (char) (intch1 + 'a' - 1);

		ArrayList<String> mr = new ArrayList<>() ;
		
		ArrayList<String> rr1 = CodesOfString(ques.substring(1), ans + charch1);

		for (String rrs1 : rr1) {
			mr.add(charch1 + rrs1);
		}

		if (ques.length() >= 2) {

			String ch2 = ques.substring(0, 2);
			Integer intch2 = Integer.valueOf(ch2);

			if (intch2 <= 26) {
				char charch2 = (char) (intch2 + 'a' - 1);
				ArrayList<String> rr2 = CodesOfString(ques.substring(2), ans + charch2);
				
				for (String rrs2 : rr2) {
					mr.add(charch2 + rrs2);
				}


			}

		}

		return mr ;
	}

}
