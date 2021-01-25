
package examen.aillament;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bernat
 */
public class ShoppingBasketTest_Factory {
    
    public ShoppingBasketTest_Factory() {
    }

    /**
     * Test of getSummary method, of class ShoppingBasket.
     */
    @Test
    public void testGetSummary() {
        
        // Activem el mode test a la f?brica
        ProductCatalogDB_Factory.setMode(true);
        //--------------------------------------------------
        
        ShoppingBasket sp = new ShoppingBasket();
        ArrayList<Integer> products = new ArrayList<> ( Arrays.asList(534,23, 123,312));
        ArrayList<Integer> units = new ArrayList<> ( Arrays.asList(1,1,1,3));
        
        //------------------------------------------------------------------------------        
        // Customer without discount
        int customerId = 4;
        //------------------------------------------------------------------------------        
        String summary = sp.getSummary(customerId, products, units );
        System.out.println("Obtained:\n"+summary);
        String expected = 
                "| {534}     | Paletilla Iberica 'El Gaznate'	| 41,20€/u   x 1u. = 41,20€\n"+
                "| {23}      | Producte descatalogat\n"+        
                "| {123}     | Jamón Iberico 'JJJJJ'         	| 89,45€/u   x 1u. = 89,45€\n"+
                "| {312}     | Olives farcides d'anxova      	| 2,34€/u    x 1u. = 2,34€\n"+
                "| SUBTOTAL  | 132,99€\n"+
                "| DISCOUNT  | 0,00€\n"+
                "| TOTAL     | 132,99€\n";        
        System.out.println("Expected:\n"+expected);
        assertEquals(expected, summary);
        //------------------------------------------------------------------------------        
        // Customer with discount
        customerId = 10;
        //------------------------------------------------------------------------------        
        summary = sp.getSummary(customerId, products, units );
        System.out.println("Obtained:\n"+summary);
        
        expected = 
                "| {534}     | Paletilla Iberica 'El Gaznate'	| 41,20€/u   x 1u. = 41,20€\n"+
                "| {23}      | Producte descatalogat\n"+        
                "| {123}     | Jamón Iberico 'JJJJJ'         	| 89,45€/u   x 1u. = 89,45€\n"+
                "| {312}     | Olives farcides d'anxova      	| 2,34€/u    x 1u. = 2,34€\n"+
                "| SUBTOTAL  | 132,99€\n"+
                "| DISCOUNT  | 13,30€\n"+
                "| TOTAL     | 119,69€\n";
        System.out.println("Expected:\n"+expected);        
        assertEquals(expected, summary);
        
    }
    
}
