package L14_Oct2.OOPS_Story1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Oct-2018
 *
 */

public class Student {

	// data members
	String name = "Ram";
	int age = 1000;

	// default constructor
	public Student() {
		// this("abc", 90);
		System.out.println("in default con.");
	}

	// parametrised constructor
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void introduceYourself() {
		System.out.println(name + " is " + this.age + " years old");
	}

	public void sayHi(String name) {
		System.out.println(this.name + " says hi to " + name);
	}
}
