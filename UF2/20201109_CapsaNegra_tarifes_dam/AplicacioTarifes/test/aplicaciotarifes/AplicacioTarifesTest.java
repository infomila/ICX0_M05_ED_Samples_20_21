package aplicaciotarifes;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class AplicacioTarifesTest {

    public AplicacioTarifesTest() {
    }

    @Test
    public void testGetPreu() {
        double[][] valors = {
            {1, 2, 0},
            {2, 2, 0},
            {3, 2, 0},
            {4, 2, 0},
            {1, 3, 0},
            {2, 3, 0},
            {3, 3, 0},
            {4, 3, 0},
            {1, 4, 45},
            {2, 4, 37.5},
            {3, 4, 30},
            {4, 4, 22.5},
            {1, 6, 45},
            {2, 6, 37.5},
            {3, 6, 30},
            {4, 6, 22.5},
            {1, 11, 45},
            {2, 11, 37.5},
            {3, 11, 30},
            {4, 11, 22.5},
            {1, 12, 60},
            {2, 12, 50},
            {3, 12, 40},
            {4, 12, 30},
            {1, 40, 60},
            {2, 40, 50},
            {3, 40, 40},
            {4, 40, 30},
            {1, 59, 60},
            {2, 59, 50},
            {3, 59, 40},
            {4, 59, 30},
            {1, 60, 30},
            {2, 60, 10},
            {3, 60, 8},
            {4, 60, 6},
            {1, 80, 30},
            {2, 80, 10},
            {3, 80, 8},
            {4, 80, 6}
        };
        AplicacioTarifes at = new AplicacioTarifes();
        for(int i=0;i<valors.length;i++) {
            System.out.println(">t:"+(int)valors[i][0] + "/ e:"+(int)valors[i][1]);
            assertEquals(valors[i][2], 
                    at.getPreu((int)valors[i][0], (int)valors[i][1]), 0.0001);
        }

    }
 
    @Test
    public void testGetPreu_CasosErronis(){

        testejaCasErroni( 5, 30);
        testejaCasErroni( -1, 30);
        testejaCasErroni( 0, 30);
        testejaCasErroni( 1, 0);
        testejaCasErroni( 1, -1);
        testejaCasErroni( 1, 120);
        //---------------------------------------------------------
    }
    
    private void testejaCasErroni( int tipusSeient, int edat) {
        AplicacioTarifes at = new AplicacioTarifes();
        try {
            at.getPreu(tipusSeient, edat);
            // si estic aquí.....no ha petat !!
            fail("El valor t:"+tipusSeient+" i e:"+edat+" no és vàlid.");
        } catch(Exception e) {
            //si estic aquí, tot va bé
        }        
    }

}
