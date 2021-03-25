package refactoring;

/**
 *
 * @author Usuari
 */
public class OfficejetPrinter extends Printer {

    public OfficejetPrinter(String inventoryId,  int numberOfColorCopies, int numberOfBlackAndWhiteCopies) {
      super( inventoryId,  PrinterType.HP_OFFICEJET_5,  numberOfColorCopies,  numberOfBlackAndWhiteCopies);
    }
           
    
    @Override
    public double getFixedCost() {
        return 125.0;
    }

    @Override
    public double getBWCopyCost() {
        return 0.01;
    }

    @Override
    public double getColorCopyCost() {
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
