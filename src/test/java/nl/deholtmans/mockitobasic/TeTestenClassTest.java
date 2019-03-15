package nl.deholtmans.mockitobasic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TeTestenClassTest {
    @Mock
    Provider provider;
    @Mock
    Consumer consumer;
    @InjectMocks
    TeTestenClass teTestenClass;

    /*
     * TIPS:
     *    - Kies hele goede test-method namen -- erg belangrijk
     *    - Zorg dat je de buitenkant test, want anders moet je bij elke implementatiewijziging je testen veranderen.
     *    - Zorg voor een net voldoende set met testen, niet te veel, want dan is het niet te onderhouden.
     *
     * Per class - welke methods wil je testen?
     *   Je zorgt ervoor dat de class-externe afhankelijkheden "injectable" zijn via een constructor of 'setter' method
     *      Waarom -- dan kun je ze injecteren met Mocks tijdens het testen. Dan ben je niet afhankelijk van die classes.
     *
     * Opbouw via BDD testen:
     *   Given ... zet de antwoorden klaar die je van EXTERNE classes / services hebt. Dus onafhankelijk maken.
     *   When  ... je roept de method aan op de class-under-test. Die doet een bepaalde logica: via returns en aanroepen
     *   Then  ... controleer de reusltaten: returns + aanroepen.
     */

    // Test geval 1 - alleen maar RETURN en precieze aanroep van consumer testen
    @Test
    public void testMetDuidelijkeOmschrijving() {
        // Given
        String klant = "klant1";
        String product = "prod1";
        String coupon = "korting123";
        double duurProduct = 30.0d;
        double kortingPrijs = 15.0d;
        // Zet hier de resultaten klaar van de providers. Hier zijn dat simpele getallen: 10.0, 5.0.
        when(provider.bepaalPrijs(product)).thenReturn(duurProduct);
        // When
        double berekendePrijs = teTestenClass.bepaalPrijsEnLegVast(klant, coupon, product);
        // Then - this is called
        verify(consumer).bewaarFactuur(klant, coupon, kortingPrijs);
        assertEquals(15.0d, berekendePrijs, 0.01);
    }

    // Test geval 2 - alleen maar RETURN en precieze aanroep van consumer testen weet je nog niet. Je test het argument van die call.
    @Test
    public void testMetDuidelijkeOmschrijving2() {
        // Given
        String klant = "klant1";
        String product = "prod1";
        String coupon = "korting123";
        double duurProduct = 30.0d;
        double kortingPrijs = 15.0d;
        // Zet hier de resultaten klaar van de providers. Hier zijn dat simpele getallen: 10.0, 5.0.
        when(provider.bepaalPrijs(product)).thenReturn(duurProduct);
        // When
        double berekendePrijs = teTestenClass.bepaalPrijsEnLegVast(klant, coupon, product);
        // Then - this is called
        ArgumentCaptor<Double> calculatedPriceArgument = ArgumentCaptor.forClass(Double.class);
        verify(consumer).bewaarFactuur(eq(klant), eq(coupon), calculatedPriceArgument.capture());
        assertEquals(kortingPrijs, calculatedPriceArgument.getValue(), 0.01);
    }

}
