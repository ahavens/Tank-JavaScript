import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author Aurora Havens
 * @version 1.0
 */
public class VehicleTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	/**
	 * Test of all constructors in vehicle
	 */
	@Test
	public void testConstructors() 
	{
		//first constructor
		System.out.println("Constructors Test");
		Vehicle instance = new Vehicle();
		assertEquals(0, instance.posX);
		assertEquals(0, instance.posY);
		assertEquals(0, instance.speed);
		assertTrue(instance.dir < 8);
		assertTrue(instance.dir >= 0);
		assertEquals(0, instance.dir);
		
		//Second constructor
		instance = new Vehicle(12, 12);
		System.out.println("constring with 12, 12");
		assertEquals(12, instance.posX);
		assertEquals(12, instance.posY);
		assertEquals(0, instance.speed);
		assertTrue(instance.dir < 8);
		assertTrue(instance.dir >= 0);
		assertEquals(0, instance.dir);
		
		//this constructor
		instance = new Vehicle(12, 12, 3);
		System.out.println("costring with 12, 12, 3");
		assertEquals(12, instance.posX);
		assertEquals(12, instance.posY);
		assertEquals(0, instance.speed);
		assertTrue(instance.dir < 8);
		assertTrue(instance.dir >= 0);
		assertEquals(3, instance.dir);
	}
	
	/**
	 * Test of the incSpeed method of the Vehicle class
	 */
	@Test
	public void testIncSpeed()
	{
		//Rethink of the whole function: incSpeed() takes in an amount
		//the speed max can go up to two, so when increasing the speed value we 
		//have to make sure it reaches that
		
		//Print to show where we are
		System.out.println("Testing incSpeed()");
		
		//amount to be plugged into the equation
		int amt = 1;
		
		//create a vehicle instance
		Vehicle instance = new Vehicle();
		
		//run three tests with increasing amounts
		for(int i = 0; i < 3; i++)
		{
			System.out.println("Test number " + i + " for incSpeed()");
			//want to ignore negative amt values
			if(amt >= 0)
			{
				//we create a value that's known as expected, 
				int expected = instance.speed + amt;
		
				//if the expected value is greater than two then we must check to see if the 
				//speed is less than two
				if(expected > 2)
				{
					instance.incSpeed(amt);
					//if the expected amount is greater than two, the speed should remain at 2
					assertTrue(instance.speed == 2);
				}
				//if the expected is less than 2, then we just check to make sure the speed is equal
				else if(expected <=2)
				{
					instance.incSpeed(amt);
					//again, if the expected is less than 2, then we just want to check expected values
					assertEquals(expected, instance.speed);
				}
			}
			else
			{
				System.out.println("You entered a negative value for amt, please enter a positive value");
			}
			
			//add two to the amount 
			amt +=2;
		}
	}
	
	/**
	 * Test of decSpeed method of class Vehicle
	 */
	@Test
	public void testDecSpeed()
	{
		//like inc, we want to rethink decSpeed
		//the minimum limit is -1, so we need to keep it like that
		
		//print to show what we are testing
		System.out.println("testing decSpeed()");
		
		//amount to decrease by
		int amt = 1; 
		
		//create vehicle instance
		Vehicle instance = new Vehicle();
		
		for(int i = 0; i < 3; i++)
		{
			System.out.println("Test number " + i + " for decSpeed()");
			//we have to account for a negative amt
			if(amt >= 0)
			{
		
				//calculate the expected value
				int expected = instance.speed - amt;
		
				//if the expected value is greater than -1, then we want to check that it stays
				//at -1
				if(expected < -1)
				{
					instance.decSpeed(amt);
					//check to make sure that the speed remains at -1
					assertTrue(instance.speed == -1);
				}
				//else if the expected value is greater than, then we want to check and 
				//make sure it's the same
				else if(expected > -1)
				{
					instance.decSpeed(amt);
					//check to make sure the expected is the same
					assertEquals(expected, instance.speed);
				}
		
		
			}
			else
			{
				System.out.println("You entered a negative value for amt, please enter a positive value");
			}
			
			//increase amount by 2
			amt += 2;
		}
	}
	
	/**
	 * Test of turn method of class Vehicle
	 */
	@Test
	public void testTurn()
	{
		//CHECK LIMITATIONS
		System.out.println("testing turn()");
		
		//set the amount int
		int amt = 2; 
		
		//create vehicle instance
		Vehicle instance = new Vehicle();
		
		//set expected to 0 as we will mess around with it
		int expected = 0;
		
		//test three times with increasing amt
		for(int i = 0; i < 3; i++)
		{
			System.out.println("Test number " + i + " for turn()");
			if(amt > 0)
			{
				expected = (instance.dir + amt) % 8;
			
				//turn the car
				instance.turn(amt);
				//check to see that the values match up
				assertEquals(expected, instance.dir);
			
			}
			else if(amt < 0)
			{
				expected = (instance.dir - amt) % 8;
			
				//turn the car
				instance.turn(amt);
				//check to see that the values match up
				assertEquals(expected, instance.dir);
			}
			else if(amt == 0)
			{
				expected = instance.dir;
			
				//turn the car
				instance.turn(amt);
				//check to see that the values match up
				assertEquals(expected, instance.dir);
			
			}
			
			//add two to the amount to test
			amt += 2;
		}
		
	}
	
	/**
	 * Second test of the turn method of class Vehicle
	 */
	@Test
	public void testTurn2()
	{
		//CHECK LIMITATIONS
		System.out.println("testing turn()");
				
		//set the amount int
		int amt = 2; 
				
		//create vehicle instance
		Vehicle instance = new Vehicle();
				
		//set expected to 0 as we will mess around with it
		int expected = 0;
			
		//test it three times with increasing amt
		for(int i = 0; i < 3; i++)
		{
			System.out.println("Test number " + i + " for turn()");
			if(amt > 0)
			{
				expected = (instance.dir + amt) % 8;
					
				//turn the car
				instance.turn(amt);
				//check to see that the values match up
				assertEquals(expected, instance.dir);
					
			}
			else if(amt < 0)
			{
				expected = (instance.dir - amt) % 8;		
			
				//turn the car
				instance.turn(amt);
				//check to see that the values match up
				assertEquals(expected, instance.dir);
			}
			else if(amt == 0)
			{
				expected = instance.dir;
					
				//turn the car
				instance.turn(amt);
				//check to see that the values match up
				assertEquals(expected, instance.dir);
					
			}
			
			amt += 2;
		}
	}
	
	/**
	 * Test of the distance method of class Vehicle
	 */
	@Test
	public void testDistance()
	{
		
		System.out.println("Testing the distance function");
		int x = 0;
		int y = 10;
		
		Vehicle instance = new Vehicle();
		
		//find the difference of x and y
		int newX = instance.posX - x;
		int newY = instance.posY - y;
		
		//square before taking square root
		int dist = (newX * newX) + (newY * newY);
		
		//find the expected result
		double expResult = Math.sqrt(dist);
		//find the actual result
		double result = instance.distance(x,y);
		
		//compare them
		assertEquals(expResult, result, 0.01);
	}

}
