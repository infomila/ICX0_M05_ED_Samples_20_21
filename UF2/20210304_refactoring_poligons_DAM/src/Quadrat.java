
/**
 *
 * @author Usuari
 */
public class Quadrat extends Forma{

    public Quadrat(double mida){
        super(Forma.QUADRAT, mida);
    }
    
    @Override
    public String getNom() {
        return "Quadrat";
    }

    @Override
    public double getArea() {
       return mida * mida;
    }    
}
