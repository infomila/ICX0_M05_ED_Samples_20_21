package examen.capsablanca;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Usuari
 */
public class HeartOfStone {

    public static final String HEART = "HEART";
    
    public int heartBreaker(String passPhrase) {
        
        System.out.println("Welcome to heart of stone! Good luck !");

        
        StringTokenizer st = new StringTokenizer(passPhrase, " ");
        ArrayList<String> words = new ArrayList<String>();
        while(st.hasMoreElements()) {
            String w = st.nextToken();
            words.add(w);            
            if(w.length()<5) return -1;
            if(w.equals(HEART)) return -2;
        }
        
        if(words.size()<4) return -3;
        
        
               
        int[] jhonWasHere = new int[words.size()];
        for(int i=0;i<jhonWasHere.length;i++)   jhonWasHere[i]= 0;
        
        // Place the Heart on the line
        words.add(HEART);
        
        int n=0;
        boolean touchYourHeart = false;
        while(!touchYourHeart) {
        
            
            
            String w = words.get(n);
            if(w.equals(HEART)) {
                touchYourHeart=true;
            } else {
                
                jhonWasHere[n]++; // !!
                
                int diff=0;
                String W = w.toUpperCase();
                for(int c=0;c<w.length();c++){
                    if( w.charAt(c) == W.charAt(c)) diff++;
                    else diff--;                
                }
                if( diff == 0 ) {
                    n +=3;
                } else if( diff == w.length() ){
                    n -=1;
                } else {
                    break;
                }            
                if(n<0 || n>words.size()) {
                    break;
                }
            }
        }
        
        boolean missedABeat = false;
        for(int i=0;i<jhonWasHere.length-1;i++) {if(jhonWasHere[i]!=1) missedABeat=true;}
        
        if(!missedABeat && touchYourHeart) {
            System.out.println("You win, gentle heart!");
            return 1;
        }       
        
        return -1;
    }
    
}
