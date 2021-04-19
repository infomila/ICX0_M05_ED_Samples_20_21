
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Usuari
 */
public class Provincia {
    private long codi;
    private String nom;
    private Municipi capital;
    private List<Municipi> municipis;

    public Provincia(long codi, String nom) {
        this.codi = codi;
        this.nom = nom;
        municipis = new ArrayList<>();
    }

    public Municipi getCapital() {
        return capital;
    }

    public void setCapital(Municipi novaCapital) {
        if(novaCapital!=null && !novaCapital.getProvincia().equals(this))
        {
            throw new RuntimeException("Nom podem assignar com a capital un municipi que és d'una altra província.");
        }
        this.capital = novaCapital;
    }
    
    public boolean contains(Municipi m) {
        return this.municipis.contains(m);
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
    public void removeMunicipi(int index){
        municipis.remove(index);
    }
    public void removeMunicipi(Municipi aEsborrar){
        municipis.remove(aEsborrar);
    }
    
    public int getNumMunicipis(){
        return municipis.size();
    }
    public Municipi getMunicipi(int index) {
        return municipis.get(index);
    }

    public Iterator<Municipi> getMunicipiIterator(){
        return municipis.iterator();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.codi ^ (this.codi >>> 32));
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
        if (this.codi != other.codi) {
            return false;
        }
        return true;
    }
    
    
    
}
