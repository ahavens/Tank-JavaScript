

package gismoai;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue; 

/**
 *
 * @author aurorahavens
 * @version 1.0
 */
public class TankAI implements gismosimple.Hw05GismoTankInterface{
    
    /**
     * Main function
     * @param args 
     */
    public static void main(String[] args)
    {
        gismosimple.GismoTankTester.main(args);
        
    }
    
    //tankarrays that hold the different x and y's in the directions
    public int tankArrayX[] = new int[8];
    public int tankArrayY[] = new int[8];
	
    //Tank variables
    //int id;
    int tankX;
    int tankY;
    int tankSpeed;
    int tankDir;
    int health;
    int ammo;
    int direction;
    int speed;
    double distance;
    
    //forest variables
    int forestX;
    int forestY;
    int forestWidth;
    int forestHeight;
    
    //water variables
    int waterX;
    int waterY;
    int waterWidth;
    int waterHeight;
    
    
    @Override
    /**
     * computeMove returns the direction and speed where the tank should go
     * @param stateAsJSON       string of all JSON objects
     * @return returns the direction and speed the tank needs to go in
     */
    public String computeMove(String stateAsJSON) {
        
        //in this function we ultimately want to get each thing
        //of the tank
        //the forest and water state remain the same, therefore we only have 
        //to worry about setting it once
        //go ahead and tear the thing apart
        
        //MAKE ONE BIG TANK OBJECT
        JSONObject obj=(JSONObject)JSONValue.parse(stateAsJSON);
        
        //MAKE SEPARATE OBJECTS AND ARRAYS
        JSONObject tank = (JSONObject)obj.get("tankState");
        JSONArray forest = (JSONArray)obj.get("forest");
        JSONArray water = (JSONArray)obj.get("water");
        
        //SET ALL THE TANK VARIABLES
        //id = (int)((long)tank.get("id"));
        tankX = (int)((long)tank.get("x"));
        tankY = (int)((long)tank.get("y"));
        tankSpeed = (int)((long)tank.get("speed"));
        tankDir = (int)((long)tank.get("dir"));
        health = (int)((long)tank.get("health"));
        ammo = (int)((long)tank.get("ammo"));
        
        //GET ALL THE VARIABLES FOR THE FOREST OBJECT
        JSONObject forestObj = (JSONObject)forest.get(0);
        forestX = (int)((long)forestObj.get("x"));
        forestY = (int)((long)forestObj.get("y"));
        forestWidth = (int)((long)forestObj.get("w"));
       // forestHeight = (int)((long)tank.get("h"));
        
        
        //WE WILL NOT BE USING WATER BUT WE WILL ASSIGN IT
        JSONObject waterObj = (JSONObject)water.get(0);
        waterX = (int)((long)waterObj.get("x"));
        waterY = (int)((long)waterObj.get("y"));
        waterWidth = (int)((long)waterObj.get("w"));
        waterHeight = (int)((long)waterObj.get("h"));
        
        //set the values in the tank array
        setTankArray();
        
        //find the direction the forest is located in with the minimum amount between it
        direction = getDirectionToPoint(forestX, forestY);
        distance = distance(forestX, forestY);
        
        //depending on the distance, we want to set speed a certain value
        if(distance > 2)
        {
            speed = 2;
        }
        else if(forestX == tankX && forestY == tankY)
        {
            speed = 0;
        }
        else
        {
            speed = 1;
        }
        
        
        
        
        
        
        return "{\"dir\":" + direction + ", \"speed\":" + speed +"}";
    }

