package projecte.bd;

import java.util.HashMap;
import projecte.model.Producte;

/**
 *
 * @author Usuari
 */
public class ProducteBD_Fake implements IProducteBD {

    HashMap<Integer, Producte> productesBD;

    public ProducteBD_Fake() {
        productesBD = new HashMap<>();
        Producte p1 = new Producte(1, "Col", 5, 23.12);
        Producte p3 = new Producte(3, "Tomàquet", 19, 54.30);
        productesBD.put(p1.getId(), p1);
        productesBD.put(p3.getId(), p3);
    }

    @Override
    public void getProducteFromBD(int id, Producte p) throws Exception {
        System.out.println("getProducteFromBD FAKE");

        Producte pBD = productesBD.get(id);
        if (pBD != null) {
            p.setNom(pBD.getNom());
            p.setStock(pBD.getStock());
            p.setPreu(pBD.getPreu());
        } else {
            throw new RuntimeException("id no suportat:" + id);
        }

        /*if(id==1){
             p.setNom("Col");
             p.setStock(5);
             p.setPreu(23.12);
         } else if(id==3) {
             p.setNom("Tomàquet");
             p.setStock(19);
             p.setPreu(54.30);
         } else {
             throw new RuntimeException("id no suportat:"+id);
         }*/
    }

    @Override
    public void updateStock(Producte p) throws Exception {
        System.out.println("updateStock FAKE");
        Producte pBD = productesBD.get(p.getId());
        if (pBD != null) {
            pBD.setStock(p.getStock());
        } else {
            throw new RuntimeException("id no suportat:" + p.getId());
        }
    }

}
