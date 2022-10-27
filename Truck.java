public class Truck {
    
    private String vin;
    private int maxPayload;

    public Truck(String v, int mp) throws IllFormedPickupTruck {
        if (v == null) {
            throw new IllFormedPickupTruck("vin is null");
        }
        if (mp <= 0) {
            throw new IllFormedPickupTruck("maximum payload is null");
        }
        vin = v;
        maxPayload = mp;
    }

    //Getters and Setters
    public String getVin() {
        return vin;
    }
    public int getMaxPayload() {
        return maxPayload;
    }

    public void setVin(String v) {
        vin = v;
    }
    public void setMaxPayload(int mp) {
        maxPayload = mp;
    }
}
