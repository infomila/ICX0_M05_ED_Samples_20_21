
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

    public void setCapital(Municipi capital) {
        this.capital = capital;
    }
    
    public boolean addMunicipi(Municipi nou){
        if(!municipis.contains(nou)){
            
            // el municipi pot pertànyer a una altra província
            Provincia pAnterior = nou.getProvincia();
            if(pAnterior !=null) {
                pAnterior.removeMunicipi(nou);
                municipis.add(nou);
                nou.setProvincia(this);
            } else {
                municipis.add(nou);
            }
            
            return true;
        } else {
            return false;
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
