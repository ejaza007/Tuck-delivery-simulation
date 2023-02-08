
/**
 * Ticks down hours and runs action methods of trucks
 *
 * @author Armaghan Ejaz    
 * @version 07-04-2022
 */
public class Clock 

{  
    //initialization
    int timer;
    boolean end_simulation=false;

    /**
     *  Default Constructor for Clock Class
     */
    public Clock(Model model){
        timer=0;

    }

    /**
     *  runs the simulation
     * 
     * @param Truck Array, Dynamic Map
     */
    public void run_simulation(Truck [] truckArr,DynamicMapCntrl dmc){
        //counter for if every truck has finished deliveries
        int counter=0;
        //loops till all trucks have finished
        while(end_simulation==false){
            //all trucks perform action 
            for (int i=0;i<truckArr.length;i++){
                
                    truckArr[i].action();
                    dmc.refresh();
                

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException err) {
                    System.out.println(err);
                }
                if(truckArr[i].finishDelivery==true){
                    counter++;

                }
                timer++;
            }
            if(counter==truckArr.length){
                end_simulation=true;
            }
            
        }
        
        dmc.refresh();
        System.out.println(timer);
    }

    /**
     * returns time passed
     * 
     * @return Timer
     */
    public int gettimer(){
        return timer;
    }

    /**
     * sets time passed
     * 
     * @param timer
     */
    public void settimer(int timer){
        this.timer=timer;

    }
}

