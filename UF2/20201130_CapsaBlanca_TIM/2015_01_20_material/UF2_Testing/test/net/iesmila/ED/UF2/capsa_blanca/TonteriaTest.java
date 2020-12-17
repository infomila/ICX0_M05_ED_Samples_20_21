
package net.iesmila.ED.UF2.capsa_blanca;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class TonteriaTest {
    
    public TonteriaTest() {
    }

    @Test
    public void testCobertura() {
        Tonteria.Cobertura(3, 5);
        Tonteria.Cobertura(3, 4);
        Tonteria.Cobertura(0, 4);
    }
    
}
