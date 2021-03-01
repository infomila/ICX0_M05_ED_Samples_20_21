package refactoring;

/**
 *
 * @author Usuari
 */
public class TarificadorNewRelease  extends Tarificador {

 
    @Override
    double getRentalAmount(int daysRented) {
        return daysRented * 3;
    }
}