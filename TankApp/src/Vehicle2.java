import java.awt.Point;

/**
 * This class implements all functions from the Vehicle2Interface
 * 
 * @author Aurora Havens
 *
 * @version 1.0
 */
public class Vehicle2 implements Vehicle2Interface {
	
	//variables of the class
	public int posX;
	public int posY;
	public int speed;
	public int dir;
	Point position;
	//arrays used to determine point direction
	public int arrayX[] = new int[8];
	public int arrayY[] = new int[8];
	
	/**
	 * Vehicle2 default constructor sets the default position point to 0,0 and fills in all 
	 * the arrays
	 */
	public Vehicle2()
	{
		//assign position to a default of 20,20
		position = new Point(20,20);
		
		posX = 0;
		posY = 0;
		speed = 0;
		dir = 0;
		
		//initialize points in specific directions
		arrayX[0] = posX;
		arrayY[0] = posY + 1;
		
		arrayX[1] = posX + 1;
		arrayY[1] = posY + 1;
		
		arrayX[2] = posX + 1;
		arrayY[2] = posY;
		
		arrayX[3] = posX + 1;
		arrayY[3] = posY - 1;
		
		arrayX[4] = posX;
		arrayY[4] = posY - 1;
		
		arrayX[5] = posX - 1;
		arrayY[5] = posY - 1;
		
		arrayX[6] = posX -1;
		arrayY[6] = posY;
		
		arrayX[7] = posX - 1;
		arrayY[7] = posY + 1;
	}
	
	/**
	 * Vehicle2(Point p) constructor for Vehicle2 class which takes in a point p and assigns
	 * it to position
	 * 
	 * @param p		point which is then used in position
	 */
	public Vehicle2(Point p)
	{
		this.position = p;
		
		//point functions and variables are public so I can access them easily
		posX = p.x;
		posY = p.y;
		
		//initialize points in specific directions
		arrayX[0] = posX;
		arrayY[0] = posY + 1;
		
		arrayX[1] = posX + 1;
		arrayY[1] = posY + 1;
		
		arrayX[2] = posX + 1;
		arrayY[2] = posY;
		
		arrayX[3] = posX + 1;
		arrayY[3] = posY - 1;
		
		arrayX[4] = posX;
		arrayY[4] = posY - 1;
		
		arrayX[5] = posX - 1;
		arrayY[5] = posY - 1;
		
		arrayX[6] = posX -1;
		arrayY[6] = posY;
		
		arrayX[7] = posX - 1;
		arrayY[7] = posY + 1;
		
		//set speed and direction
		speed = 0;
		dir = 0;
	}
	
	/**
	 * Vehicle2(Point p, int dir) takes in a point to initialize position and direction to initialize
	 * dir
	 * 
	 * @param p		point which position is initialized with
	 * @param dir	direction which dir is initialized with
	 */
	public Vehicle2(Point p, int dir)
	{
		this.position = p;
        this.dir = dir;
        
		posX = p.x;
		posY = p.y;
		
		//initialize points in specific directions
		arrayX[0] = posX;
		arrayY[0] = posY + 1;
		
		arrayX[1] = posX + 1;
		arrayY[1] = posY + 1;
		
		arrayX[2] = posX + 1;
		arrayY[2] = posY;
		
		arrayX[3] = posX + 1;
		arrayY[3] = posY - 1;
		
		arrayX[4] = posX;
		arrayY[4] = posY - 1;
		
		arrayX[5] = posX - 1;
		arrayY[5] = posY - 1;
		
		arrayX[6] = posX -1;
		arrayY[6] = posY;
		
		arrayX[7] = posX - 1;
		arrayY[7] = posY + 1;
		
		//set speed and direction
		//have to use keyword this due to similar variable names
		this.dir = dir;
		speed = 0;
		
	}

	@Override
	/**
	 * setSpeed resets speed to the new speed
	 * 
	 * @param newSpeed		new speed which speed is assigned to
	 */
	public void setSpeed(int newSpeed) {
		// TODO Auto-generated method stub
		
		//only change the speed if the newSpeed is between certain values
		if(newSpeed <= 2 && newSpeed >= -1)
		{
			speed = newSpeed;
		}
		
	}

	@Override
	/**
	 * setDir sets the direction to a new direction
	 * 
	 * @param newdir		sets direction to the new direction
	 */
	public void setDir(int newdir) {
		// TODO Auto-generated method stub
		
		if(newdir > 7 || newdir < 0)
		{
			Math.abs(newdir);
			dir = newdir % 8;
		}
		else
		{
			dir = newdir;
		}
		
	}

	@Override
	/**
	 * distance function finds the distance between the vehicle and a specified point
	 * 
	 * @param p		point which we are finding the distance tos
	 * 
	 */
	public double distance(Point p) {
		//this function utilizes the pythagorean theorem
		int xDist = posX - p.x;
		int yDist = posY - p.y;
		double dist = (xDist*xDist) + (yDist*yDist);
		System.out.println("The distance between you and (" + p.x + "," + p.y + ") is " + Math.sqrt(dist));
		return Math.sqrt(dist);
	}

	@Override
	/**
	 * getPosition returns the current position of the vehicle
	 * 
	 */
	public Point getPosition() {
		return position;
	}

	@Override
	/**
	 * getPointInDirection finds the point in the indicated direction
	 * 
	 * @param direction		direction of the point to be determined
	 */
	public Point getPointInDirection(int direction) {
		// TODO Auto-generated method stub
		
		//go ahead and abs value it
		direction = Math.abs(direction);
		//if the direction is too high we have to mod it
		direction = direction % 8;
		java.awt.Point positionInDirection = new Point(arrayX[direction], arrayY[direction]);
		return positionInDirection;
	}

	@Override
	/**
	 * getDirectionToPoint takes in a point, finds the shortest directional distance and then returns the direction of that point
	 * 
	 * @param destinationPoint		point which we are finding the direction to
	 */
	public int getDirectionToPoint(Point destinationPoint) {
		// TODO Auto-generated method stub
		
		int minDirection = 0;
		
		double dist = 0;
		
		double xDest = destinationPoint.x;
		double yDest = destinationPoint.y;
		
		//find the x and y dist
		double xDist = (double)arrayX[0] - xDest;
		double yDist = (double)arrayY[0] - yDest;
		//determine distance
		double minDist = (xDist*xDist) + (yDist*yDist);
		//set minDist
		minDist = Math.sqrt(minDist);
		
		
		//idea, go through each direction and determine the minDistance by checking against the minDist
		for(int i = 1; i < 8; i++)
		{
			//refind distance between each point
			xDist = (double)arrayX[i] - xDest;
			yDist = (double)arrayY[i] - yDest;
			
			dist = (xDist*xDist) + (yDist*yDist);
			dist = Math.sqrt(dist);
			
			//if the found dist is smaller than the minDist then reassign direction
			if(dist < minDist)
			{
				minDist = dist;
				minDirection = i;
			}
		}
		
		return minDirection;
        }	
}
