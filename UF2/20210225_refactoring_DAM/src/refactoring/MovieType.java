
package refactoring;

/**
 *
 * @author Usuari
 */
public enum MovieType {
    REGULAR(TarificadorRegular.class), 
    NEW_RELEASE(TarificadorNewRelease.class) ,
    CHILDRENS(TarificadorChildren.class);
    
    //----------------------------------
    private Class tarificadorClass;
    
    MovieType(Class tarificadorClass) {
        this.tarificadorClass = tarificadorClass;
    }

    public Class getTarificadorClass() {
        return tarificadorClass;
    }
    
    
}
