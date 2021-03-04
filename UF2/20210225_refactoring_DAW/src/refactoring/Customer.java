package refactoring;

import refactoring.reports.StatementReport;
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

        StatementReport report = new StatementReport(this, mRentals);
        return report.getReport(DocType.TEXT);

    }

    public String statementHTML() {
        StatementReport report = new StatementReport(this, mRentals);
        return report.getReport(DocType.HTML);
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
