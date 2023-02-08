
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.util.Random;

/**
 * Warehouse class where trucks are held in a queue to pickup and drop off shipments
 *
 * @author Armaghan Ejaz
 * @version 04-07-2022
 */

public class Warehouse extends Queue implements Render { 
    //initialization

    public int warehouse_xpos,warehouse_ypos,size;//truck_xpos,truck_ypos;

    //number of docks ranging from 1-3
    int docks;
    //queue of number of trucks the warehouse can have
    Queue truck_queue;

    Truck truck;

    Shipments s;
    public PriorityQueue<Shipments> shiplist=new PriorityQueue<Shipments>();

    /**
     * Constructor for objects of class Queue
     */
    public Warehouse()
    {   
        //randomly allocates position and number of docks
        warehouse_xpos=Model.rand.nextInt(400);
        warehouse_ypos=Model.rand.nextInt(250);
        docks= (Model.rand.nextInt(2) +1);

        truck_queue=new Queue<Truck>();
        size=10;

    }

    /**
     * draws warehouse as a rectangle
     * @param Graphics g
     * 
     */
    public void draw(Graphics g) {
        Graphics2D graphicsObj = (Graphics2D) g;
        Rectangle rect = new Rectangle((int)warehouse_xpos, (int)warehouse_ypos, size, size);
        Color binColor1 = new Color(0, 0, 255);
        graphicsObj.setColor(binColor1);
        graphicsObj.fill(rect);
    } 

    /**
     * returns x-location of warehouse   
     * @return x-location of warehouse
     * 
     */
    public int getwarehouse_xpos(){
        return warehouse_xpos;

    }

    /**
     * returns y-location of warehouse   
     * @return y-location of warehouse
     * 
     */

    public int getwarehouse_ypos(){
        return warehouse_ypos;
    }

    /**
     * sets y-location of warehouse   
     * @param x-location of warehouse
     */

    public void setwarehouse_xpos(int warehouse_xpos){
        this.warehouse_xpos=warehouse_xpos;
    }

    /**
     * sets y-location of warehouse   
     * @param y-location of warehouse
     */
    public void setwarehouse_ypos(int warehouse_ypos){
        this.warehouse_ypos=warehouse_ypos;

    }

    /**
     * sets y-location of warehouse   
     * @param y-location of warehouse
     */
    public void setDocks(int docks){
        this.docks=docks;
    }

    /**
     * returns number of docks
     * @return int docks
     */
    public int getdocks(){
        return docks;
    }

    /**
     * adds queue to the truck
     */
    public void queue_truck(){
        add(truck);

    }

    /**
     * removes queue from the truck
     */
    public void dequeue_truck(){
        while(docks!=0){
            remove();
            docks--;
        }

    }

    /**
     * adds the shipments at the warehouse to a priority queue
     * @return PriorityQueue of Shipments
     */
    public PriorityQueue<Shipments> create_shiplist(){

        for(int i=0;i<Model.shipments.length;i++){
            if(Model.shipments[i].shipment_xpos==warehouse_xpos && Model.shipments[i].shipment_ypos==warehouse_ypos){
                shiplist.add(Model.shipments[i]);
            }
        }

        return shiplist;
    }

    
}

