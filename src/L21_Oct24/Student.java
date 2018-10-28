package L21_Oct24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Oct-2018
 *
 */

public class Student {

	private int age;

	public void setAge(int age) throws Exception {

		if (age < 0) {
			throw new Exception("Invalid Age.");
		}
		this.age = age;

	}

}
