import java.util.Random;


/**
 * @author Charlie Splittstoser
 */
public class Logic {

	
	/**
	 * Variables:
	 * currentNumber = current number displayed on screen
	 * lastNumber = the previous number that we are comparing the current number to
	 * points = the total amount of points a player currently has
	 */
	Random r = new Random();
	int currentNumber = r.nextInt(100) + 1;
	int lastNumber;
	int points = 0;
		
	
	/**
	 * Returns players current points
	 */
	int getPoints() {
		return points;
	}
	
	
	/**
	 * 	Determines if the player won or lost
	 * @param high - if high is true, high button was pressed. If false, low button was pressed.
	 */
	boolean won(boolean high) {
		if (high && currentNumber > lastNumber || !high && currentNumber < lastNumber) {
			return true;
		}
		return false;
	}
}
