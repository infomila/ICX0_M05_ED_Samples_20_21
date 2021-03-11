
/**
 *
 * @author Usuari
 */
public class Cercle  extends Forma{

    public Cercle(double mida){
        super( Forma.CERCLE, mida);
    }
    
    @Override
    public double getArea() {
        return Math.PI * getCostat_2();
    }

    @Override
    public String getNom() {
        return "Cercle";
    }
    
}