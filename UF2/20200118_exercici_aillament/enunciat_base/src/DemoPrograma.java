
import projecte.missatgeria.Missatgeria;
import projecte.model.Compra;
import projecte.model.Producte;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BERNAT
 */
public class DemoPrograma {
    public static void main( String [] args) throws Exception {
            Compra compra = new Compra(4423);

            // ==========================================================================
            //   Exemple de l'utilització directa d'una tercera classe (Producte) 
            //   en el testing de Compra.
            // ==========================================================================

            Producte p1 = new Producte(1); // producte 1 de la base de dades  : Col, 10 unitats
         
            Producte p3 = new Producte(3); // producte 3 de la base de dades  : Col, 4 unitats      

            compra.afegirProducte(p1, 50); // estock demanat superior al disponible --> no es crea la línia
            System.out.println(compra);

            System.out.println("Estoc abans compra " + p1.getNom() +": "+ p1.getStock());
            System.out.println("Comprem -50 ?¿ del producte " + p1.getNom());
            compra.afegirProducte(p1, -50); // 
            System.out.println("Estock negatiu --> no es crea la línia");
            System.out.println(compra);

            System.out.println("Estoc abans compra " + p1.getNom() +": "+ p1.getStock());
            System.out.println("comprem 5 del producte " + p1.getNom());
            compra.afegirProducte(p1, 5); // 
            System.out.println("Estock demanat inferior al disponible --> es crea la línia");
            System.out.println("Estoc després compra " + p1.getNom() +": "+ p1.getStock());
            System.out.println(compra);
            
            
            
            System.out.println("Comprem 3 del producte " + p3.getNom());
            compra.afegirProducte(p3, 3);
            System.out.println(compra);
            
            compra.confirmarCompra();
    }
}
