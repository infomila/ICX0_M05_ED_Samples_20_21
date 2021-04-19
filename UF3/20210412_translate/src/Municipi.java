/**
 *
 * @author Usuari
 */
public class Municipi {
    Provincia provincia;
    private long codi;
    private String nom;

    public Municipi(Provincia provincia, long codi, String nom) {
        this.codi = codi;
        this.nom = nom;
        //setProvincia(provincia);
        provincia.addMunicipi(this);

    }
        
    
    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia novaProvincia) { 
        // si ja són iguals no cal fer res....i evitem recursivitats.
        if( novaProvincia != this.provincia ){        
            // IMPORTANT: condició de salvaguarda per no petar
            // i evitar recusivitats
            if(!novaProvincia.contains(this)){
                novaProvincia.addMunicipi(this);                
            }
            this.provincia = novaProvincia;            
        }        
    }
    
    public boolean esCapital(){
        return this.equals(this.provincia.getCapital());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (this.codi ^ (this.codi >>> 32));
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
        final Municipi other = (Municipi) obj;
        if (this.codi != other.codi) {
            return false;
        }
        return true;
    }
    
    
}
