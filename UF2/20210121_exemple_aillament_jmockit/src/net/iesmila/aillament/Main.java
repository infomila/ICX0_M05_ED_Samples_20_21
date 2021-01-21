
package net.iesmila.aillament;

/**
 *
 * @author BERNAT
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona p = new Persona("Paco", "Pil", "1111111H", "pordios@nolohagas.com");
        
        p.enviarEmail("Hola!", "Això és un missatge");
    }
    
}
