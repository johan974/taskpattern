package nl.deholtmans.mockitobasic;

public class Consumer {
    public String bewaarFactuur( String klant, String coupon, double prijs) {
        return "Klant=" + klant + ",coupon=" + coupon + ",prijs=" + prijs;
    }
}
