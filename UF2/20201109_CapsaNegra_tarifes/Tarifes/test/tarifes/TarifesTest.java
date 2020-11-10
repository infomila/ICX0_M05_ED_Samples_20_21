package tarifes;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class TarifesTest {

    public TarifesTest() {
    }

    @Test
    public void testGetPreu() {
        int[][] matriu = {
            {1, 2, 0},
            {1, 3, 0},
            {1, 4, 45},
            {1, 6, 45},
            {1, 11, 45},
            {1, 12, 60},
            {1, 40, 60},
            {1, 59, 60},
            {1, 60, 30},
            {1, 80, 30},
            {2, 2, 0},
            {2, 3, 0},
            {2, 4, 37, 5},
            {2, 6, 37, 5},
            {2, 11, 37, 5},
            {2, 12, 50},
            {2, 40, 50},
            {2, 59, 50},
            {2, 60, 10},
            {2, 80, 10},
            {3, 2, 0},
            {3, 3, 0},
            {3, 4, 30},
            {3, 6, 30},
            {3, 11, 30},
            {3, 12, 40},
            {3, 40, 40},
            {3, 59, 40},
            {3, 60, 8},
            {3, 80, 8},
            {4, 2, 0},
            {4, 3, 0},
            {4, 4, 22, 5},
            {4, 6, 22, 5},
            {4, 11, 22, 5},
            {4, 12, 30},
            {4, 40, 30},
            {4, 59, 30},
            {4, 60, 6},
            {4, 80, 6}
        };

        Tarifes t = new Tarifes();
        for( int i=0;i<matriu.length;i++) {
            assertEquals(matriu[i][2], t.getPreu(matriu[i][0], matriu[i][1]), 0.0001);
        }
        try{
            t.getPreu(-1, 40);
            fail("Valor negatiu no admés");
        }catch(Exception ex){            
        }
        
    }

    @Test
    public void testMain() {
    }

}
