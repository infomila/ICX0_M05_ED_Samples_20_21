
package comunicacions;

/**
 * Demostració del patro Fabrica ( Factory pattern )
 *  i del patró Singleton.
 * @author Usuari
 */
public class MissatgerFactory {

    private static boolean _modeTest=false;
    
    private static Missatger _singleton;
    
    public static IMissatger getInstance(){
        if(_modeTest == true) {
            return new MissatgerFake();
        } else {
            // Mode real
            //--------------------
            if(_singleton==null) {
                _singleton =  new Missatger();
            }
            return _singleton;
        }
    }

    public static void setTestMode(boolean mode) {
        _modeTest = mode;
    }
    
}
