package L26_Nov10.OOPS_Story4;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Nov-2018
 *
 */

// cannot extend final class
public class P {

	final int a;

	public P() {
		a = 4;
	}

	// cannot override final method
	public final void fun() {
		// a= 45 ;
	}
}
