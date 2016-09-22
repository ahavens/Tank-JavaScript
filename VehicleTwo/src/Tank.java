import java.awt.Point;

/**
 * Tank class extends vehicle2 class and implements the TankInterface AND the Vehicle2Interface
 * 
 * @author Aurora Havens
 * @version	1.0
 */
public class Tank extends Vehicle2 implements TankInterface, Vehicle2Interface {
	
	int ammo;
	int health; 
	java.awt.Point destination;
	
	/**
	 * Tank constructor calls the super constructor Vehicle2(Point p, int dir)
	 * 
	 * @param p		point where the tank is located
	 * @param dir	direction of the tank
	 */
    public Tank (Point p, int dir) 
    {
    	//call vehicle2 Constructor
    	super(p,dir);
    	//set vars to 0
    	ammo = 0;
    	health = 0;
    }
    
    /**
     * Tank constructor that calls super constructor Vehicle2(Point p)
     * 
     * @param p		Point where the tank is located
     */
    public Tank(Point p)
    {
    	//call vehicle2 constructor
    	super(p);
    	//set vars to 0
    	ammo = 0;
    	health = 0;
    }
       
    /**
     * Tank constructor calls the super constructor Vehicle2()
     */
    public Tank() 
    {
    	//call vehicle2 constructor
    	super();
    	//set vars to 0
    	ammo = 0;
    	health = 0;
    }
	
	@Override
	/**
	 * setAmmo sets the amount of ammo that the tanks has
	 * 
	 * @param amt		amount of ammo that the variable ammo is initialized to
	 */
	public void setAmmo(int amt) {
		// TODO Auto-generated method stub
		ammo = amt;
	}

	@Override
	/**
	 * getAmmo returns the variable ammo
	 */
	public int getAmmo() {
		// TODO Auto-generated method stub
		return ammo;
	}

	@Override
	/**
	 * setHealth sets the amount of health the tank has
	 * 
	 * @param amt		the amount to which health is set to
	 */
	public void setHealth(int amt) {
		// TODO Auto-generated method stub
		
		health = amt;
	}

	@Override
	/**
	 * getHealth returns the amount of health that the tank has
	 * 
	 */
	public int getHealth() {
		// TODO Auto-generated method stub
		return health;
	}

	@Override
	/**
	 * setDestination sets the tanks destination
	 * 
	 * @param destination		sets the destination of the tank
	 */
	public void setDestination(Point destination) {
		// TODO Auto-generated method stub
		this.destination = destination;
	}

	@Override
	/**
	 * getDestination returns the destination of the tank
	 */
	public Point getDestination() {
		// TODO Auto-generated method stub
		return destination;
	}

	@Override
	/**
	 * getJsonMoveSpeedAndDirection returns the speed and direction of the tank in a JSON object form
	 */
	public String getJsonMoveSpeedAndDirection() {
		// TODO Auto-generated method stub
		return "{\"dir\":" + this.getDirectionToPoint(destination) + ", \"speed\": 1}";
	}

}
