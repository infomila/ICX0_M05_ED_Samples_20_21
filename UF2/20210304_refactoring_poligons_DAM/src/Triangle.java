
/**
 *
 * @author Usuari
 */
public class Triangle extends Forma{

    public Triangle(double mida){
        super(Forma.TRIANGLE_RECTANGLE_ISOSCELES, mida);
    }
    
    @Override
    public String getNom() {
        return "Triangle";
    }

    @Override
    public double getArea() {
       return mida * mida / 2.0;
    }    
}
