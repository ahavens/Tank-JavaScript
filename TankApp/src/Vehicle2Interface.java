import java.awt.Point;
/**
 * Vehicle2Interface provides the methods that should be implemented in Vehicle2
 * 
 * @author Aurora Havens
 * @version 1.0
 *
 */
public interface Vehicle2Interface {
    //speed should be between -1 and 2; ignore values outside this range
    public void   setSpeed(int newSpeed);
    
    //use modulo so that dir>=0 and dir<=7
    public void   setDir(int newdir);
    
    public double distance(Point p);
    
    // returns current Position as a Point object
    public Point getPosition();
    
    // returns a Point in a direction from current position
    // example: if at (10,10) the point in direction=0 should be (10,11)
    public Point getPointInDirection(int direction);
    
    // return a direction to some destination point that will
    // get your vehicle closer to the destination
    public int getDirectionToPoint(Point destinationPoint);
}
