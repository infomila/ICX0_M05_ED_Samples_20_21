
package refactoring.reports;

import refactoring.Customer;
import refactoring.Rental;

/**
 *
 * @author Usuari
 */
public class StatementReportFormat_Text extends StatementReportFormat{

    
    @Override
    public String getHeader(String customerName) {
        return "Rental Record for " + customerName + "\n";
    } 
    @Override
    public String getLine(Rental r) {
            return  "\t" + r.getMovie().getTitle() + "\t" + String.valueOf(r.getRentalAmount()) + "\n";
    }
    @Override
     public String getFooter(Customer c) {
        String result ="";
        result += "Amount owed is " + String.valueOf(c.getOwedAmount()) + "\n";
        result += "You earned " + String.valueOf(c.getFrequentRenterPoints()) + " frequent renter points";
        return result;
    }
    
}
