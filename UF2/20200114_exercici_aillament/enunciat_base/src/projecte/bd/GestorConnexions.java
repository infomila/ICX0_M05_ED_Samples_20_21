package projecte.bd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * Classe de la capa de base de dades que gestiona centralitzar la creació de connexions
 * 
 * @author Bernat
 *
 */
public class GestorConnexions {
    static Connection getConnexio() throws Exception
    {
	// Connexió a una base de dades Access

        String ruta =  System.getProperty("user.dir")+ "\\bin\\muni.mdb";
        //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection c = DriverManager.getConnection(
          //  "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:\\muni.mdb"
          //  "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+ruta               
                  "jdbc:ucanaccess://"+ruta
        );
        

       
        return c;    		
    }
    static void tanca(Connection con)
    {
        // tancar la connexió
        try {
            if (con != null) con.close();
        }
        catch (Exception e) {
            System.err.println("Error al tancar la connexió de dades:"+(e!=null?e.getMessage():""));
        }
    }
}
