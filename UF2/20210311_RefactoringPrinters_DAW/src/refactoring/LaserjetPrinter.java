package refactoring;

/**
 *
 * @author Usuari
 */
public class LaserjetPrinter extends Printer {

    public LaserjetPrinter(String inventoryId, int numberOfColorCopies, int numberOfBlackAndWhiteCopies) {
        super(  inventoryId,
                PrinterType.HP_LASERJET_VII,
                numberOfColorCopies,
                numberOfBlackAndWhiteCopies);
    }

    @Override
    public double getFixedCost() {
        return 350.00;
    }

    @Override
    public double getCostBWCopy() {
        return 0.01;
    }

    @Override
    public double getCostColorCopy() {
        return 0;
    }

    @Override
    public String getName() {
        return "HP Laserjet VII";
    }

    @Override
    public boolean isColorSupported() {
        return false;
    }

}
