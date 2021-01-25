package examen.aillament;

/**
 *
 * @author Usuari
 */
public class ProductCatalogDB_Factory {
    private static boolean _modeTest = false;
    public static void setMode(boolean mode) {
        _modeTest = mode;
    }
    //--------------------------------------------
    public  static IProductCatalogDB getInstance(){
        if(_modeTest) {
            return new ProductCatalogDB_Fake();
        } else {
            return new ProductCatalogDB();
        }
    }
}
