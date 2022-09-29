public class UsedCarException extends Exception {
    UsedCarException(String vin) {
        super(vin);
    }
}
