/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aurorahavens
 */
import java.awt.Point;

/**
 * TankInterface provides methods that need to be implemented in the Tank class
 * 
 * @author Aurora Havens
 *@version 1.0
 */
public interface TankInterface {
   // Provide a default constructor that sets all int stance vars to zero.
   // The constructor should the default destination to (20,20)
    
   // basic get & set methods 
   public void    setAmmo(int amt);
   public int     getAmmo();
   public void    setHealth(int amt);
   public int     getHealth();
   public void    setDestination(java.awt.Point destination);
   public Point   getDestination();
   
   // return a JSON string of the form: {"dir":1, "speed":1}
   public String  getJsonMoveSpeedAndDirection();
   
}
