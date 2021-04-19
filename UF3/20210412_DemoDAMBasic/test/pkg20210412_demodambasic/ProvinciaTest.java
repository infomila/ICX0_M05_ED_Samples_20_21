/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20210412_demodambasic;

import pkg20210412_demodambasic.munis.Provincia;
import pkg20210412_demodambasic.munis.Municipi;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class ProvinciaTest {
    
    public ProvinciaTest() {
    }

    @Test
    public void testGetCapital() {
    }

    @Test
    public void testSetCapital() {
    }

    @Test
    public void testAddMunicipi() {
        
        Provincia p1 = new Provincia(1, "Barcelona");
        Municipi m1 = new Municipi(1, "Igualada",p1);
        assertEquals(p1 , m1.getProvincia());
        assertEquals(1, p1.getNumMunicipis());
        //-----------------------------------------
        Municipi m2 = new Municipi(2, "Manresa",p1);
        assertEquals(2, p1.getNumMunicipis());
        assertEquals( m1, p1.getMunicipi(0));
        assertEquals( m2, p1.getMunicipi(1));
        //-----------------------------------------
        try{
            Municipi m3 = new Municipi(2, "666",p1);
            fail("No podem deixar que es creï un municipi duplicat en una província.");
        } catch(Exception ex){}
        
        assertEquals(2, p1.getNumMunicipis());        
        //-----------------------------------------
        Provincia p2 = new Provincia(2, "Lleida");
        Municipi m4 = new Municipi(4, "Sort",p1);
        assertEquals(3, p1.getNumMunicipis());
        assertEquals(0, p2.getNumMunicipis());
        m4.setProvincia(p2);
        assertEquals(1, p2.getNumMunicipis());
        assertEquals(2, p1.getNumMunicipis());        
        assertEquals( p2, m4.getProvincia() );
        //----------------------------
        p1.addMunicipi(m4);
        assertEquals(3, p1.getNumMunicipis());
        assertEquals(0, p2.getNumMunicipis());
        //-----------------------------
        // remove....no té sentit que sigui
        // públic
        //p1.removeMunicipi(m4);
    }

    @Test
    public void testRemoveMunicipi_int() {
    }

    @Test
    public void testRemoveMunicipi_Municipi() {
    }

    @Test
    public void testGetNumMunicipis() {
    }

    @Test
    public void testGetMunicipi() {
    }

    @Test
    public void testGetMunicipisIterator() {
    }

    @Test
    public void testHashCode() {
    }

    @Test
    public void testEquals() {
    }
    
}
