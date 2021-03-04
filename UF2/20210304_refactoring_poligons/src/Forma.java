/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Professor
 */
public class Forma {

    public static final int QUADRAT = 1;
    public static final int CERCLE = 2;
    public static final int TRIANGLE_RECTANGLE_ISOSCELES = 3;
    public static final int TOTAL_TIPUS_FORMES=3;
    
    
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

}