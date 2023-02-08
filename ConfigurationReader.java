import java.io.File;
import java.util.Scanner;

/**
 * Creates random configuration files
 *
 * @author Armaghan Ejaz
 * @version 07-04-20022
 */
public class ConfigurationReader
{
    //initialisation
    static File file;
    public static int w;
    public static int s;
    public static int r;
    
    /**
     * Default constructor for ConfigurationReader
     */
    public ConfigurationReader(File file){
        this.file=file;
    }
    
    /**
     * main method
     * reads in files and stores the information
     */
    public static void  main () throws java.io.FileNotFoundException {
        
        try{

            Scanner s1=new Scanner(file);

            
                String line=s1.nextLine();
                Scanner s2=new Scanner (line);
                w=s2.nextInt();     
               
                
                line=s1.nextLine();
                s2=new Scanner(line);
                s=s2.nextInt();
              
                
                line=s1.nextLine();
                s2=new Scanner(line);
                r=s2.nextInt();
               
                
                
                
                
                
        }

        catch (java.io.FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
    }
    
    /**
     * returns number of warehouse read from file
     * 
     * @return int w
     */
    public int warehouse_no(){
        return w;
    }
    
    /**
     * returns number of shipments read from file
     * 
     * @return int s
     */
    public int shipment_no(){
        return s;
    }
    
    /**
     * returns number of trucks read from file
     * 
     * @return int r
     */
    public int truck_no(){
        return r;
    }

}
