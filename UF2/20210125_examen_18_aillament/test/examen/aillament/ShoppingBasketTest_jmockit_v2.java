
package examen.aillament;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bernat
 */
public class ShoppingBasketTest_jmockit_v2 {
    
    public ShoppingBasketTest_jmockit_v2() {
    }

    /**
     * Test of getSummary method, of class ShoppingBasket.
     */
    
    @Mocked ProductCatalogDB pcdb;
    
    @Test
    public void testGetSummary() {
        
        //------------------------------------------------------
        //   Usarem l'API d'Expectations
        new NonStrictExpectations() {{
            //---------------------------------------------
            pcdb.getCustomerDiscount(4);        result=0.0;
            pcdb.getCustomerDiscount(10);       result=10.0;
            pcdb.getCustomerDiscount(anyInt);   result=new RuntimeException("Id no suportat");
            //---------------------------------------------
            pcdb.getProductInfo(534);       result =new ProductInfo(534, 41.20, "Paletilla Iberica 'El Gaznate'" );
            pcdb.getProductInfo(23);        result = null;
            pcdb.getProductInfo(123);       result =new ProductInfo(123, 89.45, "Jamón Iberico 'JJJJJ'" );
            pcdb.getProductInfo(312);       result =new ProductInfo(312, 2.34, "Olives farcides d'anxova" );
            pcdb.getProductInfo(anyInt);    result=new RuntimeException("Id no suportat");
                    
        }};
        
        //------------------------------------------------------
         
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
