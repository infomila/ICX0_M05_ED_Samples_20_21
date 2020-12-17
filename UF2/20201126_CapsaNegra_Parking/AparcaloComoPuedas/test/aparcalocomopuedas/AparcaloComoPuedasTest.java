package aparcalocomopuedas;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class AparcaloComoPuedasTest {

    public AparcaloComoPuedasTest() {
    }

    @Test
    public void testBuscaLlocLliure_CasosErronis() {

        //Codi erroni
        int r = AparcaloComoPuedas.buscaLlocLliure(
                -1, 600,
                new int[]{0, 0, 50},
                new int[]{650, 600, 650},
                new boolean[]{true, false, false});
        assertEquals(AparcaloComoPuedas.ERROR, r);
        //Long errònia
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 0,
                new int[]{0, 0, 50},
                new int[]{650, 600, 650},
                new boolean[]{true, false, false});
        assertEquals(AparcaloComoPuedas.ERROR, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, -1,
                new int[]{0, 0, 50},
                new int[]{650, 600, 650},
                new boolean[]{true, false, false});
        assertEquals(AparcaloComoPuedas.ERROR, r);
        //array codi client
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 500,
                new int[]{0, 0, -1},
                new int[]{650, 600, 650},
                new boolean[]{true, false, false});
        assertEquals(AparcaloComoPuedas.ERROR, r);

//array long
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 500,
                new int[]{0, 0, 0},
                new int[]{650, 600, 0},
                new boolean[]{true, false, false});
        assertEquals(AparcaloComoPuedas.ERROR, r);

        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 500,
                new int[]{0, 0, 0},
                new int[]{650, 600, -1},
                new boolean[]{true, false, false});
        assertEquals(AparcaloComoPuedas.ERROR, r);
// null
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 500,
                null,
                new int[]{650, 600, 650},
                new boolean[]{true, false, false});
        assertEquals(AparcaloComoPuedas.ERROR, r);

        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 500,
                new int[]{0, 0, 0},
                null,
                new boolean[]{true, false, false});
        assertEquals(AparcaloComoPuedas.ERROR, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 500,
                new int[]{0, 0, 0},
                new int[]{650, 600, 650},
                null);
        assertEquals(AparcaloComoPuedas.ERROR, r);
        // Arrays buits
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 500,
                new int[]{},
                new int[]{650, 600, 650},
                new boolean[]{true, false, false});
        assertEquals(AparcaloComoPuedas.ERROR, r);

        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 500,
                new int[]{0, 0, 0},
                new int[]{},
                new boolean[]{true, false, false});
        assertEquals(AparcaloComoPuedas.ERROR, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 500,
                new int[]{0, 0, 0},
                new int[]{650, 600, 650},
                new boolean[]{});
        assertEquals(AparcaloComoPuedas.ERROR, r);
        //--------------
        //diferents longituds
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 500,
                new int[]{0, 0},
                new int[]{650, 600, 650},
                new boolean[]{true, true, true});
        assertEquals(AparcaloComoPuedas.ERROR, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 500,
                new int[]{0, 0, 0},
                new int[]{650, 600},
                new boolean[]{true, true, true});
        assertEquals(AparcaloComoPuedas.ERROR, r);        
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 500,
                new int[]{0, 0, 0},
                new int[]{650, 600, 650},
                new boolean[]{true, true});
        assertEquals(AparcaloComoPuedas.ERROR, r);        
    }

    @Test
    public void testBuscaLlocLliure() {

        int r = AparcaloComoPuedas.buscaLlocLliure(
                0, 600,
                new int[]{0, 0, 50, 60, 60},
                new int[]{650, 600, 650, 400, 650},
                new boolean[]{true, false, false, false, true});
        assertEquals(-1, r);
        //--------------------------------------
        r = AparcaloComoPuedas.buscaLlocLliure(
                50, 600,
                new int[]{0, 0, 50, 50, 60},
                new int[]{650, 600, 650, 400, 650},
                new boolean[]{true, false, true, false, false});
        assertEquals(-1, r);
        //------------------------------------
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 600,
                new int[]{0, 0, 50, 60, 60, 0, 0},
                new int[]{650, 600, 650, 400, 650, 601, 601},
                new boolean[]{true, false, false, false, true, false, false});
        assertEquals(5, r);
        //--------------------------------------
        r = AparcaloComoPuedas.buscaLlocLliure(
                50, 600,
                new int[]{0, 0, 50, 50, 60, 50, 0},
                new int[]{650, 600, 650, 400, 650, 650, 650},
                new boolean[]{true, false, true, false, false, false, false});
        assertEquals(5, r);
        //--------------------------------------
        r = AparcaloComoPuedas.buscaLlocLliure(
                50, 600,
                new int[]{0, 0, 0, 50, 50, 60, 50},
                new int[]{650, 650, 600, 650, 400, 650, 650},
                new boolean[]{false, true, false, true, false, false, true});
        assertEquals(0, r);
    }//--------------------------------------
/*
    @Test
    public void testBuscaLlocLliure_Erronis() {

        int r = AparcaloComoPuedas.buscaLlocLliure(
                -2, 600,
                new int[]{0, 0},
                new int[]{650, 600},
                new boolean[]{true, false});
        assertEquals(-2, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 0,
                new int[]{0, 0},
                new int[]{650, 600},
                new boolean[]{true, false});
        assertEquals(-2, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, -1,
                new int[]{0, 0},
                new int[]{650, 600},
                new boolean[]{true, false});
        assertEquals(-2, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 600,
                new int[]{0, -1},
                new int[]{650, 600},
                new boolean[]{true, false});
        assertEquals(-2, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 600,
                new int[]{0, 1},
                new int[]{650, 0},
                new boolean[]{true, false});
        assertEquals(-2, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 600,
                new int[]{0, 1},
                new int[]{650, -1},
                new boolean[]{true, false});
        assertEquals(-2, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 600,
                null,
                new int[]{650, 650},
                new boolean[]{true, false});
        assertEquals(-2, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 600,
                new int[]{0, 1},
                null,
                new boolean[]{true, false});
        assertEquals(-2, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 600,
                new int[]{0, 1},
                new int[]{650, 650},
                null);
        assertEquals(-2, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 600,
                new int[]{},
                new int[]{650, 650},
                new boolean[]{true, false});
        assertEquals(-2, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 600,
                new int[]{0, 1},
                new int[]{},
                new boolean[]{true, false});
        assertEquals(-2, r);
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 600,
                new int[]{0, 1},
                new int[]{650, 650},
                new boolean[]{});
        assertEquals(-2, r);
        
        r = AparcaloComoPuedas.buscaLlocLliure(
                0, 600,
                new int[]{0},
                new int[]{650, 650},
                new boolean[]{true,true});
        assertEquals(-2, r);
        
                r = AparcaloComoPuedas.buscaLlocLliure(
                0, 600,
                new int[]{0, 1},
                new int[]{650},
                new boolean[]{true,true});
        assertEquals(-2, r);
        
                r = AparcaloComoPuedas.buscaLlocLliure(
                0, 600,
                new int[]{0, 1},
                new int[]{650, 650},
                new boolean[]{true});
        assertEquals(-2, r);
    }
     */
    @Test
    public void testMain() {
    }

}
