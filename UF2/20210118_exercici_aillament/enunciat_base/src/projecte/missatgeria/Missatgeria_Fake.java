 
package projecte.missatgeria;

/**
 *
 * @author Usuari
 */
public class Missatgeria_Fake implements IMissatgeria{

    @Override
    public void enviar(String departament, String missatge) throws Exception {
        System.out.println("Enviament FAKE");
    }
    
}
