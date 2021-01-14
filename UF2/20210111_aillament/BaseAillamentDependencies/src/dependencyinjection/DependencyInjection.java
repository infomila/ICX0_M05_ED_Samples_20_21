package dependencyinjection;

import comunicacions.Missatger;
import comunicacions.MissatgerFake;

/**
 *
 * @author bernat
 */
public class DependencyInjection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        Client c = new Client(1, "Paco", "paco@gmail.com");
        // Versió amb injecció de dependències        
        //c.canviarOferta(20, new Missatger());
        c.canviarOferta(20);
    }
}
