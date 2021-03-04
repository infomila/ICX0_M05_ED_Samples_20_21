package refactoring;

import refactoring.reports.CustomerStatement;
import java.util.Iterator;
import java.util.LinkedList;
import refactoring.reports.DocType;

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

        CustomerStatement cs = new CustomerStatement(this, mRentals);
        return cs.getStatement(DocType.TEXT);
    }

    public String statementHTML() {

        CustomerStatement cs = new CustomerStatement(this, mRentals);
        return cs.getStatement(DocType.HTML);
    }

    public double getOwedAmount() {
        double totalAmount = 0;
        for (Rental curRental : mRentals) {
            totalAmount += curRental.getRentalPrice();
        }
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental curRental : mRentals) {
            frequentRenterPoints += curRental.getRenterPoints();
        }
        return frequentRenterPoints;
    }

}
