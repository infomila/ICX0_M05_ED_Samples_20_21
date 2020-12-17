
package examen.capsablanca;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class HeartOfStoneTest {
    
    public HeartOfStoneTest() {
    }

    @Test
    public void testHeartBreaker() {
        HeartOfStone hos = new HeartOfStone();
        hos.heartBreaker("kkkkkk kk");
        hos.heartBreaker("HEART");
        hos.heartBreaker("primera segona tercera");
        hos.heartBreaker("primera segona tercera quarta");
        hos.heartBreaker("PRIMeres SEGona TERCERA QUARTA");//HEART
        hos.heartBreaker("PRIMERA segona tercera quarta"); // sortim per sota
        hos.heartBreaker("PRIMeres segona tercera PRIMeres"); // sortim per sobre
        hos.heartBreaker("PRIMeres PRIMeres QUARTA QUARTA PRIMeres");//HEART // passem per tot arreu per? no arribem a HEART
     
    }
    
}
