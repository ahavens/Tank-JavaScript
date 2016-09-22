/**
 * This class contains functions pertaining to the vehicle class, contains functions that change direction,
 * mess with speed, and find distance between locations
 * 
 * This class also has a main function that tests the code
 * 
 * @author Aurora Havens
 * @version 1.0
 */


public class VehicleOrig {
	
	/**
	 * Main function designed to run and test the program vehicle
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//create the new car
		VehicleOrig car = new VehicleOrig(2,1,0);
		
		//increase the speed
		car.incSpeed();
		car.incSpeed();
		car.incSpeed();
		car.incSpeed();
		
		//decrease the speed
		car.decSpeed();
		car.decSpeed();
		car.decSpeed();
		car.decSpeed();
		
		//change direction
		car.turn(3);
		
		//find distance
		car.distance(3, 7);
	}
	
	//variables of the class
	public int posX;
	public int posY;
	public int speed;
	public int dir;
	
	/**
	 * Vehicle() is a default constructor that sets all variables to 0
	 * 
	 * @param posX		posX is the x location of the vehicle
	 * @param posY		posY is the y location of the vehicle
	 * @param speed		speed is the current speed of the vehicle
	 * @param dir		dir is the direction that the vehicle is turned in
	 * 
	 */
	public VehicleOrig()
	{
		System.out.println("created a vehicle object");
		posX = 0;
		posY = 0;
		speed = 0;
		dir = 0;
	}
	
	/**
	 * Vehicle(int x, int y) is a default constructor that sets all variables to 0
	 * 
	 * @param x			x is the inputed x location of the vehicle
	 * @param y			y is the inputed y location of the vehicle
	 * @param posX		posX is the x location of the vehicle
	 * @param posY		posY is the y location of the vehicle
	 * @param speed		speed is the current speed of the vehicle
	 * @param dir		dir is the direction that the vehicle is turned in
	 * 
	 */
	public VehicleOrig(int x, int y)
	{
		posX = x;
		posY = y;
		dir = 0;
		speed = 0;
	}
	
	/**
	 * Vehicle(int x, int y, int d) is a default constructor that sets all variables to 0
	 * 
	 * @param x			x is the inputed x location of the vehicle
	 * @param y			y is the inputed y location of the vehicle
	 * @param d			d is the inputed direction of the vehicle
	 * @param posX		posX is the x location of the vehicle
	 * @param posY		posY is the y location of the vehicle
	 * @param speed		speed is the current speed of the vehicle
	 * @param dir		dir is the direction that the vehicle is turned in
	 * 
	 */
	public VehicleOrig(int x, int y, int d)
	{
		posX = x;
		posY = y;
		if(d < 0)
		{
			//absolute it
			d = Math.abs(d);
			//mod the d by 8
			dir = d%8;
		}
		else
		{
			dir  = d % 8;
		}
		speed= 0;
	}
	
	/**
	 * incSpeed() increases the speed by 1 but only to a max value 2
	 * 
	 * @param speed		speed is how fast the vehicle is going
	 */
	public void incSpeed()
	{
		//if speed is less than the max value then increase it, else do nothing
		if(speed < 2)
		{
			speed++;
			
			//check the speed
			System.out.println("You have increased your speed to " + speed);
		}
		else
		{
			System.out.println("You have reached max speed");
		}
	}
	
	/**
	 * decSpeed() decreases the speed by 1 but only to a min value of -1
	 * 
	 *  @param speed		speed is how fast the vehicle is going
	 */
	public void decSpeed()
	{
		//if speed is greater than -1, then subtract from the speed
		if(speed > -1)
		{
			speed--;
			
			//check the speed
			System.out.println("You have decreased your speed to " + speed);
		}
		else
		{
			System.out.println("You have reached min speed");
		}
		
	}
	
	/**
	 * turn(int amt) is used to turn the vehicle by a certain number
	 * 
	 * @param amt		direction to turn the vehicle by
	 * @param dir 		direction currently facing
	 */
	public void turn(int amt)
	{
		//if the amount is greater than 0, than the direction subtracts
		if(amt >= 0)
		{
			//new dir is equal to the dir plus amount modulated by 8
			dir = (dir+amt) % 8;
			System.out.println("Your new direction is " + dir);
		}
		//if the amount is less than 0 than the direction subtracts
		else if(amt < 0)
		{
			//new dir is equal to dir minus amount modulated by 8
			dir = (dir-amt) % 8;
			System.out.println("Your new direction is " + dir);
		}
		
	}
	
	/**
	 * distance(int x, int y) finds the distance between the current location and a specific point
	 * 
	 * @param x		x location that we want to find the distance to
	 * @param y		y location that we want to find the distance to
	 * @param xDist	distance between x and posX
	 * @param yDist distance between y and posY
	 * @param dist  distance between points
	 * @return		returns a double that is the distance between points
	 */
	public double distance(int x, int y)
	{
		
		//this function utilizes the pythagorean theorem
		int xDist = posX - x;
		int yDist = posY - y;
		double dist = (xDist*xDist) + (yDist*yDist);
		System.out.println("The distance between you and (" + x + "," + y + ") is " + Math.sqrt(dist));
		return Math.sqrt(dist);
		
		
	}
	

}