
package pkg20210412_demodambasic.munis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Usuari
 */
public class Provincia {
    private long id;
    private String nom;
    private Municipi capital;
    private List<Municipi> municipis;

    public Provincia(long id, String nom) {
        this.id = id;
        this.nom = nom;
        municipis = new ArrayList<>();
    }
    //-----------------------------------
    // relació Provincia--té_capital--> Municipi
    public Municipi getCapital() {
        return capital;
    }

    public void setCapital(Municipi capital) {
        if(capital.getProvincia().equals(this)){
            this.capital = capital;
        } else {
            throw new RuntimeException("No podem fer capital un muncipi d'una altra província.");
        }
    }
    
    //-----------------------------------
    // relació Provincia--té_municipis--> Municipi
    /*public boolean addMunicipi(Municipi nou) 
    {
        
        if(!this.municipis.contains(nou)){
            this.municipis.add(nou);                        
            nou.setProvincia(this);            
            return true;
            
        } else {
            return false;
        }
    }*/
    
    public boolean contains(Municipi nou) {
        return this.municipis.contains(nou);
    }
    
    public boolean addMunicipi(Municipi nou) 
    {        
        
        if(!this.municipis.contains(nou)){
            
            this.municipis.add(nou);              
            
            // esborrar directament el lligam amb l'antiga província
            if(nou.getProvincia()!=null && nou.getProvincia()!=this) {
                nou.getProvincia().removeMunicipi(nou);
            }
            // demanar al municipi que ara ens posi com la seva nova 
            // província
            nou.setProvincia(this);            
            return true;
            
        } else {
             throw new RuntimeException("No podem afegir dos vegades el mateix municipi a una província");
        }
    }
    
    
    void removeMunicipi(int index){
        this.municipis.remove(index);
    }
    
    boolean removeMunicipi(Municipi m){
        return this.municipis.remove(m);
    }    
    
    public int getNumMunicipis(){
        return this.municipis.size();
    }
    
    public Municipi getMunicipi(int index){
        return this.municipis.get(index);
    }
    
    public Iterator<Municipi> getMunicipisIterator(){
        return this.municipis.iterator();
    }
    
    
    //-----------------------------------
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Provincia other = (Provincia) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
