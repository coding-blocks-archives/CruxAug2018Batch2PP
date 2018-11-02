package L23_Oct28.GenericFxn;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Oct-2018
 *
 */

public class Car  {

	int speed;
	int price;
	String color;

	public Car(int speed, int price, String color) {
		this.speed = speed;
		this.price = price;
		this.color = color;
	}

	@Override
	public String toString() {
		return "S:" + this.speed + " P:" + this.price + " C:" + this.color;
	}

	// @Override
	// public int compareTo(Car other) {
	// // return this.speed - other.speed;
	// // return other.price - this.price;
	// return this.color.compareTo(other.color);
	// }

}
