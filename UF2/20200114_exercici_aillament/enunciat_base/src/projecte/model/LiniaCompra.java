/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte.model;

import projecte.model.Producte;

/**
 *
 * @author bernat
 */
public class LiniaCompra {

    Producte p;
    int quantitat;
    
    public LiniaCompra(Producte p, int quantitat) throws Exception{
        setProducte( p);
        setQuantitat(quantitat);
    }

    public Producte getProducte() {
        return p;
    }

    public final  void setProducte(Producte p) throws Exception {
        if(p==null) {
            throw new Exception("Error a la creació de la compra, producte obligatori");
        }
        this.p = p;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public final void setQuantitat(int quantitat) throws Exception {
        if( quantitat <=0 ) {
            throw new Exception("Error a la creació de la compra, quantitat negativa o zero!");
        }

        this.quantitat = quantitat;
    }
    public final double getImport()
    {
        return p.getPreu()*quantitat;
    }
    
    @Override
    public String toString() {
        return p.getNom() + ", quantitat=" + quantitat + '}';
    }
}
