package refactoring;

/**
 *
 * @author Usuari
 */
public class TarificadorNewRelease extends Tarificador {

    @Override
    double getPrice(int daysRented) {
        return daysRented * 3;
    }

}