    /**
    * getDirectionToPoint takes in a point, finds the shortest directional distance and then returns the direction of that point
    * 
    * @param x	x location
    * @param y     y location
    */
    public int getDirectionToPoint(int x, int y) 
    {
        // TODO Auto-generated method stub
		
        int minDirection = 0;
		
        double dist = 0;
        
        double xDest = x;
        double yDest = y;
		
        //find the x and y dist
        double xDist = (double)tankArrayX[0] - xDest;
        double yDist = (double)tankArrayY[0] - yDest;
        //determine distance
        double minDist = (xDist*xDist) + (yDist*yDist);
        //set minDist
        minDist = Math.sqrt(minDist);
		
		
        //idea, go through each direction and determine the minDistance by checking against the minDist
        for(int i = 1; i < 8; i++)
        {
            //refind distance between each point
            xDist = (double)tankArrayX[i] - xDest;
            yDist = (double)tankArrayY[i] - yDest;
			
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
    
    /**
     * distance functions calculates the distance between one location and the current tank location
     * 
     * @param x     x position of where we are trying to get to
     * @param y     y position of where we are trying to get to
     * @return      distance returned 
     */
    public double distance(int x, int y) 
    {
        //this function utilizes the pythagorean theorem
	int xDist = tankX - x;
	int yDist = tankY - y;
	double dist = (xDist*xDist) + (yDist*yDist);
	//System.out.println("The distance between you and (" + p.x + "," + p.y + ") is " + Math.sqrt(dist));
	return Math.sqrt(dist);
    }
    
    /**
     * setTankArray goes ahead and sets the values of the directions and the distance
     */
    public void setTankArray()
    {
        //initialize points in specific directions
	tankArrayX[0] = tankX;
	tankArrayY[0] = tankY + 1;
        
	tankArrayX[1] = tankX + 1;
        tankArrayY[1] = tankY + 1;
		
	tankArrayX[2] = tankX + 1;
        tankArrayY[2] = tankY;
	
        tankArrayX[3] = tankX + 1;
	tankArrayY[3] = tankY - 1;
        
	tankArrayX[4] = tankX;
        tankArrayY[4] = tankY - 1;
		
	tankArrayX[5] = tankX - 1;
        tankArrayY[5] = tankY - 1;
		
	tankArrayX[6] = tankX -1;
        tankArrayY[6] = tankY;
	
        tankArrayX[7] = tankX - 1;
	tankArrayY[7] = tankY + 1;
    }
    
    @Override
    /**
     * getAuthorName returns my name
     */
    public String getAuthorName() {
        return "Aurora Havens";
    }

    @Override
    /**
     * getAuthorID returns the last four digits of my id
     */
    public String getAuthorID() {
        return "4741";
    }

    @Override
    /**
     * setTankID sets the id of the tank
     * @param i     id to set the tankID to
     */
    public void setTankId(int i) {
        
    }

    @Override
    /**
     * getTankID returns the id of the tank
     */
    public int getTankId() {
        return 1;
    }
    
    /**
     * setTankLocation sets the location of the tank
     * @param x     sets the tank x location
     * @param y     sets the tank y location
     */
    public void setTankLocation(int x, int y)
    {
        tankX = x;
        tankY = y;
    }
    
    /**
     * getTankLocation returns the location of the tank
     * @return returns string of the tank location
     */
    public String getTankLocation()
    {
        return "("+tankX+","+tankY+")";
    }
    
    /**
     * setTankSpeed sets the speed of the tank
     * @param s     speed to set the tank to
     */
    public void setTankSpeed(int s)
    {
        tankSpeed = s;
    }
    
    /**
     * getTankSpeed returns the tanks speed
     * @return 
     */
    public int getTankSpeed()
    {
        return tankSpeed;
    }
    
    /**
     * setTankDir sets the direction of the tank
     * @param d     direction of the tank to set it to
     */
    public void setTankDir(int d)
    {
        tankDir = d;
    }
    
    /**
     * getTankDir returns the direction of the tank
     * @return  returns the direction of the tank
     */
    public int getTankDir()
    {
        return tankDir;
    }
    
    /**
     * setTankHealth sets the health of the tank
     * @param h    int to set the health to
     */
    public void setTankHealth(int h)
    {
        health = h;
    }
    
    /**
     * getTankHealth returns the health of the tank
     * @return  returns the health of the tank
     */
    public int getTankHealth()
    {
        return health;
    }
    
    /**
     * setTankAmmo sets the ammo number of the tank
     * @param a     int to set the ammo to
     */
    public void setTankAmmo(int a)
    {
        ammo = a;
    }
    
    /**
     * getTankAmmo returns the ammo of the tank
     * @return    how much ammo is in the tank
     */
    public int getTankAmmo()
    {
        return ammo;
    }
    
}
