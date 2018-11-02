package L23_Oct28.GenericFxn;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Oct-2018
 *
 */

public class CarColorComparator implements Comparator<Car> {

	@Override
	public int compare(Car t, Car o) {
		return t.color.compareTo(o.color);
	}

}
