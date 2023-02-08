
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.util.Random;

/**
 * Creates Truck Object which delivers the shipments to the warehouses
 *
 * @author Armaghan Ejaz
 * @version 07-04-20022
 */

public class Truck extends Stack implements Schedule,Render  {
    //initialisation

    double truck_xpos, truck_ypos ;
    int size;

    //carrying capacity ranging from 1-5
    int capacity;
    int shipment_units;

    //speed based on carrying capacity ranging from 1mph to 5 mph
    int speed;

    //Size of stack truck can have
    Stack ShipmentLoad;

    Manifest manifest;
    ManifestItem manifest_item;
    Warehouse start_warehouse;
    Warehouse end_warehouse;
    Shipments shipments;
    LoggingObject logger=new LoggingObject();
    
    
    

    int start_warehouse_xpos, start_warehouse_ypos;
    int  end_warehouse_xpos, end_warehouse_ypos;
    int docks;
    public boolean finishDelivery;
    PriorityQueue<Shipments> load_list= new PriorityQueue<Shipments>();
    Shipments s;
    
    public  static int global_id=0;
     public int id;

    /**
     * Default constructor for Truck
     */
    public Truck() {
        size=10;
        finishDelivery=false;
        global_id++;
        id=global_id;
        

    }
    
    public static void main(){
        
    }
    
    /**
     * return x position of Truck
     * @return double
     */
    public double gettruck_xpos(){
        return truck_xpos;
    }

    /**
     * return y position of Truck
     * @return double
     */
    public double gettruck_ypos(){
        return truck_ypos;
    }

    /**
     * sets  x position of Truck
     * @param double x position
     */
    public void settruck_xpos(double truck_xpos){
        this.truck_xpos=truck_xpos;
    }

    /**
     * sets  y position of Truck
     * @param double y position
     */
    public void settruck_ypos(double truck_ypos){
        this.truck_ypos=truck_ypos;
    }

    /**
     * draws the Truck as a rectangle
     * @param Graphics g
     */
    public void draw(Graphics g) {
        Graphics2D graphicsObj = (Graphics2D) g;
        Rectangle rect = new Rectangle((int)truck_xpos, (int)truck_ypos, size, size);
        Color binColor1 = new Color(0, 255, 0);
        graphicsObj.setColor(binColor1);
        graphicsObj.fill(rect);
    } 

    /**
     *  gets  manifest item
     * @return Manifest Item
     * 
     */

    public ManifestItem get_manifestItem(){
        manifest_item=manifest.remove(0);
        return manifest_item;
    }

    /**
     *  gets the starting warehouse
     * @return Warehouse
     * 
     */
    public Warehouse get_startWarehouse(){
        start_warehouse=manifest_item.getStartWarehouse();
        return start_warehouse;
    }

    /**
     * gets the ending warehouse
     * @return Warehouse
     * 
     */
    public Warehouse get_endWarehouse(){
        end_warehouse=manifest_item.getEndWarehouse();
        return end_warehouse;
    }

    /**
     * Controller Method for Truck. Indicates what method should Truck perform  
     * 
     */
    public void action(){
        if(manifest.size()==0){
            finishDelivery=true;
            truck_wait();
        }

        if(!manifest.isEmpty()){
            manifest_item=manifest.remove(0);
            start_warehouse=manifest_item.start_warehouse;
            end_warehouse=manifest_item.end_warehouse;
            start_warehouse_xpos=start_warehouse.warehouse_xpos;
            start_warehouse_ypos=start_warehouse.warehouse_ypos;
            end_warehouse_xpos=end_warehouse.warehouse_xpos;
            end_warehouse_ypos=end_warehouse.warehouse_ypos;
            truck_xpos=gettruck_xpos();
            truck_ypos=gettruck_ypos();
            

            if((Math.abs(start_warehouse_xpos-truck_xpos)<1 && Math.abs(start_warehouse_ypos-truck_ypos)<1)){
                start_warehouse.queue_truck();
                logger.main(id,truck_xpos,truck_ypos,"IN QUEUE");
                
                if(docks>0){
                    start_warehouse.dequeue_truck();
                    logger.main(id,truck_xpos,truck_ypos,"OUT OF QUEUE");
                    if(empty()==true){
                        shipment_loader();
                        logger.main(id,truck_xpos,truck_ypos,"LOADING SHIPMENTS");
                    }
                    move();
                    logger.main(id,truck_xpos,truck_ypos,"MOVING");
                }
                else{
                    truck_wait();
                    logger.main(id,truck_xpos,truck_ypos,"WAITING");
                }

            }
            else if (Math.abs(end_warehouse_xpos-truck_xpos)<1 && Math.abs(end_warehouse_ypos-truck_ypos)<1){
                end_warehouse.queue_truck();
                 logger.main(id,truck_xpos,truck_ypos,"IN QUEUE");
                if(docks>0){
                    start_warehouse.dequeue_truck();
                    logger.main(id,truck_xpos,truck_ypos,"OUT OF QUEUE");
                    if(empty()==false){
                        shipment_unload();
                        logger.main(id,truck_xpos,truck_ypos,"UNLOADING SHIPMENTS");
                    }
                    move();
                    logger.main(id,truck_xpos,truck_ypos,"MOVING");

                }
                else{
                    truck_wait();
                    logger.main(id,truck_xpos,truck_ypos,"WAITING");
                }
            }

            else{
                move();
                logger.main(id,truck_xpos,truck_ypos,"MOVING");
            }
        }

    }

