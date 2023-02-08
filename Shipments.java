
/**
 * Class represents the Shipment Objects
 *
 * @author Armaghan Ejaz
 * @version 08-04-2021
 */
public class Shipments
{
    //initialization

    //number of units that the shipment contains
    //randomly generated from 1-3
    int units;
    //ID of the shipment which is used to keep track of it
    public  static int global_id=0;
    public int id;
    public int warehouse_xpos;
    public  int warehouse_ypos;
    public int shipment_xpos;
    public int shipment_ypos;

    /**
     * Default constructor for Shipment
     */
    public Shipments(int units,Warehouse warehouse){

        //variables
        global_id++;
        id=global_id;
        this.units=units;
        setwarehouse_xpos(warehouse.getwarehouse_xpos());
        setwarehouse_ypos(warehouse.getwarehouse_ypos());
        this.shipment_xpos=warehouse.getwarehouse_xpos();
        this.shipment_ypos=warehouse.getwarehouse_ypos();

    }
    /**
     * return warehouse x location
     * @return int xpos
     */
    public int getwarehouse_xpos(){
        return getwarehouse_xpos();
    }

    /**
     * return warehouse y location
     * @return int ypos
     */
    public int getwarehouse_ypos(){
        return getwarehouse_ypos();
    }

    /**
     * sets warehouse x location
     * @param int warehouse xpos
     */
    public void setwarehouse_xpos(int warehouse_xpos){
        this.warehouse_xpos=warehouse_xpos;
    }

    /**
     * sets warehouse y location
     * @param int warehouse ypos
     */
    public void setwarehouse_ypos(int warehouse_ypos){
        this.warehouse_ypos=warehouse_ypos;
    }

    /**
     * returns number of units
     * @return int units
     */
    public int getunits(){
        return units;
    }

    /**
     * sets number of units
     * @param int units
     */

    public void setunits(int units){
        this.units=units;
    }


}
