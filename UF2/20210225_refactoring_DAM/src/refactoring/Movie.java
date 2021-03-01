package refactoring;

// From book: 'Refactoring' by Martin Fowler
import java.util.logging.Level;
import java.util.logging.Logger;

// This is the original code before refactoring begins
public class Movie {

    private String mTitle;
    private MovieType mPriceCode;
    private Tarificador mTarificador;

    public Movie(String title, MovieType priceCode) {
        setTitle(title);
        setPriceCode(priceCode);
    }

    public MovieType getPriceCode() {
        return mPriceCode;
    }

    public void setPriceCode(MovieType priceCode) {
        mPriceCode = priceCode;

        Class c = priceCode.getTarificadorClass();        
     
        try {
            mTarificador = (Tarificador) c.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Price code no suportat");
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Price code no suportat");
        }
        /*
            switch(priceCode) {
            case REGULAR: mTarificador = new TarificadorRegular();break;
            case CHILDRENS: mTarificador = new TarificadorChildren();break;
            case NEW_RELEASE: mTarificador = new TarificadorNewRelease();break;
            default: throw new RuntimeException("price code no vàlid:"+priceCode);
            }*/
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    double getPrice(int daysRented) {
        return mTarificador.getPrice(daysRented);
    }

    /*double getPrice(int daysRented) {
        double thisAmount = 0;
        switch (this.getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (daysRented > 2) {
                    thisAmount += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3) {
                    thisAmount += (daysRented - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }*/
}
