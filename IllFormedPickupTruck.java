public class IllFormedPickupTruck extends Exception {

    private String reason;

    public IllFormedPickupTruck(String rsn) {
        reason = rsn;
    }

    @Override
    public String toString() {
        return "Ill formed pickup truck" + reason;
    }
}