package projecte.bd;

import projecte.model.Producte;

/**
 *
 * @author Usuari
 */
public interface IProducteBD {

    public void getProducteFromBD(int id, Producte p) throws Exception;

    public void updateStock(Producte p) throws Exception;

}
