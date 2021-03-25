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
                && !this.isColorSupported()) {
            //(printerType == Printer.HP_LASERJET_VII || printerType == Printer.RENTING_LASER_JET)) {
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

    public double getCost() {
        double cost = this.getFixedCost();
        cost += this.getNumberOfBlackAndWhiteCopies() * this.getCostBWCopy();
        cost += this.getNumberOfColorCopies() * this.getCostColorCopy();
        return cost;
    }

    public abstract double getFixedCost();

    public abstract double getCostBWCopy();

    public abstract double getCostColorCopy();

    public abstract String getName();

    public abstract boolean isColorSupported();
}
