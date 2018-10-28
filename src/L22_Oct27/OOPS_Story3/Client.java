package L22_Oct27.OOPS_Story3;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 27-Oct-2018
 *
 */

public class Client {

	public static void main(String[] args) {

		Student s = new Student("A");
		Student s1 = new Student("B");

		// System.out.println(s.rollNo);
		// System.out.println(s1.rollNo);

		System.out.println(Student.noOfStudents);

		// System.out.println(s1.getRollNo());
		
		Client c = new Client() ;
		abc a = c.new abc() ;
	}

	class abc {

	}

}
