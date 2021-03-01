package refactoring;

/**
 *
 * @author Usuari
 */
public class MovieRegular extends Movie {

    public MovieRegular(String title){
        super(title,Movie.REGULAR);
    }
    
    @Override
    double getRentalAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }
}
