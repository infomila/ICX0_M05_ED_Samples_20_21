package refactoring;

/**
 *
 * @author Usuari
 */
public class MovieChildren extends Movie {

    public MovieChildren(String title) {
        super(title, Movie.CHILDRENS);
    }

    @Override
    double getPrice(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5;
        }
        return amount;
    }

}
