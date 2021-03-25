package refactoring;

/**
 *
 * @author bernat
 */
public abstract class Printer {



    private String inventoryId;
    private PrinterType printerType;
    private int numberOfColorCopies;
    private int numberOfBlackAndWhiteCopies;

    public Printer(String inventoryId, PrinterType printerType, int numberOfColorCopies, int numberOfBlackAndWhiteCopies) {
        this.inventoryId = inventoryId;
        this.printerType = printerType;
        this.numberOfColorCopies = numberOfColorCopies;
        this.numberOfBlackAndWhiteCopies = numberOfBlackAndWhiteCopies;

        if (this.numberOfColorCopies > 0
                && (printerType == PrinterType.HP_LASERJET_VII || printerType == PrinterType.RENTING_LASER_JET)) {
            throw new RuntimeException("This printer does not support color.");
        }
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public PrinterType getPrinterType() {
        return printerType;
    }

    public int getNumberOfColorCopies() {
        return numberOfColorCopies;
    }

    public int getNumberOfBlackAndWhiteCopies() {
        return numberOfBlackAndWhiteCopies;
    }

    double getCost() {

        double cost = getFixedCost();
        cost += getNumberOfBlackAndWhiteCopies() * getBWCopyCost();
        cost += getNumberOfColorCopies() * getColorCopyCost();
     
        return cost;
    }

    public abstract double getFixedCost();/* {

        if (getPrinterType() == Printer.HP_LASERJET_VII) {
            return 350.00;
        } else if (getPrinterType() == Printer.HP_OFFICEJET_5) {
            return 125.00;
        } else {
            return 0;
        }
    }*/

    public abstract double getBWCopyCost(); /*{

        if (getPrinterType() == Printer.HP_LASERJET_VII) {
            return 0.01;
        } else if (getPrinterType() == Printer.HP_OFFICEJET_5) {
            return 0.01;
        } else {
            return 0.06;
        }
    }*/

    public abstract double getColorCopyCost();/* {

        if (getPrinterType() == Printer.HP_LASERJET_VII) {
            return 0;
        } else if (getPrinterType() == Printer.HP_OFFICEJET_5) {
            return 0.07;
        } else {
            return 0;
        }
    }*/

    public abstract String getName();/* {
        if (getPrinterType() == Printer.HP_LASERJET_VII) {
            return "HP Laserjet VII";
        } else if (getPrinterType() == Printer.HP_OFFICEJET_5) {
            return "HP Office 5";
        } else {
            return "Renting";
        }
    }*/

    public abstract boolean isColorSupported();/* {
        if (getPrinterType() == Printer.HP_LASERJET_VII) {
            return false;
        } else if (getPrinterType() == Printer.HP_OFFICEJET_5) {
            return true;
        } else {
            return false;
        }
    }*/

}
