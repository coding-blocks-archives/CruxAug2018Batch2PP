package L14_Oct2.OOPS_Story1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Oct-2018
 *
 */

public class Client {

	public static void main(String[] args) {

		Student s = new Student();

		// get
		System.out.println(s.name);
		System.out.println(s.age);

		// set
		s.name = "Amit";
		s.age = 20;

		// get
		System.out.println(s.name);
		System.out.println(s.age);

		Student s1 = s;
		System.out.println(s1.name);
		s1.name = "Rohit";
		System.out.println(s1.name);
		System.out.println(s.name);

		Student s3 = new Student();
		s3.age = 10;
		s3.name = "A";

		Student s4 = new Student();
		s4.age = 20;
		s4.name = "B";

		System.out.println("\n-- Test 1 --");
		Test1(s3, s4);
		System.out.println(s3.age + " " + s3.name);
		System.out.println(s4.age + " " + s4.name);

		System.out.println("\n-- Test 2 --");
		Test2(s3, s4);
		System.out.println(s3.age + " " + s3.name);
		System.out.println(s4.age + " " + s4.name);

		System.out.println("\n-- Test 3 --");
		int myAge = 30;
		String myName = "C";

		Test3(s3, s4.age, s4.name, myAge, myName);
		System.out.println(s3.age + " " + s3.name);
		System.out.println(s4.age + " " + s4.name);
		System.out.println(myAge + " " + myName);

		System.out.println();
		s3.introduceYourself();
		s4.introduceYourself();
		s3.sayHi("Mohit");

		Student s5 = new Student("XYZ", 1000);
		s5.introduceYourself();

		Student s6 = new Student();
	}

	public static void Test3(Student p, int age, String name, int myAge, String myName) {
		p.age = 0;
		p.name = "_";
		age = 0;
		name = "_";
		myAge = 0;
		myName = "_";
	}

	public static void Test2(Student p1, Student p2) {

		p1 = new Student();
		int tempa = p1.age;
		p1.age = p2.age;
		p2.age = tempa;

		p2 = p1;
		String tempn = p1.name;
		p1.name = p2.name;
		p2.name = tempn;
	}

	public static void Test1(Student p1, Student p2) {
		Student temp = p1;
		p1 = p2;
		p2 = temp;
	}

}
