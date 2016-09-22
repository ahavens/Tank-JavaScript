/**
 * Second test of the Vehicle with the errors in place
 * @author aurora havens
 * @version 2.0
 */
public class Vehicle {

	public int posX;
	public int posY;
	public int speed;
	public int dir;
	
	/**
	 * Constructor in Vehicle which accepts two parameters
	 * @param x		x location of car on map
	 * @param y		y location of car on map
	 */
	public Vehicle(int x, int y)
	{
		this(x,y,0);
	}
	
	/**
	 * Constructor in Vehicle which accepts three parameters
	 * @param x
	 * @param y
	 * @param dir
	 */
	public Vehicle(int x, int y, int dir)
	{
		this.posX = x;
		this.posY = y;
		this.speed = 0;
		this.dir = dir;
	}
	
	/**
	 * Constructor in Vehicle with no parameters
	 */
	public Vehicle()
	{
		this(0,0,0);
	}
	
	/**
	 * incSpeed increases the speed by the amount, but only up to 2
	 * @param amt		amount to increase the speed by
	 */
	public void incSpeed(int amt)
	{
		speed = speed + amt;
	}
	
	/**
	 * decSpeed decreases the speed by the amount but only down to -1
	 * @param amt		amount to decrease the speed by
	 */
	public void decSpeed(int amt)
	{
		speed = speed - amt;
	}
	
	/**
	 * Turn method turns the car by amt but can only return directions of 0 to 7
	 * @param amt		amount to turn the car
	 */
	public void turn(int amt)
	{
		dir = (dir+amt) % 9;
	}
	
	/**
	 * Method to determine the distance between
	 * @param x
	 * @param y
	 * @return
	 */
	public double distance(int x, int y)
	{
		return (double)x+y;
	}
}

