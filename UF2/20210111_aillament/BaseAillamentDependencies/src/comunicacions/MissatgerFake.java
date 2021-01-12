
package comunicacions;

/**
 *
 * @author Usuari
 */
public class MissatgerFake implements IMissatger{

    @Override
    public void enviarEmail(String arg0, String arg1, String arg2) throws Exception {
        System.out.println(">Enviant email FALSSSSSSS");
    }
    
}
