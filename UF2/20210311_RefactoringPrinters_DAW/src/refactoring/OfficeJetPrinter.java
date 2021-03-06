package refactoring;

/**
 *
 * @author Usuari
 */
public class OfficeJetPrinter extends Printer {

    public OfficeJetPrinter(String inventoryId, int numberOfColorCopies, int numberOfBlackAndWhiteCopies) {
        super(  inventoryId,
                PrinterType.HP_OFFICEJET_5,
                numberOfColorCopies,
                numberOfBlackAndWhiteCopies);
    }

    @Override
    public double getFixedCost() {
        return 125.00;
    }

    @Override
    public double getCostBWCopy() {
        return 0.01;
    }

    @Override
    public double getCostColorCopy() {
        return 0.07;
    }

    @Override
    public String getName() {
        return "HP Office 5";
    }

    @Override
    public boolean isColorSupported() {
        return true;
    }

}
