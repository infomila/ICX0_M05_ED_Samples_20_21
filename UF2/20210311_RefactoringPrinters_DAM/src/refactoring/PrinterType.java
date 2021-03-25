
package refactoring;

/**
 *
 * @author Usuari
 */
public enum PrinterType {
    HP_LASERJET_VII("HP Laserjet VII"),
    HP_OFFICEJET_5("HP Office 5"),
    RENTING_LASER_JET("Renting");
    
    String name;
    PrinterType(String theName){
        this.name = theName;
    }
     public String getName(){
         return this.name;
     }
}
