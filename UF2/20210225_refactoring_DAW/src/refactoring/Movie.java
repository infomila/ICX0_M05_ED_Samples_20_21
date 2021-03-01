package refactoring;

// From book: 'Refactoring' by Martin Fowler

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

// This is the original code before refactoring begins
public  class Movie {


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

    public void setPriceCode(MovieType type) {
        try {
            /*
            switch(type) {
            case REGULAR : mTarificador =       new TarificadorRegular();break;
            case NEW_RELEASE : mTarificador =   new TarificadorNewRelease();break;
            case CHILDRENS : mTarificador =     new TarificadorChildren();break;
            default: throw new RuntimeException("codi no vàlid!");
            }
            */
            Class c = type.getTarificadorClass();
            mTarificador = (Tarificador)c.newInstance();
            
            mPriceCode = type;
            
        } catch (InstantiationException ex) {
            Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Error creant el tarificador");
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Error creant el tarificador");
        }
    }

    public String getTitle() {
        return mTitle;
    }
    
    public void setTitle(String title){
        mTitle = title;
    }

    double getRentalAmount(int daysRented) {
        return mTarificador.getRentalAmount(daysRented);
    }
    
    /*double getRentalAmount(int daysRented) {
        double thisAmount = 0;
        //determine amounts for each line
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
