package net.iesmila.ED.UF2.fabrica;

import org.junit.Test;
import static org.junit.Assert.*;


public class LectorTest {
    
    public LectorTest() {
    }

    /**
     * Test of extreuParaulesAmbDefinicio method, of class Lector.
     */
    @Test
    public void testInformeText() {
        
        Lector l = new Lector();
        String informeObtingut = l.extreuParaulesAmbDefinicio("El gos i el gat viuen a casa");
        String informeEsperat = "gos: mamifer cannid,gat: mamifer feli,casa: llar dolça llar";
        assertEquals(informeEsperat, informeObtingut );
        
    }
}
