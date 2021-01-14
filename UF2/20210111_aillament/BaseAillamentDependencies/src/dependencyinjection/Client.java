/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencyinjection;


import comunicacions.IMissatger;
import comunicacions.Missatger;
import comunicacions.MissatgerFactory;

public class Client {

    String nom;
    String adresaEmail;
    int codi;
    double descompte;

    public Client(int codi, String nom, String adresaEmail) {
        this.nom = nom;
        this.adresaEmail = adresaEmail;
        this.codi = codi;
        this.descompte = 0;
    }

    public double getDescompte() {
        return descompte;
    }
    
    // Solució amb Injecció de dependències
    /*public void canviarOferta(double descompte, IMissatger m) throws Exception {
        this.descompte = descompte;
      //  Missatger m = new Missatger();
        m.enviarEmail(adresaEmail, "Canvi de tarifa", "La seva nova tarifa de descompte és de :" + descompte + "%");
    } */
    
    // Solució amb fàbrica
    public void canviarOferta(double descompte) throws Exception {
        this.descompte = descompte;
        IMissatger m = MissatgerFactory.getInstance();
        m.enviarEmail(adresaEmail, "Canvi de tarifa", "La seva nova tarifa de descompte és de :" + descompte + "%");
    } 

    
}
