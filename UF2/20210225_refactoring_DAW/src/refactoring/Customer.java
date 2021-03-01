package refactoring;

import java.util.Iterator;
import java.util.LinkedList;

//From book: 'Refactoring' by Martin Fowler
//This is the original code before refactoring begins
public class Customer {

    private String mName;
    private LinkedList<Rental> mRentals = new LinkedList<Rental>();

    public Customer(String name) {
        mName = name;
    }

    public void addRental(Rental arg) {
        mRentals.add(arg);
    }

    public String getName() {
        return mName;
    }

    public String statement() {
       
        String result = "Rental Record for " + getName() + "\n";
        for (Rental curRental : mRentals) {
            // show figures for this rental
            result += "\t" + curRental.getMovie().getTitle() + "\t" + String.valueOf(curRental.getRentalAmount()) + "\n";
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getOwedAmount()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";

        return result;
    }

    public double getOwedAmount() {
        double totalAmount = 0;
        for (Rental curRental : mRentals) {
            totalAmount += curRental.getRentalAmount();
        }
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        int points = 0;
        for (Rental curRental : mRentals) {
            points += curRental.getRenterPoints();
        }
        return points;
    }

}
