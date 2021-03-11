
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
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
        c.addForma(new Triangle(2));
        c.addForma(new Cercle(2));
        c.addForma(new Cercle(3));
        c.addForma(new Quadrat(3));
        c.addForma(new Triangle(4));
        c.addForma(new Quadrat(3));
        c.addForma(new Quadrat(1));

        System.out.println(c.informeFormes());
    }
    
    private class AcumuladorsPerTipus{
        int recompteFigures = 0;
        double areaAcumulada = 0;
        double costatsAcumulat = 0;
        
        public void afegirFigura(double costat, double area){
            recompteFigures++;
            areaAcumulada += area;
            costatsAcumulat += costat;
        }
    }

    public String informeFormes() {
        //int quadrats = 0, cercles = 0, triangles = 0;
        int total = 0;
        //double areaQuadrats = 0, areaCercles = 0, areaTriangles = 0;
        double areaAcumulada = 0, midaCostat;
        //double costatAcumulatQuadrats=0, costatAcumulatCercles=0, costatAcumulatTriangles=0;
        
        int tipus, numFig = 1;
        String informe = "";
        NumberFormat nf = DecimalFormat.getNumberInstance(new Locale("ca", "es"));
        nf.setMaximumFractionDigits(2);
        informe += "========================\n";
        
        HashMap<Integer,AcumuladorsPerTipus> recomptePerTipus = new HashMap<>();
        
        for (Forma forma : formes) {
            
            tipus = forma.getTipusForma();
            total++;
            numFig++;
            informe += "- Figura <" + numFig + ">: ";
            midaCostat = forma.getMidaCostat();            
            informe += forma.getNom();
            double area=forma.getArea();
            
            //------------------------------------------------
            AcumuladorsPerTipus acum = recomptePerTipus.get(tipus);
            if(acum==null) {
                acum = new AcumuladorsPerTipus();
                recomptePerTipus.put(tipus, acum);
            }
            acum.afegirFigura(midaCostat, area);
            
            areaAcumulada += area;
            informe += "\t costat - "+midaCostat+" - area " + nf.format(area) + "\n";
            
            
            
        } // end foreach forma
        // ---------------------- totalitzacions --------------------------
        informe += "========================\n";
        informe += "Total figures:" + total + ", area total:" + nf.format(areaAcumulada) + "\n";
        informe += "========================\n";
        for (int n = 1; n <= Forma.TOTAL_TIPUS_FORMES; n++) {
            
            AcumuladorsPerTipus acum =  recomptePerTipus.get(n);
            
          informe += "Total ";
            switch (n) {

                case Forma.QUADRAT:
                    informe += "Quadrats:" ;
                    break;
                case Forma.CERCLE:
                    informe += "Cercles:" ;
                    break;
                case Forma.TRIANGLE_RECTANGLE_ISOSCELES:
                    informe += "triangles:";
                    break;
            }
            
            informe += + acum.recompteFigures + ", area final:" + nf.format(acum.areaAcumulada) +  ", costat mig:" + nf.format(acum.costatsAcumulat/(float)acum.recompteFigures) +"\n";
            informe += "========================\n";
        }//end for       
        return informe;
    }
}