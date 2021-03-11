
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

    private class RecomptePerFigura {
        double areaAcumulada=0;
        double costatsAcumulats=0;
        int numeroFigures=0;
        
        public void incrementa(double area,double costat){
            areaAcumulada += area;
            costatsAcumulats +=costat;
            numeroFigures++;
        }
    }
    
    public String informeFormes() {
        //int quadrats = 0, cercles = 0, triangles = 0
        int total = 0;
        //double areaQuadrats = 0, areaCercles = 0, areaTriangles = 0;
        double areaAcumulada = 0;
        double midaCostat;
        //double costatAcumulatQuadrats=0, costatAcumulatCercles=0, costatAcumulatTriangles=0;
        
        int tipus, numFig = 1;
        String informe = "";
        NumberFormat nf = DecimalFormat.getNumberInstance(new Locale("ca", "es"));
        nf.setMaximumFractionDigits(2);
        informe += "========================\n";
        
        HashMap<Integer,RecomptePerFigura> mapaAreesAcumulades = new HashMap<>() ;
        
        for (Forma forma : formes) {            
            tipus = forma.getTipusForma();
            total++;
            numFig++;
            informe += "- Figura <" + numFig + ">: ";
            midaCostat = forma.getMidaCostat();
            double area=forma.getArea();
            informe += forma.getNom();
            
            RecomptePerFigura rec = mapaAreesAcumulades.get(tipus);
            if(rec==null) {rec = new RecomptePerFigura();mapaAreesAcumulades.put(tipus, rec);}
            rec.incrementa(area, midaCostat);
            
            
            areaAcumulada += area;
            informe += "\t costat - "+midaCostat+" - area " + nf.format(area) + "\n";
            
            
        } // end foreach forma
        // ---------------------- totalitzacions --------------------------
        informe += "========================\n";
        informe += "Total figures:" + total + ", area total:" + nf.format(areaAcumulada) + "\n";
        informe += "========================\n";
        for (int n = 1; n <= Forma.TOTAL_TIPUS_FORMES; n++) {
            
            RecomptePerFigura rec = mapaAreesAcumulades.get(n);
            
            switch (n) {

                case Forma.QUADRAT:
                    informe += "Total Quadrats:" + rec.numeroFigures + ", area final:" + nf.format(rec.areaAcumulada) +  ", costat mig:" + nf.format(rec.costatsAcumulats/(float)rec.numeroFigures) +"\n";
                    break;
                case Forma.CERCLE:
                    informe += "Total Cercles:" + rec.numeroFigures + ", area final:" + nf.format(rec.areaAcumulada) +  ", costat mig:" + nf.format(rec.costatsAcumulats/(float)rec.numeroFigures) +"\n";
                    break;
                case Forma.TRIANGLE_RECTANGLE_ISOSCELES:
                    informe += "Total triangles:" + rec.numeroFigures + ", area final:" + nf.format(rec.areaAcumulada) +  ", costat mig:" + nf.format(rec.costatsAcumulats/(float)rec.numeroFigures) +"\n";
                    break;
            }
            informe += "========================\n";
        }//end for       
        return informe;
    }
}