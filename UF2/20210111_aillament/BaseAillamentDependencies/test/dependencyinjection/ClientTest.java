/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencyinjection;


import comunicacions.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author bernat
 */
public class ClientTest {
    
    public ClientTest() {
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
     * Test of canviarOferta method, of class Client.
     */
    @Test
    // Versió original sense la injecció
    public void testCanviarOferta() throws Exception{
        System.out.println("canviarOferta");
        
        MissatgerFactory.setTestMode(true);
        
        
        Client c = new Client(1, "Paco", "paco@gmail.com");
        // Versió amb injecció de dependències   
        //c.canviarOferta(20, new MissatgerFake());
        c.canviarOferta(20);
        assertEquals(20, c.getDescompte(), 0.0001);
        
    }
   
    
    
    
}
