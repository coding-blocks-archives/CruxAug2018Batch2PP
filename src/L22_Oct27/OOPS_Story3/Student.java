package L22_Oct27.OOPS_Story3;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 27-Oct-2018
 *
 */

public class Student {

	String name;
	int rollNo;
	static int noOfStudents;

	public Student(String name) {
		noOfStudents++;
		this.rollNo = noOfStudents;
		this.name = name;
	}

	// this cannot be accesed
	// static fxn cannot access non static variable
	// static fxn can access static variable
	public static int getNoOfStudents() {
		return noOfStudents;
	}

	public int getRollNo() {
		return noOfStudents;
	}

}