    public int log_status(){
        return 0;
    }

    /**
     * calculates position of truck and moves it to nearest warehouse 
     * 
     */
    public void move(){
        double min_dist=1000000;
        double dist=0;
        double angle=0;
        double min_angle=0;
  
        if(empty()==true){
            for(int i=0; i<manifest.size();i++){

                dist=Math.sqrt(((truck_xpos-start_warehouse_xpos)*(truck_xpos-start_warehouse_xpos)) + (truck_ypos-start_warehouse_ypos)*(truck_ypos-start_warehouse_ypos));
                angle=Math.atan((truck_ypos-start_warehouse_ypos)/(truck_xpos-start_warehouse_xpos));

                if(dist<min_dist){
                    min_dist=dist;
                    min_angle=angle;
                }

            }
            truck_xpos+=(min_dist)*Math.cos(min_angle);
            
            truck_ypos+=(min_dist)*Math.sin(min_angle);
           

        }

        else {
            for(int i=0; i<manifest.size();i++){
                ManifestItem manifest_item_dist=manifest.get(i);
                double end_warehouse_xdist=end_warehouse.warehouse_xpos;
                double end_warehouse_ydist=end_warehouse.warehouse_ypos;
                double truck_xdist=gettruck_xpos();
                double truck_ydist=gettruck_ypos();

                dist=Math.sqrt(((truck_xdist-end_warehouse_xdist)*(truck_xdist-end_warehouse_xdist)) + (truck_ydist-end_warehouse_ydist)*(truck_ydist-end_warehouse_ydist));
                angle=Math.atan((truck_ydist-end_warehouse_ydist)/(truck_xdist-end_warehouse_xdist));

                if(dist<min_dist){
                    min_dist=dist;
                    min_angle=angle;
                }

            }
            truck_xpos+=((min_dist)*Math.cos(min_angle))*speed;
            System.out.println(truck_xpos);
            truck_ypos+=((min_dist)*Math.sin(min_angle))*speed;
            System.out.println(truck_ypos);
            

        }
    }

  

    /**
     * method which controls Truck position when truck does not move
     * 
     * 
     */
    public void truck_wait(){
        truck_xpos+=0;
        truck_ypos+=0;
    }

    /**
     * method which loads the shipment on the to the Stack of the Truck
     * 
     * 
     */
    public void shipment_loader(){
        load_list=start_warehouse.create_shiplist();

        for(int i=0;i<load_list.size();i++){
            s=load_list.get(i);
            shipment_load(s);

        }

    }

    /**
     * helper method for shipment loader
     * 
     * @param Shipments
     */
    public void shipment_load(Shipments s){

        if(s.units<capacity){
            push(s);
            capacity=capacity-s.units;
            return;
        }
        else{
            return;
        }

    }

    /**
     * method which unloads shipment from truck stack
     * 
     *
     */
    
    public void shipment_unload(){
        if(empty()==false){
            Shipments s=(Shipments)pop();
            capacity=capacity+s.units;
            return;
        }
        else{
            return;
        }
    }

}
