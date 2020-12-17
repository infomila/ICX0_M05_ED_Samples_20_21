package cibercafe_dam;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class CibercafeTest {

    public CibercafeTest() {
    }

    @Test
    public void testMain() {
    }

    @Test
    public void testCalculFactuacioErronis() {
        int[][] entrades = {
            {7, 0, 10, 0},
            {22, 0, 10, 0},
            {25, 0, 10, 0},
            {-1, 0, 10, 0},
            {10, 60, 11, 0},
            {10, 61, 11, 0},
            {10, -1, 11, 0},
            {10, 0, 7, 0},
            {10, 0, 22, 1},
            {10, 0, 23, 0},
            {10, 0, -1, 0},
            {10, 0, 11, 60},
            {10, 0, 11, 61},
            {10, 0, 11, -1},
            {10, 3, 9, 40},
            {10, 30, 10, 30},
            {10, 40, 10, 30}
        };
        Cibercafe c = new Cibercafe();
        for (int i = 0; i < entrades.length; i++) {
            try {
                c.calculFacturacio(
                        false,
                        entrades[i][0],
                        entrades[i][1],
                        entrades[i][2],
                        entrades[i][3]);
                fail("El programa HA de donar error quan es donen les entrades:\n"+
                        entrades[i][0]+":"+
                        entrades[i][1]+" - " +
                        entrades[i][2]+":"+
                        entrades[i][3]);
            } catch (Exception ex) {

            }

        }
    }

    @Test
    public void testCalculFacturacio() {

        int[][] entrades = {
            {8, 0, 22, 0},
            {8, 30, 9, 15},
            {9, 0, 9, 45},
            {9, 15, 11, 45},
            {8, 0, 14, 0},
            {13, 30, 14, 30},
            {11, 30, 14, 15},
            {8, 0, 14, 30},
            {14, 0, 22, 0}
        };
        boolean[] soci = {false, false, true, true, true, true, true, true, true};

        double[] imports = {189, 11.25, 4.5, 18, 54, 10.5, 21.75, 60.75, 108};

        Cibercafe c = new Cibercafe();
        for (int i = 0; i < soci.length; i++) {
            assertEquals(
                    imports[i],
                    c.calculFacturacio(
                            soci[i],
                            entrades[i][0],
                            entrades[i][1],
                            entrades[i][2],
                            entrades[i][3]),
                    0.001);

        }

    }

}
