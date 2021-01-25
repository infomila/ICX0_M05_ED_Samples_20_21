
package examen.aillament;

/**
 *
 * @author Usuari
 */
public class ProductCatalogDB_Fake implements IProductCatalogDB{

    @Override
    public double getCustomerDiscount(int customerId) {
        if(customerId==4) {
            return 0.0;
        } else if(customerId==10){return 10.0;}
        else {
            throw new RuntimeException("Id no suportat per la classe fake:"+customerId);
        }
    }

    @Override
    public ProductInfo getProductInfo(int id) {
        /*
                "| {534}     | Paletilla Iberica 'El Gaznate'	| 41,20€/u   x 1u. = 41,20€\n"+
                "| {23}      | Producte descatalogat\n"+        
                "| {123}     | Jamón Iberico 'JJJJJ'         	| 89,45€/u   x 1u. = 89,45€\n"+
                "| {312}     | Olives farcides d'anxova      	| 2,34€/u    x 1u. = 2,34€\n"+                
        */        
        switch(id) {
            case 534:   return new ProductInfo(id, 41.20, "Paletilla Iberica 'El Gaznate'" );
            case 23:    return null;
            case 123:   return new ProductInfo(id, 89.45, "Jamón Iberico 'JJJJJ'" );
            case 312:   return new ProductInfo(id,2.34, "Olives farcides d'anxova" );
            default:throw new RuntimeException("Id no suportat per la classe fake:"+id);
        }
    }
    
}
