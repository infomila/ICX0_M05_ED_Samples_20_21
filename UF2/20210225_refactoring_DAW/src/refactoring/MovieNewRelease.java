package refactoring;

/**
 *
 * @author Usuari
 */
public class MovieNewRelease  extends Movie {

    public MovieNewRelease(String title){
        super(title,Movie.NEW_RELEASE);
    }
    
    @Override
    double getRentalAmount(int daysRented) {
        return daysRented * 3;
    }
}