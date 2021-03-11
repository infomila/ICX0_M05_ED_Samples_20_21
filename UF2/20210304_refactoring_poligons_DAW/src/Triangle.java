
/**
 *
 * @author Usuari
 */
public class Triangle extends Forma{

    public Triangle(double mida){
        super( Forma.TRIANGLE_RECTANGLE_ISOSCELES, mida);
    }
    
    @Override
    public double getArea() {
        return getCostat_2() / 2.0;
    }

    @Override
    public String getNom() {
        return "Triangle";
    }
    
}
