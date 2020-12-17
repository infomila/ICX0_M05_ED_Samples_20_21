package net.iesmila.ED.UF2.capsa_blanca;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class TheIncredibleMachineTest {

    public TheIncredibleMachineTest() {
    }

    @Test
    public void testCrunch() {
 
        TheIncredibleMachine t = new TheIncredibleMachine();
        t.crunch(new int[]{3, 15, -3 });
        
        t.crunch(new int[]{3, 15, -3, 6, 6, 6, 6, 6, 6, 2,2,2,2, 3,3,3,3 , 5,5,5,5, 1,10,1,3 });
        
        
        

    }

}
