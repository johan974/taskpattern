package nl.deholtmans.mockitobasic;

public class TeTestenClass {

    private Provider provider;
    private Consumer consumer;

    public TeTestenClass( Provider provider, Consumer consumer) {
        this.provider = provider;
        this.consumer = consumer;
    }

    public double bepaalPrijsEnLegVast( String klant, String coupon, String product) {
        double prijs = provider.bepaalPrijs( product);
        prijs = bepaalPrijsObsCoupon( prijs, coupon);
        consumer.bewaarFactuur( klant, coupon, prijs);
        return prijs;
    }

    private double bepaalPrijsObsCoupon( double prijs, String coupon) {
        if( coupon.startsWith( "korting")) {
            return prijs * 0.5;
        }
        return prijs;
    }
}
