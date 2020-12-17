package aplicaciotarifes;

/**
 *
 * @author Usuari
 */
public class AplicacioTarifes {

    double[] preusBase = {60,50,40,30};
    
    public double getPreu(int tipusCadira, int edat) {
         // Assercions
         if(tipusCadira<1 || tipusCadira>4 ) throw new RuntimeException("Tipus de cadira erroni");
         if(edat<1 || edat>=120) throw new RuntimeException("Edat errònia");
         
         //--------------------------------------------------------------------
         double preu = preusBase[tipusCadira-1];
         if(edat<4) {
             return 0;
         } else if(edat<12) {
             return preu * 0.75;
         } else if(edat<60) {
             return preu;
         } else {
             // jubilats
             if(tipusCadira==1) return preu*0.5;
             else return preu*0.2;
         }
         
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
    }
    
}
