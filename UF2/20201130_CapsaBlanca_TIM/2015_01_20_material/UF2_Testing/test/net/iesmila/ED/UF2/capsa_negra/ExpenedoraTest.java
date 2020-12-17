package net.iesmila.ED.UF2.capsa_negra;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class ExpenedoraTest {

    public ExpenedoraTest() {
    }

    @Test
    public void testPagarMetalic() {

        // Cas 1: import exacte
        {
            byte[] monedesClient = new byte[]{1, 1, 1};
            byte[] monedesCaixa = new byte[]{0, 0, 0};
            TipusCanvi tc = Expenedora.pagarMetalic(56, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_OK_CANVI_EXACTE, tc);
            assertArrayEquals(new byte[]{1, 1, 1}, monedesCaixa);
            assertArrayEquals(new byte[]{0, 0, 0}, monedesClient);
        }
        // Cas 2: monedes en excès
        {
            byte[] monedesClient = new byte[]{1, 1, 5};
            byte[] monedesCaixa = new byte[]{0, 0, 0};
            TipusCanvi tc = Expenedora.pagarMetalic(56, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_OK_CANVI_EXACTE, tc);
            assertArrayEquals(new byte[]{1, 1, 1}, monedesCaixa);
            assertArrayEquals(new byte[]{0, 0, 4}, monedesClient);
        }
        // Cas 3: canvi de la caixa
        {
            byte[] monedesClient = new byte[]{2, 0, 0};
            byte[] monedesCaixa = new byte[]{0, 4, 5};
            TipusCanvi tc = Expenedora.pagarMetalic(75, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_OK_CANVI_EXACTE, tc);
            assertArrayEquals(new byte[]{2, 0, 0}, monedesCaixa);
            assertArrayEquals(new byte[]{0, 4, 5}, monedesClient);
        }

        // Cas 3: canvi de la caixa
        {
            byte[] monedesClient = new byte[]{2, 0, 2};
            byte[] monedesCaixa = new byte[]{0, 4, 5};
            TipusCanvi tc = Expenedora.pagarMetalic(75, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_OK_CANVI_EXACTE, tc);
            assertArrayEquals(new byte[]{2, 0, 0}, monedesCaixa);
            assertArrayEquals(new byte[]{0, 4, 7}, monedesClient);
        }
        //-------------------------------------------------------
        // Cas 4: sense canvi
        {
            byte[] monedesClient = new byte[]{2, 0, 0};
            byte[] monedesCaixa = new byte[]{4, 0, 0};
            TipusCanvi tc = Expenedora.pagarMetalic(75, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_OK_CANVI_EXACTE, tc);
            assertArrayEquals(new byte[]{6, 0, 0}, monedesCaixa);
            assertArrayEquals(new byte[]{0, 0, 0}, monedesClient);
        }
        // Cas 5: sense canvi
        {
            byte[] monedesClient = new byte[]{2, 0, 0};
            byte[] monedesCaixa = new byte[]{4, 1, 4};
            TipusCanvi tc = Expenedora.pagarMetalic(75, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_OK_CANVI_EXACTE, tc);
            assertArrayEquals(new byte[]{6, 0, 0}, monedesCaixa);
            assertArrayEquals(new byte[]{0, 1, 4}, monedesClient);
        }        
        //-------------------------------------------------------
        // Cas 6: import insuficient
        {
            byte[] monedesClient = new byte[]{1, 0, 0};
            byte[] monedesCaixa = new byte[]{4, 0, 0};
            TipusCanvi tc = Expenedora.pagarMetalic(51, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_FAIL_IMPORT_INSUFICIENT, tc);
            assertArrayEquals(new byte[]{4, 0, 0}, monedesCaixa);
            assertArrayEquals(new byte[]{1, 0, 0}, monedesClient);
        }
        //-------------------------------------------------------
        // Cas 7: import insuficient (zero)
        {
            byte[] monedesClient = new byte[]{0, 0, 0};
            byte[] monedesCaixa = new byte[]{4, 0, 0};
            TipusCanvi tc = Expenedora.pagarMetalic(51, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_FAIL_IMPORT_INSUFICIENT, tc);
            assertArrayEquals(new byte[]{4, 0, 0}, monedesCaixa);
            assertArrayEquals(new byte[]{0, 0, 0}, monedesClient);
        }      
        //-------------------------------------------------------
        // Cas 7: import 0
        {
            byte[] monedesClient = new byte[]{1, 1, 1};
            byte[] monedesCaixa = new byte[]{4, 0, 0};
            TipusCanvi tc = Expenedora.pagarMetalic(0, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_FAIL_ERROR_DADES, tc);
            assertArrayEquals(new byte[]{4, 0, 0}, monedesCaixa);
            assertArrayEquals(new byte[]{1, 1, 1}, monedesClient);
        } 
        // Cas 7: import negatiu
        {
            byte[] monedesClient = new byte[]{1, 1, 1};
            byte[] monedesCaixa = new byte[]{4, 0, 0};
            TipusCanvi tc = Expenedora.pagarMetalic(-51, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_FAIL_ERROR_DADES, tc);
            assertArrayEquals(new byte[]{4, 0, 0}, monedesCaixa);
            assertArrayEquals(new byte[]{1, 1, 1}, monedesClient);
        }  
        // Cas 8: nulls
        {
            byte[] monedesClient = null;
            byte[] monedesCaixa = new byte[]{4, 0, 0};
            TipusCanvi tc = Expenedora.pagarMetalic(-51, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_FAIL_ERROR_DADES, tc);
            assertArrayEquals(new byte[]{4, 0, 0}, monedesCaixa);
            assertArrayEquals(new byte[]{1, 1, 1}, monedesClient);
        }  
        // Cas 7: null
        {
            byte[] monedesClient = new byte[]{1, 1, 1};
            byte[] monedesCaixa = null;
            TipusCanvi tc = Expenedora.pagarMetalic(-51, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_FAIL_ERROR_DADES, tc);
            assertArrayEquals(new byte[]{4, 0, 0}, monedesCaixa);
            assertArrayEquals(new byte[]{1, 1, 1}, monedesClient);
        }   
        // Cas 8: long != 3
        {
            byte[] monedesClient = new byte[]{1, 1, 1, 1};
            byte[] monedesCaixa = new byte[]{4, 0, 0};
            TipusCanvi tc = Expenedora.pagarMetalic(-51, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_FAIL_ERROR_DADES, tc);
            assertArrayEquals(new byte[]{4, 0, 0}, monedesCaixa);
            assertArrayEquals(new byte[]{1, 1, 1}, monedesClient);
        }  
        // Cas 8: long != 3
        {
            byte[] monedesClient = new byte[]{1, 1, 1};
            byte[] monedesCaixa = new byte[]{4, 0, 0, 1};
            TipusCanvi tc = Expenedora.pagarMetalic(-51, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_FAIL_ERROR_DADES, tc);
            assertArrayEquals(new byte[]{4, 0, 0}, monedesCaixa);
            assertArrayEquals(new byte[]{1, 1, 1}, monedesClient);
        }  
        // Cas 8: negatius
        {
            byte[] monedesClient = new byte[]{1, 1, -1};
            byte[] monedesCaixa = new byte[]{4, 0, 0};
            TipusCanvi tc = Expenedora.pagarMetalic(-51, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_FAIL_ERROR_DADES, tc);
            assertArrayEquals(new byte[]{4, 0, 0}, monedesCaixa);
            assertArrayEquals(new byte[]{1, 1, 1}, monedesClient);
        }  
        // Cas 8: negatius

        {
            byte[] monedesClient = new byte[]{1, 1, 1};
            byte[] monedesCaixa = new byte[]{4, 0, -2};
            TipusCanvi tc = Expenedora.pagarMetalic(-51, monedesClient, monedesCaixa);
            assertEquals(TipusCanvi.VENDA_FAIL_ERROR_DADES, tc);
            assertArrayEquals(new byte[]{4, 0, 0}, monedesCaixa);
            assertArrayEquals(new byte[]{1, 1, 1}, monedesClient);
        }  
         
    }

}
