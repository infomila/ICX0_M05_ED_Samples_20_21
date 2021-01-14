/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte.bd;

import projecte.model.Producte;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author bernat
 */
public class ProducteBD {
    
    public  void getProducteFromBD(int id, Producte p) throws Exception{

        Connection con=null;
        try {
                con= GestorConnexions.getConnexio();
                ResultSet rs;
                Statement stmt;
                String sql =  "select * from productes where id =" + id;

                stmt = con.createStatement();
                rs = stmt.executeQuery(sql); // Llançar la consulta

                // Recorrem el resultat de la consulta
                if(rs.next()) {
                    
                    p.setNom((rs.getString("nom")));
                    p.setStock(rs.getInt("stock"));
                    p.setPreu(rs.getDouble("preu"));
                    
                } else {
                    throw new Exception();
                }
                rs.close();
                stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
                GestorConnexions.tanca(con);
        }		
    }
    public   void updateStock(Producte p)  throws Exception{
        Connection con=null;
        try {
                con= GestorConnexions.getConnexio();
                Statement stmt;
                String sql =  "update productes set stock =  " +p.getStock()+" where id="+ p.getId();

                stmt = con.createStatement();
                stmt.executeUpdate(sql); // Llançar la consulta
                stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
                GestorConnexions.tanca(con);
        }		
    }
}
