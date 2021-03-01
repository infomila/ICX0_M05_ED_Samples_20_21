package refactoring;

/**
 *
 * @author Usuari
 */
public class TarificadorRegular extends Tarificador {

    
    
    @Override
    double getPrice(int daysRented) {
        double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }
  
}
