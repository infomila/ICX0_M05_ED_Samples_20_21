package refactoring;

/**
 *
 * @author Usuari
 */
public class LaserjetPrinter extends Printer {

    public LaserjetPrinter(String inventoryId,  int numberOfColorCopies, int numberOfBlackAndWhiteCopies) {
      super( inventoryId,  PrinterType.HP_LASERJET_VII,  numberOfColorCopies,  numberOfBlackAndWhiteCopies);
    }
           
    
    @Override
    public double getFixedCost() {
        return 350.0;
    }

    @Override
    public double getBWCopyCost() {
        return 0.01;
    }

    @Override
    public double getColorCopyCost() {
        return 0.0;
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
