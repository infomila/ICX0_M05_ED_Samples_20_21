package refactoring;

/**
 *
 * @author bernat
 */
public class Printer {

    public static final int HP_LASERJET_VII = 1;
    public static final int HP_OFFICEJET_5 = 2;
    public static final int RENTING_LASER_JET = 3;
    
    private String inventoryId;
    private int printerType;
    private int numberOfColorCopies;
    private int numberOfBlackAndWhiteCopies;

    public Printer(String inventoryId, int printerType, int numberOfColorCopies, int numberOfBlackAndWhiteCopies) {
        this.inventoryId = inventoryId;
        this.printerType = printerType;
        this.numberOfColorCopies = numberOfColorCopies;
        this.numberOfBlackAndWhiteCopies = numberOfBlackAndWhiteCopies;
        
        
        if(this.numberOfColorCopies>0 && 
                ( printerType==Printer.HP_LASERJET_VII || printerType == Printer.RENTING_LASER_JET )) {
            throw new RuntimeException("This printer does not support color.");
        }
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public int getPrinterType() {
        return printerType;
    }

    public int getNumberOfColorCopies() {
        return numberOfColorCopies;
    }

    public int getNumberOfBlackAndWhiteCopies() {
        return numberOfBlackAndWhiteCopies;
    }
    
    
}
