package refactoring;

/**
 *
 * @author Usuari
 */
public class RentingPrinter extends Printer {

    public RentingPrinter(String inventoryId, int numberOfColorCopies, int numberOfBlackAndWhiteCopies) {
        super(  inventoryId,
                PrinterType.RENTING_LASER_JET,
                numberOfColorCopies,
                numberOfBlackAndWhiteCopies);
    }

    @Override
    public double getFixedCost() {
        return 0.00;
    }

    @Override
    public double getCostBWCopy() {
        return 0.06;
    }

    @Override
    public double getCostColorCopy() {
        return 0;
    }

    @Override
    public String getName() {
        return "Renting";
    }

    @Override
    public boolean isColorSupported() {
        return false;
    }

}
