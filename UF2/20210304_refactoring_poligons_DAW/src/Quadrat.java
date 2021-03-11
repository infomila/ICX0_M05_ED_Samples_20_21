/**
 *
 * @author Usuari
 */
public class Quadrat  extends Forma{

    public Quadrat(double mida){
        super( Forma.QUADRAT, mida);
    }
    
    @Override
    public double getArea() {
        return getCostat_2();
    }

    @Override
    public String getNom() {
        return "Quadrat";
    }
    
}
