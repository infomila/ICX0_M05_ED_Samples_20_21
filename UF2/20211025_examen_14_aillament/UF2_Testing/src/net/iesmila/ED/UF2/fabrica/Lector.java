package net.iesmila.ED.UF2.fabrica;


import java.util.StringTokenizer;


public class Lector {
    
    public String extreuParaulesAmbDefinicio ( String text ) {
        
        String informe = "";
        
        DiccionariOnline dic = new DiccionariOnline();
        String paraula="";
        // partir la frase en paraules
        StringTokenizer tokenizer = new StringTokenizer(text, " ");
        String coma = "";
        // per cada paraula de la frase
        while(tokenizer.hasMoreTokens()){
            paraula = tokenizer.nextToken();
            // esbrinem el tipus de paraula
            TipusParaula tipus = dic.getTipusParaula(paraula);
            if( tipus==TipusParaula.ADJECTIU ||
                tipus==TipusParaula.NOM) {
                // si és nom o adjectiu, la inclourem a l'informe.
                informe = informe + coma + paraula +": "+dic.getDescripcio(paraula);
                coma = ",";
            }
            
        }
        return informe;
    }
    
}
