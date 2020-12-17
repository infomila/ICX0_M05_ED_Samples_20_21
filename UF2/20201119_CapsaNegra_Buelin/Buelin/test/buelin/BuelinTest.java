/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buelin;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class BuelinTest {

    public BuelinTest() {
    }

    @Test
    public void testGetSobrecostPerEquipatge_casos_normals() {

        Buelin b = new Buelin();
        // Proves sense equipatge de cap tipus
        assertEquals(0, b.getSobrecostPerEquipatge(null, 0, null, true), 0.001);
        assertEquals(0, b.getSobrecostPerEquipatge(null, 0, null, false), 0.001);
        assertEquals(0, b.getSobrecostPerEquipatge(new int[]{}, 0, null, false), 0.001);
        assertEquals(0, b.getSobrecostPerEquipatge(new int[]{}, 0, new int[]{}, false), 0.001);
        //-------------------------------------------------------------------------------------
        // Proves amb equipatge de mà només.
        assertEquals(0, b.getSobrecostPerEquipatge(new int[]{30, 30, 30}, 20, null, false), 0.001);
        assertEquals(60, b.getSobrecostPerEquipatge(new int[]{31, 30, 30}, 25, null, false), 0.001);
        assertEquals(60, b.getSobrecostPerEquipatge(new int[]{30, 31, 30}, 25, null, false), 0.001);
        assertEquals(60, b.getSobrecostPerEquipatge(new int[]{30, 30, 31}, 25, null, false), 0.001);
        assertEquals(20, b.getSobrecostPerEquipatge(new int[]{30, 30, 30}, 21, null, false), 0.001);
        //-------------------------------------------------------------------------------------
        // Proves amb maletes només.
        assertEquals(0, b.getSobrecostPerEquipatge(null, 0, new int[]{}, false), 0.001);
        // casos 1 maleta
        assertEquals(0, b.getSobrecostPerEquipatge(null, 0, new int[]{20}, false), 0.001);
        assertEquals(20, b.getSobrecostPerEquipatge(null, 0, new int[]{21}, false), 0.001);
        // casos 2 maletes
        assertEquals(0, b.getSobrecostPerEquipatge(null, 0, new int[]{20, 20}, false), 0.001);
        assertEquals(20, b.getSobrecostPerEquipatge(null, 0, new int[]{21, 20}, false), 0.001);
        assertEquals(20, b.getSobrecostPerEquipatge(null, 0, new int[]{20, 21}, false), 0.001);
        assertEquals(40, b.getSobrecostPerEquipatge(null, 0, new int[]{21, 21}, false), 0.001);
        // casos 3 maletes
        assertEquals(200, b.getSobrecostPerEquipatge(null, 0, new int[]{20, 20, 20}, false), 0.001);
        assertEquals(240, b.getSobrecostPerEquipatge(null, 0, new int[]{21, 21, 20}, false), 0.001);
        //-------------------------------------------------------------------------------------
        // Proves combinades maletes + equipatge de mà
        assertEquals(300, b.getSobrecostPerEquipatge(new int[]{31, 30, 30}, 25, new int[]{21, 21, 20}, false), 0.001);
        assertEquals(302, b.getSobrecostPerEquipatge(new int[]{31, 30, 30}, 25, new int[]{21, 21, 20}, true), 0.001);

    }

    @Test
    public void testGetSobrecostPerEquipatge_casos_error() {

        Buelin b = new Buelin();

        testGetSobrecostPerEquipatge_Exception(new int[]{0, 30, 30}, 20, null, false);
        testGetSobrecostPerEquipatge_Exception(new int[]{-1, 30, 30}, 20, null, false);
        testGetSobrecostPerEquipatge_Exception(new int[]{30, 0, 30}, 20, null, false);
        testGetSobrecostPerEquipatge_Exception(new int[]{30, -1, 30}, 20, null, false);
        testGetSobrecostPerEquipatge_Exception(new int[]{30, 30, 0}, 20, null, false);
        testGetSobrecostPerEquipatge_Exception(new int[]{30, 30, -1}, 20, null, false);
        testGetSobrecostPerEquipatge_Exception(new int[]{30}, 20, null, false);
        testGetSobrecostPerEquipatge_Exception(new int[]{30, 30}, 20, null, false);
        testGetSobrecostPerEquipatge_Exception(new int[]{30, 30, 30, 30}, 20, null, false);

        testGetSobrecostPerEquipatge_Exception(new int[]{30, 30, 30}, 0, null, false);
        testGetSobrecostPerEquipatge_Exception(new int[]{30, 30, 30}, -1, null, false);

        testGetSobrecostPerEquipatge_Exception(null, 0, new int[]{0}, false);
        testGetSobrecostPerEquipatge_Exception(null, 0, new int[]{-1}, false);
        testGetSobrecostPerEquipatge_Exception(null, 0, new int[]{20, 0}, false);
        testGetSobrecostPerEquipatge_Exception(null, 0, new int[]{20, -1}, false);
        testGetSobrecostPerEquipatge_Exception(null, 0, new int[]{20, 20, 0}, false);
        testGetSobrecostPerEquipatge_Exception(null, 0, new int[]{20, 20, -1}, false);

    }

    private void testGetSobrecostPerEquipatge_Exception(
            int midaEquipatgeMaCm[],
            int pesEquipatgeMa,
            int pesMaletes[],
            boolean pagaAmbTarja) {
        Buelin b = new Buelin();
        try {
            b.getSobrecostPerEquipatge(midaEquipatgeMaCm, pesEquipatgeMa, pesMaletes, pagaAmbTarja);
            String missatge = "";
            missatge
                    += "\nmidaEquipatgeMaCm:" + midaEquipatgeMaCm
                    + "\npesEquipatgeMa:" + pesEquipatgeMa
                    + "\npesMaletes:" + pesMaletes
                    + "\npagaAmbTarja:" + pagaAmbTarja;
            fail("Error: cas de paràmetres incorrectes no controlat." + missatge);
        } catch (Exception e) {

        }
    }

    @Test
    public void testMain() {
    }

    /*
    @Test
    public void testGetSobrecostPerEquipatge() {
                
        Buelin b = new Buelin();
        // variants sense equipatge
        assertEquals(0,b.getSobrecostPerEquipatge(null, 0, null, false), 0.001); // cas buit
        assertEquals(0,b.getSobrecostPerEquipatge(new int[]{}, 0, null, false), 0.001); // cas buit
        assertEquals(0,b.getSobrecostPerEquipatge(new int[]{}, 0, new int[]{}, false), 0.001); // cas buit
        assertEquals(0,b.getSobrecostPerEquipatge(new int[]{}, 0, new int[]{}, true), 0.001); // cas buit

        // variants de l'equipatge de mà
        assertEquals(0,b.getSobrecostPerEquipatge(new int[]{30,30,30}, 20, null, false), 0.001); 
        assertEquals(60,b.getSobrecostPerEquipatge(new int[]{31,30,30}, 25, null, false), 0.001); 
        assertEquals(60,b.getSobrecostPerEquipatge(new int[]{30,31,30}, 25, null, false), 0.001); 
        assertEquals(60,b.getSobrecostPerEquipatge(new int[]{30,30,31}, 25, null, false), 0.001); 
        assertEquals(20,b.getSobrecostPerEquipatge(new int[]{30,30,30}, 21, null, false), 0.001); 
        // variants amb maletes
        // 1 maleta
        assertEquals(0,b.getSobrecostPerEquipatge(null, 0, new int[]{20}, false), 0.001); // cas buit
        assertEquals(20,b.getSobrecostPerEquipatge(null, 0, new int[]{21}, false), 0.001); // cas buit
        // dos maletes
        assertEquals(0,b.getSobrecostPerEquipatge(null, 0, new int[]{20,20}, false), 0.001); // cas buit
        assertEquals(20,b.getSobrecostPerEquipatge(null, 0, new int[]{21,20}, false), 0.001);
        assertEquals(20,b.getSobrecostPerEquipatge(null, 0, new int[]{20,21}, false), 0.001);
        assertEquals(40,b.getSobrecostPerEquipatge(null, 0, new int[]{21,21}, false), 0.001);
        // tres maletes
        assertEquals(200,b.getSobrecostPerEquipatge(null, 0, new int[]{20,20, 20}, false), 0.001); // cas buit
        assertEquals(250,b.getSobrecostPerEquipatge(null, 0, new int[]{21,21, 21}, false), 0.001); // cas buit
        
        // combinacions d'equipatge de mà i maletes
        assertEquals(310,b.getSobrecostPerEquipatge(new int[]{31,30,30}, 25, new int[]{21,21, 21}, false), 0.001); // cas buit
        assertEquals(312,b.getSobrecostPerEquipatge(new int[]{31,30,30}, 25, new int[]{21,21, 21}, true), 0.001); // cas buit
        
    }
    
    
        @Test
    public void testGetSobrecostPerEquipatgeForesDeRang() {
                
        Buelin b = new Buelin();
        
        getSobrecostPerEquipatgeExcepcio(new int[]{0,30,30}, 20, null, false);
        getSobrecostPerEquipatgeExcepcio(new int[]{-1,30,30}, 20, null, false);
        getSobrecostPerEquipatgeExcepcio(new int[]{30,0,30}, 20, null, false);
        getSobrecostPerEquipatgeExcepcio(new int[]{30,-1,30}, 20, null, false);
        getSobrecostPerEquipatgeExcepcio(new int[]{30,30,0}, 20, null, false);
        getSobrecostPerEquipatgeExcepcio(new int[]{30,30,-1}, 20, null, false);
        getSobrecostPerEquipatgeExcepcio(new int[]{30,30,30,30}, 20, null, false);
        getSobrecostPerEquipatgeExcepcio(new int[]{30,30}, 20, null, false);        
        getSobrecostPerEquipatgeExcepcio(new int[]{20}, 20, null, false);
        getSobrecostPerEquipatgeExcepcio(new int[]{}, 20, null, false);
        
        getSobrecostPerEquipatgeExcepcio(null, 0, new int[]{0}, false);
        getSobrecostPerEquipatgeExcepcio(null, 0, new int[]{-1}, false);
        getSobrecostPerEquipatgeExcepcio(null, 0, new int[]{20,0}, false);
        getSobrecostPerEquipatgeExcepcio(null, 0, new int[]{20,-1}, false);        
        getSobrecostPerEquipatgeExcepcio(null, 0, new int[]{20,20,0}, false);
        getSobrecostPerEquipatgeExcepcio(null, 0, new int[]{20,20,-1}, false);          
        
    }
    
    
    private void getSobrecostPerEquipatgeExcepcio( 
                               int midaEquipatgeMaCm[],  
                              int pesEquipatgeMa, 
                              int pesMaletes[], 
                              boolean pagaAmbTarja){
        Buelin b = new Buelin();
        try{
            b.getSobrecostPerEquipatge(midaEquipatgeMaCm,pesEquipatgeMa,pesMaletes,pagaAmbTarja);
            String missatge ="";
            missatge+= "midaEquipatgeMaCm:"+midaEquipatgeMaCm + "\n";
            missatge+= "pesEquipatgeMa:"+pesEquipatgeMa + "\n";
            missatge+= "pesMaletes:"+pesMaletes + "\n";
            missatge+= "pagaAmbTarja:"+pagaAmbTarja + "\n";
            fail("error: els paràmetres erronis haurien de donar excepció:\n"+missatge);
        }catch(Exception ex) {
            
        }
    }    
        
        

    @Test
    public void testMain() {
    }
     */
}
