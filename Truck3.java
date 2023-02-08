import java.util.Random;

/**
 * Write a description of class Truck1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Truck3 extends Truck
{
    
    int capacity;
    int speed;
    Random rand;
    
    public Truck3(Manifest manifest,Random rand){
     
        truck_xpos=rand.nextInt(400);
        truck_ypos=rand.nextInt(250);
        size=10;
        capacity=3;
        speed=3;
        this.manifest=manifest;
        
        
    }
    
    
}