import javax.swing.JFrame;
public class DynamicMapCntrl {
JFrame appFrame;
DynamicMap map;
public DynamicMapCntrl() {
System.out.println("base constructor");
}
public void refresh() {
map.repaint();
}
public void add(Truck t) {

map.add(t);
}
public void add(Warehouse w){
    map.add(w);
}
public DynamicMapCntrl(String str)
{
appFrame = new JFrame();
map = new DynamicMap();
appFrame.setSize(400, 250);
appFrame.setTitle("Histogram Viewer");
appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Add the HistogramComponent object to the frame
appFrame.add(map);
// Set the frame and its contents visible
appFrame.setVisible(true);
}
}
