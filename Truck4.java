import java.util.Random;

/**
 * Write a description of class Truck1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Truck4 extends Truck
{
    
    int capacity;
    int speed;
    Random rand;
  
    public Truck4(Manifest manifest,Random rand){
        this.rand=rand;
        truck_xpos=rand.nextInt(400);
        truck_ypos=rand.nextInt(250);
        size=10;
        capacity=4;
        speed=2;
        this.manifest=manifest;
        
    }
    
   
}