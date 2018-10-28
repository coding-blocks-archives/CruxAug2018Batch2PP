package L21_Oct24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Oct-2018
 *
 */

public class Client {

	public static void main(String[] args)  {
		System.out.println("hi");

		try {
			System.out.println("before");
			Student s = new Student();
			s.setAge(-10);
			System.out.println("after");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("in catch");
		} finally {
			System.out.println("in finally");
		}

		System.out.println("bye");

	}

}
