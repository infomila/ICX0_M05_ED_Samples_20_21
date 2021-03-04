package refactoring.reports;

import refactoring.Customer;
import refactoring.Rental;

/**
 *
 * @author Usuari
 */
public class CustomerStatementFormat_TEXT extends CustomerStatementFormat {

    @Override
    public String getHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

    @Override
    public String getLine(Rental curRental) {
        return "\t" + curRental.getMovie().getTitle() + "\t" + String.valueOf(curRental.getRentalPrice()) + "\n";
    }

    @Override
    public String getFooter(Customer customer) {
        String result = "Amount owed is " + String.valueOf(customer.getOwedAmount()) + "\n";
        result += "You earned " + String.valueOf(customer.getFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

}
