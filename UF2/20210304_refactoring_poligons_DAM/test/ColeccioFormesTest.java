/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Professor
 */
public class ColeccioFormesTest {
    
    public ColeccioFormesTest() {
    }

  
    /**
     * Test of informeFormes method, of class ColeccioFormes.
     */
    @Test
    public void testInformeFormes() {
        ColeccioFormes c = new ColeccioFormes();
        c.addForma(new Triangle( 2));
        c.addForma(new Cercle( 2));
        c.addForma(new Cercle( 3));
        c.addForma(new Quadrat( 3));
        c.addForma(new Triangle( 4));
        c.addForma(new Quadrat( 3));
        c.addForma(new Quadrat( 1));
        String resultat = 
                "========================"+"\n" +
                "- Figura <2>: Triangle	 costat - 2.0 - area 2"+"\n" +
                "- Figura <3>: Cercle	 costat - 2.0 - area 12,57"+"\n" +
                "- Figura <4>: Cercle	 costat - 3.0 - area 28,27"+"\n" +
                "- Figura <5>: Quadrat	 costat - 3.0 - area 9"+"\n" +
                "- Figura <6>: Triangle	 costat - 4.0 - area 8"+"\n" +
                "- Figura <7>: Quadrat	 costat - 3.0 - area 9"+"\n" +
                "- Figura <8>: Quadrat	 costat - 1.0 - area 1"+"\n" +
                "========================"+"\n" +
                "Total figures:7, area total:69,84"+"\n" +
                "========================"+"\n" +
                "Total Quadrats:3, area final:19, costat mig:2,33"+"\n" +
                "========================"+"\n" +
                "Total Cercles:2, area final:40,84, costat mig:2,5"+"\n" +
                "========================"+"\n" +
                "Total triangles:2, area final:10, costat mig:3"+"\n" +
                "========================"+"\n";
        
        String informe = c.informeFormes(); 
        System.out.println("INFORME ESPERAT:\n"+resultat);
        System.out.println("\nINFORME OBTINGUT:\n"+informe);
        
        
        assertTrue( "informe erroni:", resultat.equals(informe));
    }
}
