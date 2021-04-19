/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        Provincia p1 = new Provincia(1, "Barcelona");
        Municipi m1 = new Municipi(p1, 1,"Igualada");
        assertFalse( m1.esCapital() );
        p1.setCapital(m1);
        assertTrue( m1.esCapital() );
        assertEquals(m1, p1.getCapital());
        //--------------------------------------
        Provincia p2 = new Provincia(2, "Lleida");
        Municipi m4 = new Municipi(p2, 5,"Sort"); 
        try{
            p1.setCapital(m4);
            fail("No podem assignar un municipi d'una província com a capital d'una altra.");
        }catch(Exception ex) {
            
        }
        assertEquals(m1, p1.getCapital());
        //--------------------------------------
        Municipi m2 = new Municipi(p1, 2,"Manresa");
        assertEquals(m1, p1.getCapital());
        p1.setCapital(m2);
        assertEquals(m2, p1.getCapital());
        assertFalse( m1.esCapital() );
        assertTrue( m2.esCapital() );

    }

    @Test
    public void testAddMunicipi() {
        
        Provincia p1 = new Provincia(1, "Barcelona");
        Municipi m1 = new Municipi(p1, 1,"Igualada");
        assertEquals(p1, m1.getProvincia());
        assertEquals(1, p1.getNumMunicipis());   
        assertEquals( m1 , p1.getMunicipi(0));
        //--------------------------------------------.
        Municipi m2 = new Municipi(p1, 2,"Manresa");
        assertEquals(2, p1.getNumMunicipis()); 
        
        try {
            Municipi m3 = new Municipi(p1, 2,"xxxx");
            fail("No hem d'admetre que es creïn municipis duplicats");
        }catch(Exception ex) {            
        }
        assertEquals(2, p1.getNumMunicipis()); 
        //-----------------------------------------------
        Provincia p2 = new Provincia(2, "Lleida");
        Municipi m4 = new Municipi(p1, 5,"Sort");
        assertEquals(3, p1.getNumMunicipis()); 
        assertEquals(0, p2.getNumMunicipis()); 
        p2.addMunicipi(m4);
        assertEquals(2, p1.getNumMunicipis()); 
        assertEquals(1, p2.getNumMunicipis()); 
        assertEquals(p2 , m4.getProvincia());
        assertEquals(m4 , p2.getMunicipi(0));
        m4.setProvincia(p1);
        assertEquals(3, p1.getNumMunicipis()); 
        assertEquals(0, p2.getNumMunicipis());
        
        //-------------------------------------------------------
        // remove ????????
        
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
    public void testGetMunicipiIterator() {
    }

    @Test
    public void testHashCode() {
    }

    @Test
    public void testEquals() {
    }
    
}
