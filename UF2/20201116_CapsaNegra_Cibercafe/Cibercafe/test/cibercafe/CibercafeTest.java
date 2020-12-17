package cibercafe;

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
    public void testCalculFacturacioErroni() {
        Cibercafe c = new Cibercafe();
        int[][] entradesErronies = {
            {7, 59, 10, 0},
            {22, 0, 23, 0},
            {25, 0, 2, 0},
            {-1, 0, 10, 0},
            {10, 60, 11, 0},
            {10, -1, 11, 0},
            {8, 0, 22, 1},
            {8, 0, 25, 0},
            {8, 0, 8, 0},
            {8, 0, 7, 0},
            {8, 0, -1, 0},
            {8, 0, 14, 60},
            {8, 0, 14, -1},
            {10, 20, 8, 45},
            {10, 45, 10, 30}
        };
        
        for (int i = 0; i < entradesErronies.length; i++) {
            try {
             c.calculFacturacio(
                    false,
                    entradesErronies[i][0],
                    entradesErronies[i][1],
                    entradesErronies[i][2],
                    entradesErronies[i][3]);
             fail("El test no ha donat error per dades incorrectes!! "+
                     entradesErronies[i][0]+":"+
                    entradesErronies[i][1]+" - "+
                    entradesErronies[i][2]+":"+
                    entradesErronies[i][3]
             );
            }catch(Exception ex) {
                
            }
        }
        
        
    }

    @Test
    public void testCalculFacturacio() {

        Cibercafe c = new Cibercafe();
        int[][] entradesCorrectes
                = {
                    {8, 0, 20, 0},
                    {8, 30, 10, 0},
                    {9, 0, 9, 45},
                    {9, 0, 11, 30},
                    {13, 30, 14, 30},
                    {11, 55, 14, 1},
                    {11, 0, 15, 30},
                    {14, 0, 16, 30},
                    {8, 0, 22, 0}
                };
        boolean[] socis = {false, false, true, true, true, true, true, true, true};
        double[] sortidesCorrectes = {162, 22.5, 4.5, 18, 10.5, 13.25, 41.85, 22.5, 162};

        for (int i = 0; i < entradesCorrectes.length; i++) {
            assertEquals(sortidesCorrectes[i], c.calculFacturacio(
                    socis[i],
                    entradesCorrectes[i][0],
                    entradesCorrectes[i][1],
                    entradesCorrectes[i][2],
                    entradesCorrectes[i][3]), 0.001);
        }

    }

}
