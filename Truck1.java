import java.util.Random;

/**
 * Write a description of class Truck1 here.
 *
 * @author 
 * @version (a version number or a date)
 */
public class Truck1 extends Truck
{
    int capacity;
    int speed;
    Random rand;
    
    public Truck1(Manifest manifest,Random rand) {
        this.rand=rand;
        truck_xpos=rand.nextInt(400);
        truck_ypos=rand.nextInt(250);
        size=10;
        capacity=1;
        speed=5;
        this.manifest=manifest;
        
    }
    
   
}
