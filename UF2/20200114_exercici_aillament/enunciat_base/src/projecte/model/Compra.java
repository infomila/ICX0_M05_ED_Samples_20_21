/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte.model;


import java.util.*;

/**
 *
 * @author bernat
 */
public class Compra {
    
    private int codi;
    private Date data;
    private List<LiniaCompra> linies;
    private double preuTotal;
    
    public Compra( int codi) throws Exception
    {
        setCodi(codi);
        data = new Date();   
        linies = new ArrayList<LiniaCompra>();   
        preuTotal=0;
    }
    
    public boolean eliminarProducte( Producte p ) throws Exception
    {
        LiniaCompra linia= buscarLiniaCompraPerProducte(p);
        if(linia!=null) {
            preuTotal-=linia.getImport();
            linies.remove(linia);
            // modifiquem l'stock
            p.variacioStock(+ linia.getQuantitat());
           
            return true;
        }
        return false;
    }
    public boolean afegirProducte( Producte p, int unitats )
    {
        // verifiquem que hi hagi producte
        if( p==null ) return false;
        
        // verifiquem que les unitats siguin positives
        if(unitats <0) return false;
        
        
        // verifiquem que hi hagi stock suficient
        if(p.getStock()<unitats) return false;
        
        try {
            LiniaCompra linia= buscarLiniaCompraPerProducte(p);
            if(linia==null) {
                linia = new LiniaCompra(p,unitats);
                linies.add(linia);
                // modifiquem l'stock
                p.variacioStock(-unitats);
            } else {
                linia.setQuantitat(linia.getQuantitat()+unitats);
            }
            
            preuTotal+=linia.getImport();
            return true;
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public LiniaCompra buscarLiniaCompraPerProducte(Producte p)
    {
        for (LiniaCompra lc:linies)
        {
            if(lc.getProducte().equals(p)) return lc;
        }
        return null;
    }
    
    public void confirmarCompra() throws Exception
    {
        // decrementar els stocks dels productes
        for(LiniaCompra lc:linies){
            lc.getProducte().desarCanvisStock();
        }
        
    }
    
    
    public int getNumeroLinies(){
        return linies.size();
    }
    public int getCodi() {
        return codi;
    }

    public final void setCodi(int codi) throws Exception {
        if(codi<0) throw new Exception("La compra no es pot crear amb un codi negatiu");
        this.codi = codi;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getPreuTotal() {
        return preuTotal;
    }

    @Override
    public String toString() {
        String s = "----------------------------------" +"\n";
        s += "Compra: " + "codi=" + codi + ", data=" + data  +"\n";
        int i=1;
        
        for(LiniaCompra l : linies)  {
            s += "\t"+i + ":" + l.toString() +"\n";
            i++;
        }
        s += "----------------------------------" +"\n";
        s += "Total=" + preuTotal  +"\n";
        s += "----------------------------------" +"\n";
        return s;
    }

}
