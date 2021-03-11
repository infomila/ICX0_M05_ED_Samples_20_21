
/**
 *
 * @author Usuari
 */
public class Cercle extends Forma{

    public Cercle(double mida){
        super(Forma.CERCLE, mida);
    }
    
    @Override
    public String getNom() {
        return "Cercle";
    }

    @Override
    public double getArea() {
       return mida * mida * Math.PI;
    }    
}
