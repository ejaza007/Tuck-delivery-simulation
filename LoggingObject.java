import java.io.PrintStream;

/**
 * A class used to create CSV files for simulation results
 *
 * @author Armaghan Ejaz
 * @version 04-18-2022
 */
public class LoggingObject
{
    //initialisation
    PrintStream ps;

    /**
     * method for writing the truck's position at each point to a csv file
     *
     * @author Armaghan Ejaz
     * @version 04-18-2022
     */
    
    public void main (int id, double truckx, double trucky, String status) {
        
        try
        {
            ps=new PrintStream ("results.csv");
        }
        catch (java.io.FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }

        ps.println("Truck" + id + " " + "X position " + truckx);
        ps.println("Truck" + id + " " + "Y position " + trucky);
        ps.println("Truck" + id + " " + " Status " + status);

    
        
        
    }
}
