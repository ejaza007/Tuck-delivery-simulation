import java.io.File;
import java.util.Random;

/**
 * A class to run the simulation through a variety of different configuration
files and random seed values.
 *
 * @author Armaghan Ejaz
 * @version 19-04-2022
 */
public class ModelRunner
{

    //initialisation
    public static File file_1;
    public static File file_2;
    public static File file_3;
    public static File file_4;
    public static ConfigurationReader configuration_1;
    public static ConfigurationReader configuration_2;
    public static ConfigurationReader configuration_3;
    public static ConfigurationReader configuration_4; 
    public static Model model_1;
    public static Model model_2;
    public static Model model_3;
    public static Model model_4;
    public static Random rand;
    public static Clock clock;

    /**
     * default constructor of model runner
     */
    public ModelRunner(){

    }

    /**
     * Main class runs the simulation for different seeds and configuration
     *
     * @author Armaghan Ejaz
     * @version 19-04-2022
     */ 
    public static void main(String filename) throws InterruptedException {
        //reads files
        //choose from config_1, config_2, config_3, config_4,
        file_1=new File(filename);

        configuration_1= new ConfigurationReader(file_1);
        try
        {
            configuration_1.main();     
        }
        catch (java.io.FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }


        int w1=configuration_1.warehouse_no();
        int s1=configuration_1.shipment_no();
        int r1=configuration_1.truck_no();


        //runs each configuration 10 times
        for(int i=0;i<10;i++){
            Random rand = new Random(3742198+i);
            Model model_1=new Model(w1,s1,r1,rand);
            model_1.main();

            clock=new Clock(model_1);
            clock.run_simulation(model_1.truck,model_1.dmc);
            model_1.dmc.refresh();

        }

    }
}
