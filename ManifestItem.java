import java.util.Random;

/**
 * Each Manifest Item stores the starting location for the pickup and ending location for the pickup
 *
 * @author Armaghan Ejaz
 * @version 15-04-2022
 */
public class ManifestItem extends Warehouse
{
    //initialisation
    public Warehouse start_warehouse;
    public Warehouse end_warehouse;

    /**
     * Default Constructor for Manifest Item
     *
     * @param Start Warehouse, End Warehouse
     */
    public ManifestItem(Warehouse start_warehouse, Warehouse end_warehouse){
        this.start_warehouse=start_warehouse;
        this.end_warehouse=end_warehouse;

    }

    /**
     * returns start warehouse
     * @return Warehouse
     */
    public Warehouse getStartWarehouse(){
        return start_warehouse;
    }

    /**
     * set start warehouse
     * @param Warehouse start warehouse
     */
    public void setStartWarehouse(Warehouse start_warehouse){
        this.start_warehouse=start_warehouse;

    }

    /**
     * @param Warehouse end warehouse
     */
    public Warehouse getEndWarehouse(){
        return end_warehouse;
    }

    /**
     * set end warehouse
     * @return Warehouse end warehouse
     */
    public void setEndWarehouse(){
        this.end_warehouse=end_warehouse;
    }

}
