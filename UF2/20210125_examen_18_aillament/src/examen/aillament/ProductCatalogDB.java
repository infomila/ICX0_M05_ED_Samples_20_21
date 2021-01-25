
package examen.aillament;

/**
 *
 * @author bernat
 */
public class ProductCatalogDB implements IProductCatalogDB   {

    
    ProductCatalogDB(){
        
    }
    

    @Override
    public double getCustomerDiscount(int customerId) {
        throw new RuntimeException("FATAL ERROR: Database connection error.");
    }

  
    @Override
    public ProductInfo getProductInfo(int Id) {
        throw new RuntimeException("FATAL ERROR: Database connection error.");
    }
    
}
