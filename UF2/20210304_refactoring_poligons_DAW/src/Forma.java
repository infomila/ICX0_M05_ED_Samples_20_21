/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Professor
 */
public abstract class  Forma {

    public static final int QUADRAT = 1;
    public static final int CERCLE = 2;
    public static final int TRIANGLE_RECTANGLE_ISOSCELES = 3;
    public static final int TOTAL_TIPUS_FORMES = 3;

    private int tipusForma;
    private double mida;

    public Forma(int _tipusForma, double _mida) {
        this.tipusForma = _tipusForma;
        this.mida = _mida;
    }

    public double getMidaCostat() {
        return mida;
    }

    public int getTipusForma() {
        return tipusForma;
    }

    public double getCostat_2() {
        return mida * mida;
    }

    public abstract double getArea();/* {
        double area = 0;
        switch (tipusForma) {

            case Forma.QUADRAT:
                area = getCostat_2();
                break;
            case Forma.CERCLE:
                area = Math.PI * getCostat_2();
                break;
            case Forma.TRIANGLE_RECTANGLE_ISOSCELES:
                area = getCostat_2() / 2.0;
                break;
            default:
                throw new RuntimeException("Tipus de forma no suportat");
        }
        return area;
    }*/
    
    public abstract String getNom();/*{
        switch (tipusForma) {
            case Forma.QUADRAT:
                return "Quadrat";
            case Forma.CERCLE:
                return "Cercle";
            case Forma.TRIANGLE_RECTANGLE_ISOSCELES:
                return "Triangle";
            default:
                throw new RuntimeException("Tipus de forma no suportat");
        }
    }*/

}
