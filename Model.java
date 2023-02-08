import java.util.Random;

/**
 * sets up the model to be run
 *
 * @author Armaghan Ejaz
 * @version 19-04-2022
 */
public class Model{
    //initialization

    public static int s;
    public static int r;
    public static int w;
    public static Random rand;
    public static Warehouse [] warehouse;
    public static Shipments [] shipments;
    public static Truck [] truck;
    public static ManifestItem [] manifestItem;
    public static Manifest [] manifest;
    public static boolean run_simulation=true;
    public static int counter=0;
    public static DynamicMapCntrl dmc ;

    /**
     * Default Constructor for Model class
     * 
     */
    public Model(int w, int s, int r, Random rand){
        this.w=w;
        this.s=s;
        this.r=r;
        this.rand=rand;

    }

    /**
     * Main method which creates all the simulation objects
     * 
     */
    public static void main() throws InterruptedException {

        
        //initialization
        warehouse=new Warehouse[w];
        truck=new Truck[r];
        shipments=new Shipments[s];
        manifestItem=new ManifestItem[s];
        manifest=new Manifest[r];
        dmc = new DynamicMapCntrl("Dynamic Map");
        
        
        //run loops to set up multiple instances of classes to be simulated
        for(int i=0;i<warehouse.length;i++){
            warehouse[i]=new Warehouse();
            dmc.add(warehouse[i]);

        }
        
        for (int i=0;i<shipments.length;i++){
            shipments[i]= new Shipments((rand.nextInt(2)+1),warehouse[rand.nextInt(w-1)]);

        }

        for(int i=0;i<manifestItem.length;i++){
            int start=rand.nextInt(w);
           

            int end=rand.nextInt(w);
           
            while(start==end){
                end=rand.nextInt(w);
            }
            manifestItem[i]=new ManifestItem(warehouse[start],warehouse[end]);
            

        }
        
        //creates mannifest and randomly allocates manifest items to manifest list
        for(int i=0; i<manifest.length;i++){
            manifest[i]=new Manifest();
        }

        for(int i=0; i<manifestItem.length;i++){
            int temp = rand.nextInt(r-1);
            manifest[temp].add(manifestItem[i]);
        }
        
        //conditions for type of trucks
        for (int i=0;i<truck.length;i++){
            int rand_val=rand.nextInt(4);

            if(rand_val==0){
                truck[i]=new Truck1(manifest[i],rand);
                dmc.add(truck[i]);

            }
            if(rand_val==1){
                truck[i]=new Truck2(manifest[i],rand);
                dmc.add(truck[i]);

            }

            if(rand_val==2){
                truck[i]=new Truck3(manifest[i],rand);
                dmc.add(truck[i]);

            }

            if(rand_val==3){
                truck[i]=new Truck4(manifest[i],rand);
                dmc.add(truck[i]);

            }

            if(rand_val==4){
                truck[i]=new Truck5(manifest[i],rand);
                dmc.add(truck[i]);

            }

        }

    }

    public Truck [] getTruck(){
        return truck;
    }

    public void setTruck(Truck [] truck){
        this.truck=truck;
    }

    public Shipments [] getShipmentsArray(){
        return shipments;
    }

    public void setShipmentsArray(Shipments [] shipments){
        this.shipments=shipments;
    }

}
