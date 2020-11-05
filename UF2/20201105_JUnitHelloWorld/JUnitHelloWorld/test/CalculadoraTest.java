
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class CalculadoraTest {

    public CalculadoraTest() {
    }

    @Test
    public void testSuma() {
        Calculadora c = new Calculadora();
        int s = c.suma(1, 2);
        assertEquals(3, s);
        
        s = c.suma(1, -1);
        assertEquals(0, s);
        
        s = c.suma(1, Integer.MAX_VALUE);
        assertEquals(Integer.MIN_VALUE, s);
        
        //fail("El test ha petat");
        
     }

    @Test
    public void testResta() {
        Calculadora c = new Calculadora();
        int s = c.resta(1, 2);
        assertEquals(-1, s);
    }

    
 
}
