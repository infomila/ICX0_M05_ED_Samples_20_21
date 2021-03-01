package projecte.missatgeria;

import projecte.bd.*;

/**
 *
 * @author Usuari
 */
public class Missatgeria_Factory {
    
    private static boolean modeTest = false;
    public static void setModeTest(boolean mode){
        modeTest = mode;
    }
    //-----------------------------------------------------
    public static IMissatgeria getInstance(){
        if(modeTest) {
            return new Missatgeria_Fake();
        } else {
            return new Missatgeria();
        }
    }
    
}
