package nl.deholtmans.mockitobasic;

public class Provider {
    public double bepaalPrijs( String product) {
        if( product != null && product.equals( "duur")) {
            return 30.0d;
        } else {
            return 10.0d;
        }
    }
}
