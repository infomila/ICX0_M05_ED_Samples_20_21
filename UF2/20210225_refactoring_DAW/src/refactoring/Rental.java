package refactoring;

//From book: 'Refactoring' by Martin Fowler
//This is the original code before refactoring begins

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

	private Movie _movie;
	private int _daysRented;
	
	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

    public double getRentalAmount() {
        return _movie.getRentalAmount(_daysRented);
    }

    public int getRenterPoints() {
        // add frequent renter points
        int frequentRenterPoints=1;
        // add bonus for a two day new release rental
        if ((this.getMovie().getPriceCode() == MovieType.NEW_RELEASE) && this.getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
	
	
	
}
