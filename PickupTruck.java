import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class PickupTruck extends Truck{
    
    private static ArrayList<PickupTruck> list = new ArrayList<>();
    private static PrintWriter pw;
    private String addMake;
    private String model;

    public PickupTruck(String v, int mp, String am, String m) throws IllFormedPickupTruck{
        super(v, mp);
        if (am == null) {
            throw new IllFormedPickupTruck("additional make is null");
        }
        if (m == null) {
            throw new IllFormedPickupTruck("model is null");
        }
        addMake = am;
        model = m;
    }


    //Getters
    public String getAdditionalMake() {
        return addMake;
    }
    public String getModel() {
        return model;
    }


    public static void writeTrucks(String fileName, ArrayList<PickupTruck> truckList)
    throws FileNotFoundException {
        //Write info from arraylist into trucks.txt
        try {
            pw = new PrintWriter(fileName);
            for (PickupTruck pt : truckList) {
                String v = pt.getVin();
                int mp = pt.getMaxPayload();
                String am = pt.getAdditionalMake();
                String m = pt.getModel();
                pw.println(v + "," + mp + "," + am + "," + m);
            }
            pw.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found " + e.toString());
            return;
        }
    }

    public static void main(String[] args) {
        //Create two different kinds of trucks and add the to list
        try {
            PickupTruck pt = new PickupTruck("ABC123", 2000, "Ranger", "Ford");
            list.add(pt);
            PickupTruck pt2 = new PickupTruck("XYZ123", 3500, "F-150", "Ford");
            list.add(pt2);
            writeTrucks("trucks.txt", list);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found " + e.toString());
            return;
        }
        catch (IllFormedPickupTruck e) {
            System.out.println("Invalid pickup truck" + e.toString());
            return;
        }
    }
}
