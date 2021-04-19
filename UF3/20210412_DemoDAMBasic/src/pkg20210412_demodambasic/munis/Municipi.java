
package pkg20210412_demodambasic.munis;

/**
 *
 * @author Usuari
 */
public class Municipi {
    private long id;
    private String nom;
    
    private Provincia provincia;

    public Municipi(long id, String nom, Provincia provincia) {
        this.id = id;
        this.nom = nom;
        provincia.addMunicipi(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Provincia getProvincia() {
        return provincia;
    }
    
    public boolean esCapital(){
        return this.equals(this.provincia.getCapital());
    }
    
/*
    public void setProvincia(Provincia novaProvincia) { 
        boolean isNouMunicipi = this.provincia==null;
        if( novaProvincia != this.provincia){        
            if(this.provincia!=null) {
                this.provincia.removeMunicipi(this);
            }                   
            this.provincia = novaProvincia;
            if(novaProvincia.addMunicipi(this)==false){
                if(isNouMunicipi) 
                { // només per Municipis "nous"
                    throw new RuntimeException("No podem afegir dos vegades el mateix municipi a una província");
                }
            }
        }        
    }*/
    
    
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
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }
    
    //-----------------------------------
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
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
