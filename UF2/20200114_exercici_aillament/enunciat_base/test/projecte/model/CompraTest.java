/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte.model;

import projecte.model.Compra;
import projecte.model.Producte;
import static org.junit.Assert.*;
//import java.util.*;
import org.junit.*;

/**
 *
 * @author bernat
 */
public class CompraTest {
    
    public CompraTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of afegirProducte method, of class Compra.
     */
    @Test
    public void testConfirmarCompra() throws Exception{
            Compra compra = new Compra(4423);

            // ==========================================================================
            //   Exemple de l'utilització directa d'una tercera classe (Producte) 
            //   en el testing de Compra.
            // ==========================================================================

            Producte p1 = new Producte(1); // producte 1 de la base de dades  : Col, 10 unitats
            int stockAbansCompra = p1.getStock();
            Producte p3 = new Producte(3); // producte 3 de la base de dades  : Col, 4 unitats      

            assertFalse(compra.afegirProducte(p1, 50)); // estock demanat superior al disponible --> no es crea la línia
            assertEquals(compra.getNumeroLinies(), 0);

            assertFalse(compra.afegirProducte(p1, -50)); // estock negatiu --> no es crea la línia
            assertEquals(compra.getNumeroLinies(), 0);
            
            assertTrue(compra.afegirProducte(p1, 5)); // estock demanat inferior al disponible --> es crea la línia
            assertEquals( stockAbansCompra-5, p1.getStock());
            assertEquals(compra.getNumeroLinies(), 1);    
            assertEquals( compra.getPreuTotal(), 5 * p1.getPreu() , 0.0001);

            assertTrue(compra.afegirProducte(p3, 3));
            assertEquals(compra.getNumeroLinies(), 2);    
            assertEquals( compra.getPreuTotal(), 5 * p1.getPreu() +  3 * p3.getPreu() , 0.0001);

            compra.confirmarCompra();
            
         /*   
        }catch(Exception e)
        {
            fail("Error no esperat:"+e.getMessage());
        }*/
    }

}
