/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Professor
 */
public abstract class Forma {

    public static final int QUADRAT = 1;
    public static final int CERCLE = 2;
    public static final int TRIANGLE_RECTANGLE_ISOSCELES = 3;
    public static final int TOTAL_TIPUS_FORMES=3;
    
    
    private int tipusForma;
    protected double mida;

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

    public abstract String getNom();/* {
        switch (tipusForma) {
            case Forma.QUADRAT:                    
              return  "Quadrat";
            case Forma.CERCLE:
               return "Cercle";
            case Forma.TRIANGLE_RECTANGLE_ISOSCELES:
                return "Triangle";
            default: throw new RuntimeException("tipus no suportat");
        }
    }*/

    public abstract double getArea();/* {
        switch (this.tipusForma) {
            case Forma.QUADRAT:
                return mida * mida;

            case Forma.CERCLE:
                return Math.PI * mida * mida;

            case Forma.TRIANGLE_RECTANGLE_ISOSCELES:
                return mida * mida / 2.0;
                
            default: throw new RuntimeException("tipus no suportat");
        }//end switch   
    }*/
}