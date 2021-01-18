package projecte.bd;

/**
 *
 * @author Usuari
 */
public class ProducteBD_Factory {
    
    private static boolean modeTest = false;
    public static void setModeTest(boolean mode){
        modeTest = mode;
    }
    //-----------------------------------------------------
    public static IProducteBD getInstance(){
        if(modeTest) {
            return new ProducteBD_Fake();
        } else {
            return new ProducteBD();
        }
    }
    
}
