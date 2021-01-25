
package examen.aillament;

/**
 *
 * @author Usuari
 */
public interface IProductCatalogDB {

    double getCustomerDiscount(int customerId);

    ProductInfo getProductInfo(int Id);
    
}
