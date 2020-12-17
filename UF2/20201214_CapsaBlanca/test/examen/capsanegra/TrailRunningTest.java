package examen.capsanegra;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class TrailRunningTest {

    public TrailRunningTest() {

    }

    @Test
    public void testGetClassificacio() {

        // cas amb empat
        {
            TrailRunning tr = new TrailRunning();    // 1  2  3   4   5    6  7   8   9   10   11   12
            int[] minutsArribadaCorredors = new int[]{10, 20, 30, 40, 55, 60, 77, 88, 99, 100, 101, 120};
            int[] equipsCorredors = new int[]{3, 3, 3, 3, 2, 1, 1, 2, 2, 2, 1, 1};
            // 1: 13p
            // 2: 13p
            // 3: 3p
            int[] classificacioEsperada = new int[]{3, 1, 2};
            int[] classificacio = tr.getClassificacio(minutsArribadaCorredors, equipsCorredors);
            assertArrayEquals(classificacioEsperada, classificacio);
        }
        //-----------------------------------------------------------------------------------------------
        // cas sense empat
        {
            TrailRunning tr = new TrailRunning();    // 1  2  3   4   5    6  7   8   9   10   11   12
            int[] minutsArribadaCorredors = new int[]{10, 20, 30, 40, 55, 60, 77, 88, 99, 100, 101, 120};
            int[] equipsCorredors = new int[]{3, 3, 3, 3, 2, 1, 2, 1, 2, 2, 1, 1};
            int[] classificacioEsperada = new int[]{3, 2, 1};
            int[] classificacio = tr.getClassificacio(minutsArribadaCorredors, equipsCorredors);
            assertArrayEquals(classificacioEsperada, classificacio);
        }
        //-----------------------------------------------------------------------------------------------
        // cas sense empat desordenat
        {
            TrailRunning tr = new TrailRunning();    // 1  2  3   4   5    6  7   8   9   10   11   12
            int[] minutsArribadaCorredors = new int[]{40, 100, 101, 55, 60, 77, 10, 20, 30, 88, 99, 120};
            int[] equipsCorredors = new int[]{3, 2, 1, 2, 1, 2, 3, 3, 3, 1, 2, 1};
            int[] classificacioEsperada = new int[]{3, 2, 1};
            int[] classificacio = tr.getClassificacio(minutsArribadaCorredors, equipsCorredors);
            assertArrayEquals(classificacioEsperada, classificacio);
        }
    }

    @Test
    public void testGetClassificacio_error() {
        /*
        {
            TrailRunning tr = new TrailRunning();    // 1  2  3   4   5    6  7   8   9   10   11   12
            int[] minutsArribadaCorredors = new int[]{10, 20, 30, 40, 55, 60, 77, 88, 99, 100, 101, 120};
            int[] equipsCorredors =          new int[]{3,  3,  3,  3,  2,  1,  1,  2, 2, 2, 1, 1};    
            int[] classificacio = tr.getClassificacio(minutsArribadaCorredors, equipsCorredors);
            assertNull( classificacio);
        }
         */

        // temps a null
        {
            TrailRunning tr = new TrailRunning();    // 1  2  3   4   5    6  7   8   9   10   11   12
            int[] minutsArribadaCorredors = null;
            int[] equipsCorredors = new int[]{3, 3, 3, 3, 2, 1, 1, 2, 2, 2, 1, 1};
            int[] classificacio = tr.getClassificacio(minutsArribadaCorredors, equipsCorredors);
            assertNull(classificacio);
        }
        // equips a null
        {
            TrailRunning tr = new TrailRunning();    // 1  2  3   4   5    6  7   8   9   10   11   12
            int[] minutsArribadaCorredors = new int[]{10, 20, 30, 40, 55, 60, 77, 88, 99, 100, 101, 120};
            int[] equipsCorredors = null;
            int[] classificacio = tr.getClassificacio(minutsArribadaCorredors, equipsCorredors);
            assertNull(classificacio);
        }
        // longituds de taules diferents
        {
            TrailRunning tr = new TrailRunning();    // 1  2  3   4   5    6  7   8   9   10   11   12
            int[] minutsArribadaCorredors = new int[]{10, 20, 30, 40, 55, 60, 77, 88, 99, 100, 101, 120};
            int[] equipsCorredors = new int[]{3, 3, 3, 3, 2, 1, 1, 2, 2, 2, 1};
            int[] classificacio = tr.getClassificacio(minutsArribadaCorredors, equipsCorredors);
            assertNull(classificacio);
        }
        // només un equip
        {
            TrailRunning tr = new TrailRunning();    // 1  2  3   4    
            int[] minutsArribadaCorredors = new int[]{10, 20, 30, 40};
            int[] equipsCorredors = new int[]{3, 3, 3, 3};
            int[] classificacio = tr.getClassificacio(minutsArribadaCorredors, equipsCorredors);
            assertNull(classificacio);
        }
        // dos equips (correcte), per? només 1 corredor
        {
            TrailRunning tr = new TrailRunning();    // 1  2  3   4   5    
            int[] minutsArribadaCorredors = new int[]{10, 20, 30, 40, 55};
            int[] equipsCorredors = new int[]{3, 3, 3, 3, 2};
            int[] classificacio = tr.getClassificacio(minutsArribadaCorredors, equipsCorredors);
            assertNull(classificacio);
        }
        // temps a zero 
        {
            TrailRunning tr = new TrailRunning();    // 1  2  3   4   5    6  7   8   9   10   11   12
            int[] minutsArribadaCorredors = new int[]{10, 20, 30, 0, 55, 60, 77, 88, 99, 100, 101, 120};
            int[] equipsCorredors = new int[]{3, 3, 3, 3, 2, 1, 1, 2, 2, 2, 1, 1};
            int[] classificacio = tr.getClassificacio(minutsArribadaCorredors, equipsCorredors);
            assertNull(classificacio);
        }
        // temps repetit I(és pk)
        {
            TrailRunning tr = new TrailRunning();    // 1  2  3   4   5    6  7   8   9   10   11   12
            int[] minutsArribadaCorredors = new int[]{10, 20, 10, 40, 55, 60, 77, 88, 99, 100, 101, 120};
            int[] equipsCorredors = new int[]{3, 3, 3, 3, 2, 1, 1, 2, 2, 2, 1, 1};
            int[] classificacio = tr.getClassificacio(minutsArribadaCorredors, equipsCorredors);
            assertNull(classificacio);
        }
        //--------------------------
        // codi d'equip a zero
        {
            TrailRunning tr = new TrailRunning();    // 1  2  3   4   5    6  7   8   9   10   11   12
            int[] minutsArribadaCorredors = new int[]{10, 20, 30, 40, 55, 60, 77, 88, 99, 100, 101, 120};
            int[] equipsCorredors = new int[]{3, 3, 0, 0, 2, 1, 1, 2, 2, 2, 1, 1};
            int[] classificacio = tr.getClassificacio(minutsArribadaCorredors, equipsCorredors);
            assertNull(classificacio);
        }
        // codi d'equip negatiu
        {
            TrailRunning tr = new TrailRunning();    // 1  2  3   4   5    6  7   8   9   10   11   12
            int[] minutsArribadaCorredors = new int[]{10, 20, 30, 40, 55, 60, 77, 88, 99, 100, 101, 120};
            int[] equipsCorredors = new int[]{3, 3, -1, 0, 2, 1, 1, 2, 2, 2, 1, 1};
            int[] classificacio = tr.getClassificacio(minutsArribadaCorredors, equipsCorredors);
            assertNull(classificacio);
        }
    }

}
