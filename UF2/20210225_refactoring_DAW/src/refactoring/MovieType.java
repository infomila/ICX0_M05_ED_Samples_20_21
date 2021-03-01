
package refactoring;

/**
 *
 * @author Usuari
 */
public enum MovieType {
    CHILDRENS( TarificadorChildren.class ) , 
    NEW_RELEASE (TarificadorNewRelease.class) ,
    REGULAR( TarificadorRegular.class) ;
    
    private Class tarificadorClass;
    
    MovieType(Class tarificadorClass){
        this.tarificadorClass = tarificadorClass;
    }
    
    public Class getTarificadorClass(){
        return this.tarificadorClass;
    }
}
