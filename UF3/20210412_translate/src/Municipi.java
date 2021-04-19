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
        setProvincia(provincia);

    }
        
    
    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        if(provincia==null) throw new RuntimeException("El municipi necessita una província");
                       
        if(provincia.addMunicipi(this)==false){
            if(this.provincia==null){
                throw new RuntimeException("Municipi ja existent a la província");
            }
        };
        this.provincia = provincia;
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
