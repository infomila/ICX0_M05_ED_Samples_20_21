
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Professor
 */
public class ColeccioFormes {

    private Vector<Forma> formes;

    public ColeccioFormes() {
        formes = new Vector<Forma>();
    }

    public void addForma(Forma f) {
        formes.add(f);
    }

    public static void main(String args[]) {
        ColeccioFormes c = new ColeccioFormes();
        c.addForma(new Forma(Forma.TRIANGLE_RECTANGLE_ISOSCELES, 2));
        c.addForma(new Forma(Forma.CERCLE, 2));
        c.addForma(new Forma(Forma.CERCLE, 3));
        c.addForma(new Forma(Forma.QUADRAT, 3));
        c.addForma(new Forma(Forma.TRIANGLE_RECTANGLE_ISOSCELES, 4));
        c.addForma(new Forma(Forma.QUADRAT, 3));
        c.addForma(new Forma(Forma.QUADRAT, 1));

        System.out.println(c.informeFormes());
    }

    public String informeFormes() {
        int quadrats = 0, cercles = 0, triangles = 0, total = 0;
        double areaQuadrats = 0, areaCercles = 0, areaTriangles = 0;
        double areaAcumulada = 0, midaCostat;
        double costatAcumulatQuadrats=0, costatAcumulatCercles=0, costatAcumulatTriangles=0;
        
        int tipus, numFig = 1;
        String informe = "";
        NumberFormat nf = DecimalFormat.getNumberInstance(new Locale("ca", "es"));
        nf.setMaximumFractionDigits(2);
        informe += "========================\n";
        for (Forma f : formes) {
            
            tipus = f.getTipusForma();
            total++;
            numFig++;
            informe += "- Figura <" + numFig + ">: ";
            switch (tipus) {

                case Forma.QUADRAT:
                    midaCostat = f.getMidaCostat();
                    costatAcumulatQuadrats += midaCostat;
                    informe += "Quadrat";
                    informe += "\t costat - "+midaCostat+" - area " + nf.format(midaCostat * midaCostat) + "\n";
                    areaAcumulada += midaCostat * midaCostat;
                    areaQuadrats += midaCostat * midaCostat;
                    quadrats++;
                    break;
                case Forma.CERCLE:
                    midaCostat = f.getMidaCostat();
                    informe += "Cercle";
                    informe += "\t costat - "+midaCostat+" - area " + nf.format(Math.PI * midaCostat * midaCostat) + "\n";
                    
                    costatAcumulatCercles += midaCostat;
                    
                    areaAcumulada += Math.PI * midaCostat * midaCostat;
                    areaCercles += Math.PI * midaCostat * midaCostat;
                    cercles++;
                    break;
                case Forma.TRIANGLE_RECTANGLE_ISOSCELES:
                    midaCostat = f.getMidaCostat();
                    informe += "Triangle";
                    informe += "\t costat - "+midaCostat+" - area " + nf.format(midaCostat * midaCostat / 2.0) + "\n";
                    areaAcumulada += midaCostat * midaCostat / 2.0;
                    areaTriangles += midaCostat * midaCostat / 2.0;
                    triangles++;
                    
                    costatAcumulatTriangles += midaCostat;
                    break;
            }
        } // end foreach forma
        // ---------------------- totalitzacions --------------------------
        informe += "========================\n";
        informe += "Total figures:" + total + ", area total:" + nf.format(areaAcumulada) + "\n";
        informe += "========================\n";
        for (int n = 1; n <= Forma.TOTAL_TIPUS_FORMES; n++) {
            switch (n) {

                case Forma.QUADRAT:
                    informe += "Total Quadrats:" + quadrats + ", area final:" + nf.format(areaQuadrats) +  ", costat mig:" + nf.format(costatAcumulatQuadrats/(float)quadrats) +"\n";
                    break;
                case Forma.CERCLE:
                    informe += "Total Cercles:" + cercles + ", area final:" + nf.format(areaCercles) +  ", costat mig:" + nf.format(costatAcumulatCercles/(float)cercles) +"\n";
                    break;
                case Forma.TRIANGLE_RECTANGLE_ISOSCELES:
                    informe += "Total triangles:" + triangles + ", area final:" + nf.format(areaTriangles) +  ", costat mig:" + nf.format(costatAcumulatTriangles/(float)triangles) +"\n";
                    break;
            }
            informe += "========================\n";
        }//end for       
        return informe;
    }
}